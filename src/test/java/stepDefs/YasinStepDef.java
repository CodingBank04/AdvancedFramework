package stepDefs;

import PageFactory.YasinHomePage;
import Utilities.AutomationContext;
import Utilities.WebElementMgr;
import io.cucumber.java.en.Then;
import managers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.NoSuchElementException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class YasinStepDef {
    AutomationContext context;

    public YasinStepDef(AutomationContext context) {
        this.context = context;
    }

    /**
     * Step to validate drop down list with expected list
     *
     * @param elementNm
     */
    @Then("^I validate the (\\w+) with below")
    public void I_validate_the_drop_down_list(String elementNm, List<String> expectedInList) throws Exception {
        List<WebElement> actualList = (List<WebElement>) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), elementNm);
        String expectedValue;
        String actualValue;
        boolean fail = false;
        System.out.println(actualList.size());
        for (int i = 0; i < actualList.size(); i++) {
            expectedValue = expectedInList.get(i);
            actualValue = actualList.get(i).getText();
            if (expectedValue == null && actualValue.isEmpty()) {
                context.getScenarioManager().getScenario().write(" Pass; \n Expected: " + expectedValue + " \n Found : " + actualValue + " /n Empty filter but working");
            } else {
                if (!actualValue.equals(expectedValue)) {
                    context.getScenarioManager().getScenario().write(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
                    fail = true;
                } else {
                    context.getScenarioManager().getScenario().write(" Pass; \n Expected: " + expectedValue + " \n Found : " + actualValue);
                }
            }
            if (fail) {
                throw new Exception("Fail; \n Expected:" + expectedValue + "\n Found : " + actualValue);
            }
        }

    }

    /**
     * Step to click on given WebElement list from a dropdown or multiselect element one by one in order
     *
     * @param elementNm
     * @param type
     */
    @Then("^I click one by one on given WebElement form  (\\w+) and validate the (\\w+) (dropdown|multiselect)$")
    public void i_click_on(String elementNm, String tableNm, String type) {
        List<WebElement> dropDownList = (List<WebElement>) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), elementNm);
        WebElement table = (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), tableNm);
        List<WebElement> data = new ArrayList<WebElement>();
        System.out.println("size of position drop down list:" + dropDownList.size());
        try {
            for (int i = 1; i < dropDownList.size(); i++) {
                int rows = 0;
                String rowNumber = "";
                data.clear();
                WebElement clickElement = dropDownList.get(i);
                FluentWait<WebDriver> wait = new WebDriverWait(Driver.getDriver(),
                        Long.parseLong(context.getConfigFileReader().getPropertyValue("fluentwait"))).
                        pollingEvery(Duration.ofSeconds(Long.parseLong(context.getConfigFileReader().getPropertyValue("waitPolling"))))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.visibilityOf(clickElement));
                try {
                    try {
                        clickElement.click();
                        rowNumber = YasinHomePage.showingNumber.getText();
                        int num = 0, res = 0;
                        // Start traversing the given string
                        for (int k = 0; k < rowNumber.length(); k++) {
                            // If a numeric value comes, start converting
                            // it into an integer till there are consecutive
                            // numeric digits
                            if (Character.isDigit(rowNumber.charAt(k)))
                                num = num * 10 + (rowNumber.charAt(k) - '0');
                                // Update maximum value
                            else {
                                res = Math.max(res, num);
                                // Reset the number
                                num = 0;
                            }
                        }
                        rows = Math.max(res, num);
                    } catch (Exception e) {
                        clickElement.sendKeys(Keys.RETURN);
                    }
                    context.getScenarioManager().getScenario().write("Clicked on " + dropDownList.get(i).getText() + " Row number:" + rows);
                } catch (Exception e) {
                    context.getScenarioManager().getScenario().write("Unable to click on " + elementNm + "; Error encountered:" + e.getMessage());
                    throw new Exception("Unable to click on " + elementNm + "; Error encountered:" + e.getMessage());
                }
                System.out.println("+++++++++++++++++");
                if (rows != 0) {
                    for (int j = 1; j <= rows; j++) {
                        data.add(table.findElement(By.xpath("tr[' + j + ']/td[2]")));
                        //System.out.println(data.get(j - 1).getText());
                        if (dropDownList.get(i).getText().equals(data.get(j - 1).getText())) {
                            context.getScenarioManager().getScenario().write(" Pass; \n Expected: " + dropDownList.get(i).getText() + " \n Found : " + data.get(j - 1).getText());
                        } else {
                            context.getScenarioManager().getScenario().write(" Fail; \n Expected: " + dropDownList.get(i).getText() + " \n Found : " + data.get(j - 1).getText());
                        }
                    }
                } else {
                    context.getScenarioManager().getScenario().write(" Pass; \n But There is no any record");
                }
            }
            context.getScenarioManager().getScenario().write("Selected " + elementNm + " from " + elementNm + " " + type);
        } catch (Exception e) {
            context.getScenarioManager().getScenario().write("Unable to Select " + elementNm + " from " + elementNm + " " + type + "; Error encountered:" + e.getMessage());
        }
    }

}

