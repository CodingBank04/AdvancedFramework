package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import javax.swing.border.EmptyBorder;
import java.util.List;

public class YasinHomePage {

    @FindBy(how = How.XPATH, using = "//div[@class='links']/a")
    public static WebElement loadLogin;

    @FindBy (how = How.ID, using = "email")
    public static WebElement emailSection;

    @FindBy (how= How.ID, using = "password")
    public static WebElement passwordSection;

    @FindBy (how = How.XPATH, using = "//button[@type='submit']")
    public static WebElement loginButton;

    @FindBy(how = How.CSS, using = "div[class='top-right links'] a[href='https://hr-staging.buffsci.org/login']")
    public static WebElement topLoadButton;

    @FindBy (how= How.CSS,using = "a[href='https://hr-staging.buffsci.org/staff-positions']")
    public static WebElement positionsTabButton;

    @FindBy (how=How.CSS,using="select[class='filter ml-4'][name='position_type_id'] ")
    public static WebElement positionTabSelectPositionsDropDown;

    @FindBy (how=How.XPATH,using="//select[@class='filter ml-4'][@name='position_type_id']/option")
    public static List<WebElement> positionDropDownList;

    @FindBy(how=How.XPATH,using="//table[@id='DataTables_Table_0']/tbody")
    public static WebElement positionPageTable;

    @FindBy(how=How.XPATH,using="//*[contains(text(),'Showing')]")
    public static WebElement showingNumber;

    @FindBy(how=How.XPATH,using = "//a[contains(text(),'Add New')]")
    public static WebElement addNewPositions;

    @FindBy(how=How.XPATH,using = "//select[@name='position_type_id'][@class='form-control']/option[2]")
    public static WebElement positionTypeOnAddNewPosition;

    @FindBy(how=How.CSS,using="input[name='title']")
    public static WebElement titleOnNewPosition;

    @FindBy(how = How.XPATH,using = "//*[@id='staff-positions-form']/div[2]/div/div[4]/select/option[2]")
    public static WebElement reportsToOnNewPosition;

    @FindBy(how=How.XPATH,using="//select[@name='location_id'][@class='form-control']/option[2]")
    public static WebElement locationOnNewPosition;

    @FindBy(how=How.CSS,using="#staff-positions-form > div.modal-footer > button")
    public static WebElement saveButtonOnNewPosition;

    @FindBy(how=How.XPATH,using="//input[@type='search']")
    public static WebElement searchBoxOnPositionPage;

    @FindBy(how=How.XPATH,using="//table[@id='DataTables_Table_0']/tbody/tr[1]/td[3]")
    public static WebElement createdNewPositionTitle;

    @FindBy(how=How.XPATH,using = "//i[@class=\"fa fa-trash\"]")
    public static WebElement deleteCreatedPositionTitle;

    @FindBy(how=How.XPATH,using="//button[text()='OK']")
    public static WebElement confirmToDelete;









}