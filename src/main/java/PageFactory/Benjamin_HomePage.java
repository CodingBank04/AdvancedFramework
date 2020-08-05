package PageFactory;

import Utilities.AutomationContext;
import Utilities.ConfigFileReader;
import managers.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Benjamin_HomePage {


    // sign up button
    @FindBy(how = How.ID, using = "sign-up")
    public static WebElement signUpButton;

    // job application title
    @FindBy(how = How.XPATH, using = "//div[@class='card-header h5 text-white text-center']")
    public static WebElement jobApplicationTitle;

    // sign up header
    @FindBy(how = How.XPATH, using = "//h5[@class='card-title text-center']")
    public static WebElement signUpHeader;

    // Register button
    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-lg btn-primary btn-block text-uppercase']")
    public static WebElement registerButton;

    // Sign up with google button
    @FindBy(how = How.XPATH, using = "//a[@class='btn btn-lg btn-google btn-block text-uppercase']")
    public static WebElement signUpWithGoogleButton;

    public static void clickSignUp() {
      signUpButton.click();
    }

    public static void login(){
     //   String username = context.getConfigFileReader().getPropertyValue("username");
    }


}
