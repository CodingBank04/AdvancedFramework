package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.util.List;

public class MCengizStaffPage {

    @FindBy(how = How.XPATH, using = "//button[text()='New Hire']")
    public static WebElement newHireButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"newHireForm\"]/div/div[10]/input[2]")
    public static WebElement fileUpload;

    @FindBy(how = How.XPATH, using = "//button[text()='Termination']")
    public static WebElement terminateButton;

    @FindBy(how = How.ID, using = "terminationModal___BV_modal_title_")
    public static WebElement terminatePopUp;

    @FindBy(how = How.XPATH, using = "//div[@class='row']/div[4]/div")
    public static WebElement positionLocation;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Positions')]")
    public static WebElement PositionsMenu;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Add New')]")
    public static WebElement AddNewPosition;

    @FindBy(how = How.ID, using = "staff-positions-form")
    public static WebElement staffPositionForm;

    @FindBy(how = How.XPATH, using = "//div[@id='v-pills-tab']/select[1]")
    public static WebElement JobFilter;

    @FindBy(how = How.XPATH, using = "//div[@id='v-pills-tab']/select[1]/option")
    public static WebElement JobFilterDropdownList;

    @FindBy(how = How.ID, using = "75018")
    public static WebElement sampleStaff;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-secondary']")
    public static WebElement editHomeButton;

    @FindBy(how = How.XPATH, using = "//div[@id=\"addressModal___BV_modal_body_\"]/div/div[1]/input")
    public static WebElement HomeAddressLine1;

    @FindBy(how = How.XPATH, using = "//div[@id=\"addressModal___BV_modal_body_\"]/div/div[2]/input")
    public static WebElement HomeAddressLine2;

    @FindBy(how = How.XPATH, using = "//div[@id=\"addressModal___BV_modal_body_\"]/div/div[3]/input")
    public static WebElement HomeAddressCity;

    @FindBy(how = How.XPATH, using = "//div[@id=\"addressModal___BV_modal_body_\"]/div/div[5]/input")
    public static WebElement HomeAddressZipCode;

    @FindBy(how = How.XPATH, using = "//footer[@id=\"addressModal___BV_modal_footer_\"]/button[2]")
    public static WebElement HomeAddressSaveButton;

    @FindBy(how = How.XPATH, using = "(//div[@class='form-control'])[10]")
    public static WebElement HomeAddress;

    @FindBy(how = How.XPATH, using = "//button[text()='Edit Basic Info']")
    public static WebElement EditBasicInfoButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basicInfoForm\"]/div/div[1]/select")
    public static WebElement EditBasicInfoStatusSelect;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basicInfoForm\"]/div/div[1]/select/option[2]")
    public static WebElement EditBasicInfoStatusInactive;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basicInfoForm\"]/div/div[1]/select/option[1]")
    public static WebElement EditBasicInfoStatusActive;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basicInfoForm\"]/div/div[2]/select")
    public static WebElement EditBasicInfoSalutationSelect;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basicInfoForm\"]/div/div[2]/select/option[2]")
    public static WebElement EditBasicInfoSalutationMs;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basicInfoForm\"]/div/div[2]/select/option[5]")
    public static WebElement EditBasicInfoSalutationMr;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basicInfoModal___BV_modal_footer_\"]/button[2]")
    public static WebElement EditBasicInfoSaveButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basicInfoForm\"]/div/div[4]/input")
    public static WebElement EditBasicInfoFirstName;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basicInfoForm\"]/div/div[5]/input")
    public static WebElement EditBasicInfoMiddleName;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basicInfoForm\"]/div/div[6]/input")
    public static WebElement EditBasicInfoLastName;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basicInfoForm\"]/div/div[7]/div/input")
    public static WebElement EditBasicInfoPhoneExtension;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basicInfoForm\"]/div/div[8]/input")
    public static WebElement EditBasicInfoRoom;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basicInfoForm\"]/div/div[9]/div/input")
    public static WebElement EditBasicInfoEmail;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basicInfoForm\"]/div/div[10]/div/input")
    public static WebElement EditBasicInfoPersonalEmail;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basicInfoForm\"]/div/div[11]/div/input")
    public static WebElement EditBasicInfoCellPhone;

    @FindBy(how = How.XPATH, using = "//*[text()='Full Name:']/following-sibling::*")
    public static WebElement BasicInfoFirstName;

    @FindBy(how = How.XPATH, using = "//*[text()='Status:']/following-sibling::*")
    public static WebElement BasicInfoStatus;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basic-tab\"]/div/div[1]/div/div[5]/div/div[2]")
    public static WebElement BasicInfoPhoneExtension;

    @FindBy(how = How.XPATH, using = "//*[text()='Room:']/following-sibling::*")
    public static WebElement BasicInfoRoom;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basic-tab\"]/div/div[1]/div/div[7]/div/div[2]")
    public static WebElement BasicInfoEmail;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basic-tab\"]/div/div[1]/div/div[8]/div/div[2]")
    public static WebElement BasicInfoPersonalEmail;

    @FindBy(how = How.XPATH, using = "//*[@id=\"basic-tab\"]/div/div[1]/div/div[9]/div/div[2]")
    public static WebElement BasicInfoCellPhone;

    @FindBy(how = How.NAME, using = "position_type_id")
    public static WebElement NewPositionType;


    @FindBy(how = How.XPATH, using = "//select[@name='position_type_id']/option")
    public static List<WebElement> newPositionsTypesList;

    @FindBy(how = How.XPATH, using = "//div[@id='v-pills-tab']/select[1]/option")
    public static List<WebElement> jobFilterList;

    @FindBy(how = How.XPATH, using = "//*[@id=\"DataTables_Table_0_filter\"]/label/input")
    public static WebElement searchBoxInPositions;


    @FindBy(how = How.XPATH, using = "//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[2]")
    public static WebElement positionsTitle;



}