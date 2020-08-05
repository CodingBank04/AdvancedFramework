package stepDefs;

import PageFactory.CananHomePage;
import PageFactory.YasinHomePage;
import Utilities.AutomationContext;
import Utilities.WebElementMgr;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CananStepDef {
    AutomationContext context;

    public CananStepDef(AutomationContext context) {

        this.context = context;
    }

    @Then("I validate Select on New Hire drop down list below")
    public void iValidateSelectOnNewHireDropDownListBelow(List<String> expectedTypes) throws Exception {
        ArrayList<WebElement> actualTypes = (ArrayList<WebElement>) Driver.getDriver().findElements(By.cssSelector("select[class='form-control']"));
        String expectedValue;
        String actualValue;
        for (int i = 1; i < actualTypes.size() / 2; i++) {
            expectedValue = expectedTypes.get(i - 1).trim();
            actualValue = actualTypes.get(i).getText().trim();
            if (!actualValue.equals(expectedValue)) {
                context.getScenarioManager().getScenario().write(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
                throw new Exception(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
            } else {
                context.getScenarioManager().getScenario().write(" Pass; \n Expected: " + expectedValue + " \n Found : " + actualValue);
            }
        }

    }

    @Then("I validate Select on Termination drop down list below")
    public void iValidateSelectOnTerminationDropDownListBelow(List<String> expectedTypes) throws Exception {
        ArrayList<WebElement> actualTypes = (ArrayList<WebElement>) Driver.getDriver().findElements(By.cssSelector("select[class='form-control']"));
        String expectedValue;
        String actualValue;
        for (int i = 1; i < actualTypes.size() / 2; i++) {
            expectedValue = expectedTypes.get(i - 1).trim();
            actualValue = actualTypes.get(i).getText().trim();
            if (!actualValue.equals(expectedValue)) {
                context.getScenarioManager().getScenario().write(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
                throw new Exception(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
            } else {
                context.getScenarioManager().getScenario().write(" Pass; \n Expected: " + expectedValue + " \n Found : " + actualValue);
            }
        }

    }

    @Then("I validate sections on Locations drop down list below")
    public void iValidate_sections_locationation_dropdownlistbelow(List<String> expectedTypes) throws Exception {
        ArrayList<WebElement> actualTypes = (ArrayList<WebElement>) Driver.getDriver().findElements(By.xpath("//select[@name='location_id'][@class='form-control']"));
        String expectedValue;
        String actualValue;
        for (int i = 1; i < actualTypes.size() / 2; i++) {
            expectedValue = expectedTypes.get(i - 1).trim();
            actualValue = actualTypes.get(i).getText().trim();
            if (!actualValue.equals(expectedValue)) {
                context.getScenarioManager().getScenario().write(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
                throw new Exception(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
            } else {
                context.getScenarioManager().getScenario().write(" Pass; \n Expected: " + expectedValue + " \n Found : " + actualValue);
            }
        }

    }

    /**
     * Step to select given value from a dropdown or multiselect element
     *
     * @param indexVal
     * @param elementNm
     * @param type
     */
    @Then("^I select by index (\\w+) from (\\w+) (dropdown|multiselect)$")
    public void i_select(int indexVal, String elementNm, String type) {
        WebElement selectElement = (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), elementNm);
        try {
            Select sel = new Select(selectElement);
            sel.selectByIndex(indexVal);
            context.getScenarioManager().getScenario().write("Selected " + indexVal + " from " + elementNm + " " + type);
        } catch (Exception e) {
            context.getScenarioManager().getScenario().write("Unable to Select " + indexVal + " from " + elementNm + " " + type + "; Error encountered:" + e.getMessage());
        }
    }

    @Then("I validate Select on Position Location drop down list below")
    public void iValidateSelectOnPositionLocationDropDownListBelow(List<String> expectedTypes) throws Exception {
        ArrayList<WebElement> actualTypes = (ArrayList<WebElement>) Driver.getDriver().findElements(By.xpath("//select[@class='filter ml-4'][1]"));
        String expectedValue;
        String actualValue;
        for (int i = 1; i < actualTypes.size() / 2; i++) {
            expectedValue = expectedTypes.get(i - 1).trim();
            actualValue = actualTypes.get(i).getText().trim();
            if (!actualValue.equals(expectedValue)) {
                context.getScenarioManager().getScenario().write(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
                throw new Exception(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
            } else {
                context.getScenarioManager().getScenario().write(" Pass; \n Expected: " + expectedValue + " \n Found : " + actualValue);
            }
        }

    }
    /**
     * Step to click on given WebElement list from a dropdown or multiselect element one by one in order
     *
     * @param elementNm
     * @param type
     */
    @Then("^I click one by one on given WebElement from  (\\w+) and validate the (\\w+) (dropdown|multiselect)$")
    public void i_click_on(String elementNm, String tableNm,String type) {
        List<WebElement> dropDownList = (List<WebElement>) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), elementNm);
        WebElement table = (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), tableNm);
        List<WebElement> data = new ArrayList<WebElement>();
        System.out.println("size of location drop down list:"+ dropDownList.size());
        try {
            for (int i = 1; i < dropDownList.size(); i++) {
                int rows=0;
                String rowNumber="";
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
                        rowNumber= CananHomePage.ShowingNumber.getText();
                        int num = 0, res = 0;
                        // Start traversing the given string
                        for (int k = 0; k<rowNumber.length(); k++)
                        {
                            // If a numeric value comes, start converting
                            // it into an integer till there are consecutive
                            // numeric digits
                            if (Character.isDigit(rowNumber.charAt(k)))
                                num = num * 10 + (rowNumber.charAt(k)-'0');
                                // Update maximum value
                            else
                            {
                                res = Math.max(res, num);
                                // Reset the number
                                num = 0;
                            }
                        }
                        rows=Math.max(res, num);
                    } catch (Exception e) {
                        clickElement.sendKeys(Keys.RETURN);
                    }
                    context.getScenarioManager().getScenario().write("Clicked on " + dropDownList.get(i).getText()+" Row number:"+rows);
                } catch (Exception e) {
                    context.getScenarioManager().getScenario().write("Unable to click on " + elementNm + "; Error encountered:" + e.getMessage());
                    throw new Exception("Unable to click on " + elementNm + "; Error encountered:" + e.getMessage());
                }
                System.out.println("+++++++++++++++++");
                if (rows!=0) {
                    for (int j = 1; j <= rows; j++) {
                        data.add(table.findElement(By.xpath("tr[' + j + ']/td[1]")));
                        //System.out.println(data.get(j - 1).getText());
                        if (dropDownList.get(i).getText().equals(data.get(j-1).getText())){
                            context.getScenarioManager().getScenario().write(" Pass; \n Expected: " + dropDownList.get(i).getText() + " \n Found : " + data.get(j-1).getText());
                        }
                        else {
                            context.getScenarioManager().getScenario().write(" Fail; \n Expected: " + dropDownList.get(i).getText() + " \n Found : " + data.get(j-1).getText());
                        }
                    }
                }else{
                    context.getScenarioManager().getScenario().write(" Pass; \n But There is no any record");
                }
            }
            context.getScenarioManager().getScenario().write("Selected " + elementNm + " from " + elementNm + " " + type);
        }
        catch (Exception e) {
            context.getScenarioManager().getScenario().write("Unable to Select " + elementNm + " from " + elementNm + " " + type + "; Error encountered:" + e.getMessage());
        }
    }
    @When("I login to application module")
    public void i_login_to_application_module() throws Exception {
        WebElement signInEmail = (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), "signInEmail");
        WebElement signInPassword = (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), "signInPassword");
        WebElement signInSubmit = (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), "signInSubmit");

        signInEmail.sendKeys("test@email.com");
        Thread.sleep(1000);
        signInPassword.sendKeys("12345678");
        Thread.sleep(1000);
        signInSubmit.click();
        Thread.sleep(1000);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://apply-testing.buffsci.org/job";
        if (!expectedUrl.equals(actualUrl)) {
            context.getScenarioManager().getScenario().write(" Fail; \n Expected url: " + expectedUrl + " \n Found url: " + actualUrl);
            throw new Exception(" Fail; \n Expected url: " + expectedUrl + " \n Found url: " + actualUrl);
        } else {
            context.getScenarioManager().getScenario().write(" Pass; \n Expected url: " + expectedUrl + " \n Found url: " + actualUrl);
        }
    }
}


