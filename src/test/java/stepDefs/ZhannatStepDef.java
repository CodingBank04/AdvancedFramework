package stepDefs;

import Utilities.AutomationContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class ZhannatStepDef {



    AutomationContext context;

    public ZhannatStepDef(AutomationContext context) {
        this.context = context;
    }

   /* @Then("I am on the ZhannatHomePage")
    public void i_am_on_the_ZhannatHomePage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }*/

    @When("I click on Position Type")
    public void i_click_on_Position_Type() {

    }

    /*@Then("I should see following {string} on the Position Types Page")
    public void i_should_see_following_on_the_Position_Types_Page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }*/

    @Then("I should see following columns on the Position Types Page")
    public void i_should_see_following_columns_on_the_Position_Types_Page(List<String> expectedColumns) throws Exception {
        ArrayList<WebElement> actualColumns = (ArrayList<WebElement>) Driver.getDriver().findElements(By.xpath("//tr[@role = 'row']/th"));
        String expectedValue;
        String actualValue;
        for(int i = 0; i < actualColumns.size(); i++){
            expectedValue = expectedColumns.get(i);
            actualValue = actualColumns.get(i).getText();

            if (!actualValue.equals(expectedValue)) {
                context.getScenarioManager().getScenario().write(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
                throw new Exception(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
            } else {
                context.getScenarioManager().getScenario().write(" Pass; \n Expected: " + expectedValue + " \n Found : " + actualValue);
            }
        }
    }


    @Then("^I validate alert page has option OK to delete entry$")
    public void i_validate_alert_page_has_option_OK() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert deleteAlert = Driver.getDriver().switchTo().alert();
            //String expectedDeleteAlertMessage = "You are about to delete the record. Are you sure?";
           // String actualDeleteAlertMessage = deleteAlert.getText();
            deleteAlert.accept();

        } catch (Exception e) {
            //exception handling
        }
    }

    @Then("^I validate alert page is displayed$")
    public void i_validate_alert_page_is_displayed() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert deleteAlert = Driver.getDriver().switchTo().alert();
            String expectedDeleteAlertMessage = "You are about to delete the record. Are you sure?";
            String actualDeleteAlertMessage = deleteAlert.getText();
            Assert.assertEquals(expectedDeleteAlertMessage,actualDeleteAlertMessage);
           // deleteAlert.accept();

        } catch (Exception e) {
            //exception handling
        }
    }




  /*  @Then("I should see following {string} on the Position Types Page")
    public void i_should_see_following_on_the_Position_Types_Page(List<String> expectedColumns) throws Exception  {
        ArrayList<WebElement> actualColumns = (ArrayList<WebElement>) Driver.getDriver().findElements(By.xpath("//tr[@role = 'row']/th"));
        String expectedValue;
        String actualValue;
        for(int i = 0; i < actualColumns.size(); i++){
            expectedValue = expectedColumns.get(i);
            actualValue = actualColumns.get(i).getText();

            if (!actualValue.equals(expectedValue)) {
                context.getScenarioManager().getScenario().write(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
                throw new Exception(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
            } else {
                context.getScenarioManager().getScenario().write(" Pass; \n Expected: " + expectedValue + " \n Found : " + actualValue);
            }
        }
    }*/
}
