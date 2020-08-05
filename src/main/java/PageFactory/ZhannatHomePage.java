package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ZhannatHomePage {

    @FindBy(how = How.XPATH, using = "//div[@class='links']/a")
    public static WebElement loadLogin;

    @FindBy(how = How.ID, using = "email")
    public static WebElement loginEmail;

    @FindBy(how = How.ID, using = "password")
    public static WebElement loginPassword;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public static WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//a[@href='https://hr-staging.buffsci.org/staff-position-types']")
    public static WebElement positionTypesTab;

    @FindBy(how = How.ID, using = "DataTables_Table_0")
    public static WebElement positionTypesTable;

    @FindBy(how = How.ID, using = "DataTables_Table_0")
    public static WebElement allColumnsList;

    @FindBy(how = How.XPATH, using = "//tr[@role = 'row']/th")
    public static List<WebElement> allColumns;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary float-sm-right']" )
    public static WebElement addNewButton;

    @FindBy(how = How.NAME, using = "name" )
    public static WebElement addNewNameSection;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']" )
    public static WebElement saveButton;

    @FindBy(how = How.XPATH, using = "//input[@type='search']" )
    public static WebElement positionTypesSearch;

    @FindBy(how = How.XPATH, using = "//a[@data-name='SDMA54Test']" )
    public static WebElement editButton;

    @FindBy(how = How.ID, using = "delete-button")
    public static WebElement deleteButton;

    @FindBy(how = How.XPATH, using = "//div[@class = 'toast-message']")
    public static WebElement toastMessage;

}

