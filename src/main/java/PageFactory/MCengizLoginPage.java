package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MCengizLoginPage {

    @FindBy(how = How.XPATH, using = "//a[text()='Login']")
    public static WebElement loadLogin;

    @FindBy (how = How.ID, using = "email")
    public static WebElement emailSection;

    @FindBy (how= How.ID, using = "password")
    public static WebElement passwordSection;

    @FindBy (how = How.XPATH, using = "//button[@type='submit']")
    public static WebElement loginButton;




}