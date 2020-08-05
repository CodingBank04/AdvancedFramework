package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SabireHomePage {

    @FindBy(how = How.XPATH, using = "//div[@class='links']/a")
    public static WebElement loadLogin;
    @FindBy(how=How.XPATH, using ="//a[@href='https://hr-staging.buffsci.org/staff-positions']")
    public static WebElement positions;
    @FindBy(how= How.XPATH,using ="//a[@href='https://hr-staging.buffsci.org/home']")
    public  static WebElement staff;
    @FindBy(how=How.XPATH, using ="//a[@href='https://hr-staging.buffsci.org/staff-position-types']")
    public static WebElement positionType;
    @FindBy(how=How.XPATH,using = "//a[@href='https://hr-staging.buffsci.org/permissions']")
    public  static WebElement permission;
    @FindBy(how=How.XPATH, using = "//a[@href='https://hr-staging.buffsci.org/snapshot']")
    public static WebElement snapshot;
    @FindBy(how=How.XPATH,using="//a[@href='https://hr-staging.buffsci.org/applicants']")
    public static WebElement applicants;
   @FindBy(how=How.XPATH,using="//ul[@role='menu']")
    public  static WebElement menu;
   @FindBy(how=How.XPATH,using="/html/body/div/aside/div/div[6]/div/div/nav/ul")
    public static WebElement options;
   @FindBy(how=How.XPATH,using="//div[@class='card-body']/div/select[2]")
    public static WebElement location;
   @FindBy(how=How.XPATH,using="//input[@type='search']")
    public static WebElement searchBox;
   @ FindBy(how=How.XPATH,using="//li[@class='paginate_button page-item next disabled']")
    public static WebElement clickElement;
   @FindBy(how=How.XPATH,using="//table[@class='table table-striped dataTable no-footer dtr-inline collapsed']/tbody/tr/td[2]")
    public static WebElement dataTable;
   @FindBy(how=How.XPATH,using="//a[contains(text(),'Next')]")
    public static WebElement clickNext;
   @FindBy(how=How.XPATH,using="//a[@href='#details-tab']")
    public static WebElement details;
   @FindBy (how=How.CSS,using="#details-tab > div > div > div > button")
    public static WebElement editDetails;
   @FindBy(how=How.XPATH,using="//footer[@id='detailsDataModal___BV_modal_footer_']/button[2]")
    public static WebElement saveButton;
 @FindBy(how=How.XPATH,using="//*[@id='detailsDataForm']/div/div[10]")
    public static WebElement popupUpdate;
 @FindBy(how=How.XPATH,using="//button[contains(text(),'Save')]")
    public static WebElement popupSave;
 @FindBy(how=How.XPATH,using="//button[contains(text(),'Cancel')]")
    public static WebElement popupCancel;
    @FindBy(how=How.ID, using="sign-up")
    public static WebElement signUpButton;
    @FindBy(how=How.ID, using="first-name")
    public static WebElement firstNameOnSignUp;
    @FindBy(how=How.ID, using="last-name")
    public static WebElement lastNameOnSignUp;
    @FindBy(how=How.ID, using="inputEmail")
    public static WebElement emailOnSignUp;
    @FindBy(how=How.ID, using="inputPassword")
    public static WebElement passwordOnSignUp;
    @FindBy(how=How.ID, using="inputConfirmPassword")
    public static WebElement confirmPasswordOnSignUp;
    @FindBy(how=How.XPATH,using="//button[@type='submit']")
    public static WebElement registration;






}