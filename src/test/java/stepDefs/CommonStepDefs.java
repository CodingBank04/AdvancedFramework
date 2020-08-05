package stepDefs;

import Utilities.AutomationContext;
import Utilities.ExcelHelper;
import Utilities.WebElementMgr;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.NoSuchElementException;

public class CommonStepDefs {

    AutomationContext context;

    public CommonStepDefs(AutomationContext context) {
        this.context = context;
    }

    @Given("^I click on (\\w+)$")
    public void i_click_on_button(String elementNm) throws Exception {
        WebElement clickElement = (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), elementNm);
        FluentWait<WebDriver> wait = new WebDriverWait(Driver.getDriver(),
                Long.parseLong(context.getConfigFileReader().getPropertyValue("fluentwait"))).
                pollingEvery(Duration.ofSeconds(Long.parseLong(context.getConfigFileReader().getPropertyValue("waitPolling"))))
                .ignoring(NoSuchElementException.class);
         wait.until(ExpectedConditions.visibilityOf(clickElement));
        try {

            try{
                clickElement.click();
            }
            catch (Exception e){
                clickElement.sendKeys(Keys.RETURN);
            }

            context.getScenarioManager().getScenario().write("Clicked on " + elementNm);
        } catch (Exception e) {
            context.getScenarioManager().getScenario().write("Unable to click on " + elementNm + "; Error encountered:" + e.getMessage());
            throw new Exception("Unable to click on " + elementNm + "; Error encountered:" + e.getMessage());
        }
    }

    /**
     * Step to select given value from a dropdown or multiselect element
     * @param selectionVal
     * @param elementNm
     * @param type
     */
    @Then("^I select (\\w+) from (\\w+) (dropdown|multiselect)$")
    public void i_select(String selectionVal, String elementNm, String type) {
        WebElement selectElement = (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), elementNm);
        try {
            Select sel = new Select(selectElement);
            sel.selectByValue(selectionVal);
            context.getScenarioManager().getScenario().write("Selected " + selectionVal + " from " + elementNm + " " + type);
        } catch (Exception e) {
            context.getScenarioManager().getScenario().write("Unable to Select " + selectionVal + " from " + elementNm + " " + type + "; Error encountered:" + e.getMessage());
        }
    }

    /**
     * Step enters given value in the element text input field
     * @param value
     * @param elementNm
     */
    @Then("^I enter \"([^\"]*)\" in (\\w+)$")
    public void i_enter_given_value(String value, String elementNm) {
        WebElement editElement = (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), elementNm);
        try{
            editElement.click();
        }
        catch (Exception e){
            editElement.sendKeys(Keys.RETURN);
        }
        try {
            editElement.clear();
            editElement.sendKeys(value);
            context.getScenarioManager().getScenario().write("Entered value " + value + " in " + elementNm);
        } catch (Exception e) {
            context.getScenarioManager().getScenario().write("Unable to enter value " + value + " in " + elementNm + "; Error encountered:" + e.getMessage());
        }
    }

    /**
     * Step stores a given element's attribute/text in a cache key
     * Ex: I store courseHeader text in "coursekey"
     * @param elementNm
     * @param attr
     * @param key
     */
    @Then("^I store (\\w+) (\\w+) in \"(.*)\"$")
    public void i_enter_given_value(String elementNm, String attr, String key) {
        WebElement storeElement = (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), elementNm);
        storeElement.click();
        if(attr.equalsIgnoreCase("text")) {
            context.setContextCache(key,storeElement.getAttribute("innerHTML"));
        } else{
            context.setContextCache(key,storeElement.getAttribute(attr));
        }
        context.getScenarioManager().getScenario().write("Stored "+storeElement.getAttribute("innerHTML")+ " in "+key+" :"+context.getContextCache(key));
    }

    @Then("^I read excel file \"(.*)\" and store$")
    public void i_read_excel(String fileNm) {
        context.setHashMapDataCache(fileNm, ExcelHelper.readExcelInput(fileNm));
        context.getScenarioManager().getScenario().write("excel data:"+context.getHashMapDataCache(fileNm));
    }

    @When("I login")
    public void iLogin() throws Exception {
        WebElement loadLogin = (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), "loadLogin");
        WebElement emailSection = (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), "emailSection");
        WebElement passwordSection = (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), "passwordSection");
        WebElement loginButton = (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), "loginButton");

        try{
            loadLogin.click();
        }
        catch (Exception e){
            loadLogin.sendKeys(Keys.RETURN);
        }
        Thread.sleep(1000);
        emailSection.sendKeys("admin@staging-buffsci.org");
        Thread.sleep(1000);
        passwordSection.sendKeys("admin123test");
        Thread.sleep(1000);
        loginButton.click();
        Thread.sleep(1000);
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://hr-testing.buffsci.org/home";
        if (!expectedUrl.equals(actualUrl)) {
            context.getScenarioManager().getScenario().write(" Fail; \n Expected url: " +expectedUrl + " \n Found url: " + actualUrl);
            throw new Exception(" Fail; \n Expected url: " +expectedUrl + " \n Found url: " + actualUrl);
        }else {
            context.getScenarioManager().getScenario().write(" Pass; \n Expected url: " +expectedUrl + " \n Found url: " + actualUrl);
        }




    }
}
