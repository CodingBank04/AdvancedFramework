package stepDefs;

import Utilities.AutomationContext;
import Utilities.WebElementMgr;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import managers.Driver;
import org.openqa.selenium.support.PageFactory;


public class Benjamin_SignUpPageStepDefs {

    AutomationContext context;
    public Benjamin_SignUpPageStepDefs(AutomationContext context){
        this.context = context;
    }


    @Given("navigating to the website")
    public void navigating_to_the_website() {
         // clickSignUp(); not working!
        //Driver.getDriver().get("https://apply-staging.buffsci.org"); // working but use nextline
        Driver.getDriver().get(context.getConfigFileReader().getPropertyValue("url"));

    }

    @When("clicking on sign up button")
    public void clicking_on_sign_up_button() throws InterruptedException {
        //System.out.println(context.getPageObjectMgr().getCurrentPage());

        Thread.sleep(1000);
        Driver.getDriver().findElementById("sign-up").click();

        String title = Driver.getDriver().getTitle();
        System.out.println("Landing page verified: " + title);

    }

    @Then("validate the new sign up page")
    public void validate_the_new_sign_up_page() {
      String signUpText = Driver.getDriver().findElementByXPath("//h5[@class='card-title text-center']").getText();
      String jobApplicationText = Driver.getDriver().findElementByXPath("//div[@class='card-header h5 text-white text-center']").getText();

      System.out.println("Landing page header: " + jobApplicationText + "\n" +
                         "Landing page sub header: " + signUpText);


       // find where the quit is located and replace the code below.
       Driver.getDriver().quit();
       // tearDown();
    }
}
