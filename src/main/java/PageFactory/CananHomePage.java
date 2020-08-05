package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class CananHomePage {

    //Login Page
    @FindBy(how = How.XPATH, using = "//div[@class='links']/a")
    public static WebElement loadLogin;

    @FindBy(how=How.ID, using="email")
    public static WebElement emailSection;

    @FindBy(how=How.ID, using="password")
    public static WebElement passwordSection;

    @FindBy(how=How.CSS, using="button[type='submit']")
    public static WebElement loginButton;

    //Home Page
    @FindBy(how=How.CSS, using="a[class='nav-link']")
    public static WebElement StaffButton;

    @FindBy(how=How.CSS, using="#v-pills-tab > button:nth-child(5)")
    public static WebElement NewHireButton;

    @FindBy(how=How.ID, using="newHireModal___BV_modal_title_")
    public static WebElement NewHireWindow;

    @FindBy(how=How.CSS, using="select[class='form-control']")
    public static WebElement SelectDropDown;

    @FindBy(how=How.CSS, using="button[class='btn form-control btn  mb-3 btn-primary']")
    public static WebElement TerminationButton;

    @FindBy(how=How.CSS, using="button[class='btn form-control col-sm-4 mb-3 btn-secondary']")
    public static WebElement EditBasicInfoButton;

    @FindBy(how=How.XPATH, using="//*[@id=\"basicInfoForm\"]/div/div[1]/select")
    public static WebElement StatusOnEditBasicInfo;

    @FindBy(how=How.XPATH, using="//*[@id=\"basicInfoForm\"]/div/div[1]/select/option[1]")
    public static WebElement EditBasicInfoStatusActive;

    @FindBy(how=How.XPATH, using="//*[@id=\"basicInfoForm\"]/div/div[2]/select")
    public static WebElement EditBasicInfoSalutation;

    @FindBy(how=How.XPATH, using="//*[@id=\"basicInfoForm\"]/div/div[4]/input")
    public static WebElement EditBasicInfoFirstName;

    @FindBy(how=How.XPATH, using="//*[@id=\"basicInfoForm\"]/div/div[5]/input")
    public static WebElement EditBasicInfoMiddleName;

    @FindBy(how=How.XPATH, using="//*[@id=\"basicInfoForm\"]/div/div[6]/input")
    public static WebElement EditBasicInfoLastName;

    @FindBy(how=How.XPATH, using="//*[@id=\"basicInfoForm\"]/div/div[7]/div/input")
    public static WebElement EditBasicInfoPhoneExtension;


    @FindBy(how=How.XPATH, using="//*[@id=\"basicInfoForm\"]/div/div[8]/input")
    public static WebElement EditBasicInfoRoomNumber;

    @FindBy(how=How.XPATH, using="//*[@id=\"basicInfoForm\"]/div/div[9]/div/input")
    public static WebElement EditBasicInfoPersonalEmail;

    @FindBy(how=How.XPATH, using="//*[@id=\"basicInfoForm\"]/div/div[10]/div/input")
    public static WebElement EditBasicInfoCellPhone;

   // @FindBy(how=How.XPATH, using="//*[@id=\"basicInfoForm\"]/div/div[11]/div/input")
  //  public static WebElement EditBasicInfoCellPhone;

    @FindBy(how=How.XPATH, using="(//input[@type='file'])[3]")
    public static WebElement EditBasicInfoPhotoUpload;

    @FindBy(how=How.CSS, using="button[class='btn btn-primary']")
    public static WebElement EditBasicInfoSave;

    @FindBy(how=How.CSS, using="div[class='toast-message']")
    public static WebElement BasicInfoUpdated;

    @FindBy(how=How.XPATH, using = "//p[contains(text(), 'Positions')]")
    public static WebElement PositionsButton;

    @FindBy(how=How.XPATH, using = "//h5[contains(text(), 'Positions')]")
    public static WebElement PositionsSubPage;

    @FindBy(how=How.XPATH, using = "(//form[@id='newHireForm']/div/div/select)[1]")
    public static WebElement NewHireStatus;

    @FindBy(how=How.XPATH, using = "//div[@class='col-sm-4']/input")
    public static WebElement NewHireFirstName;

    @FindBy(how=How.XPATH, using = "(//div[@class='form-group col-sm-4']/input)[1]")
    public static WebElement NewHireMiddleName;

    @FindBy(how=How.XPATH, using = "(//div[@class='form-group col-sm-4']/input)[2]")
    public static WebElement NewHireLastName;

    @FindBy(how=How.XPATH, using = "//div[@class='form-group col-sm-6']/select")
    public static WebElement NewHireVacantPosition;

    @FindBy(how=How.XPATH, using = "//*[@id=\"newHireForm\"]/div/div[7]/div/input")
    public static WebElement NewHirePersonalEmail;

    @FindBy(how=How.XPATH, using = "//*[@id=\"newHireForm\"]/div/div[8]/div/input")
    public static WebElement NewHireCellPhone;

    @FindBy(how=How.XPATH, using = "//*[@id=\"newHireForm\"]/div/div[9]/input[2]")
    public static WebElement NewHireImage;

    @FindBy(how=How.XPATH, using = "//button[contains(text(), 'Save')]")
    public static WebElement NewHireSave;

    @FindBy(how=How.XPATH, using = "//input[@placeholder='Search by Name']")
    public static WebElement SearchByName;

    @FindBy(how=How.XPATH, using = "//div[@class='card-body overflow-auto']")
    public static WebElement NamesOnStaffPage;

    @FindBy(how=How.XPATH, using = "//a[@href='#modalAddEdit']")
    public static WebElement AddNewPosition;

    @FindBy(how=How.XPATH, using = "//label[contains(text(), 'Title')]")
    public static WebElement PositionTitleLabel;

    @FindBy(how=How.XPATH, using = "//label[contains(text(), 'Assigned Staff')]")
    public static WebElement PositionAssignedStaffLabel;

    @FindBy(how=How.XPATH, using = "//label[contains(text(), 'Position Type')]")
    public static WebElement PositionTypeLabel;

    @FindBy(how=How.XPATH, using = "//label[contains(text(), 'Reports To')]")
    public static WebElement PositionReportsToLabel;

    @FindBy(how=How.XPATH, using = "//label[contains(text(), 'Location')]")
    public static WebElement PositionLocationLabel;

    @FindBy(how=How.XPATH, using = "//label[contains(text(), 'Supervisor')]")
    public static WebElement PositionSupervisorLabel;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Posted')]")
    public static WebElement PositionPostedLabel;

    @FindBy(how=How.XPATH, using = "//label[contains(text(), 'Add New Note')]")
    public static WebElement PositionAddNewNoteLabel;

    @FindBy(how=How.XPATH, using = "//input[@type='text']")
    public static WebElement PositionTitle;

    @FindBy(how=How.XPATH, using = "//select[@name='user_id']")
    public static WebElement PositionAssignedStaff;

    @FindBy(how=How.ID, using="confirm-ok")
    public static WebElement ConfirmOk;

    @FindBy(how=How.XPATH, using = "//select[@name='position_type_id'][@class='form-control']")
    public static WebElement PositionType;

    @FindBy(how=How.XPATH, using = "//select[@name='reports_to_id'][@class='form-control']")
    public static WebElement PositionReportsTo;

    @FindBy(how=How.XPATH, using = "//select[@name='location_id'][@class='form-control']")
    public static WebElement PositionLocation;

    @FindBy(how=How.XPATH, using = "//form[@id='staff-positions-form']/div[2]/div/div[7]/input[1]")
    public static WebElement PositionSupervisorYes;

    @FindBy(how=How.XPATH, using = "//form[@id='staff-positions-form']/div[2]/div/div[7]/input[2]")
    public static WebElement PositionSupervisorNo;

    @FindBy(how=How.XPATH, using = "//form[@id='staff-positions-form']/div[2]/div/div[8]/input[1]")
    public static WebElement PositionPostedYes;

    @FindBy(how=How.XPATH, using = "//form[@id='staff-positions-form']/div[2]/div/div[8]/input[2]")
    public static WebElement PositionPostedNo;

    @FindBy(how=How.TAG_NAME, using = "textarea")
    public static WebElement PositionAddNewNote;

    @FindBy(how=How.XPATH, using = "(//button[@type='submit'])[1]")
    public static WebElement PositionSave;

    @FindBy(how=How.XPATH, using = "//div[@class='toast-message']")
    public static WebElement StaffPositionIsSaved;

    @FindBy(how=How.XPATH, using = "//input[@class='form-control form-control-sm']")
    public static WebElement SearchUnderPosition;

    @FindBy(how=How.XPATH, using = "//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[3]")
    public static WebElement TitleUnderPosition;

    @FindBy(how=How.XPATH, using = "//select[@class='filter ml-4'][@name='location_id']/option")
    public static List<WebElement> PositionLocationDropDown;

    @FindBy(how=How.XPATH, using = "//table[@id='DataTables_Table_0']/tbody")
    public static WebElement PositionLocationTable;

    @FindBy(how=How.XPATH, using = "//div[contains(text(),'Showing')]")
    public static WebElement ShowingNumber;

    @FindBy(how=How.CSS, using ="#DataTables_Table_0_filter>label>input")
    public static WebElement PositionSearch;

    @FindBy(how=How.XPATH, using = "//a[@class='btn btn-ghost-info'][@data-target='#modalAddEdit']")
    public static WebElement PositionEditSign;

    @FindBy(how=How.CSS, using ="#staff-positions-form>div>h4")
    public static WebElement EditPositionHeader;

    @FindBy(how=How.XPATH, using = "//select[@class='filter ml-4'][1]")
    public static WebElement EditPositionAssignedStaff;

    @FindBy(how=How.XPATH, using = "//div[@class='toast-message']")
    public static WebElement StaffPositionUpdated;

    @FindBy(how=How.XPATH, using = "//a[@data-target='#modalDelete']")
    public static WebElement PositionDelete;

    @FindBy(how=How.XPATH, using = "//button[@type='submit'][@class='btn btn-danger btn-rounded text-white']")
    public static WebElement PositionDeleteConfirmOk;

    @FindBy(how=How.XPATH, using = "//div[@class='toast-message']")
    public static WebElement StaffPositionDeleted;

    @FindBy(how=How.XPATH, using = "//p[contains(text(), 'Position Types')]")
    public static WebElement PositionTypeButton;

    @FindBy(how=How.CSS, using = "#DataTables_Table_0_filter>label>input")
    public static WebElement PositionTypeSearch;

    @FindBy(how=How.XPATH, using = "//div[@class='btn-group']")
    public static WebElement PositionTypeEditButton;

    @FindBy(how=How.XPATH, using = "//input[@type='text']")
    public static WebElement PositionTypeEditName;

    @FindBy(how=How.XPATH, using = "//select[@name='state_code_id']")
    public static WebElement PositionTypeEditStateCode;

    @FindBy(how=How.XPATH, using = "//select[@name='budget_code_id']")
    public static WebElement PositionTypeEditBudgetCode;

    @FindBy(how=How.XPATH, using = "//textarea[@name='job_description']")
    public static WebElement PositionTypeEditDescription;

    @FindBy(how=How.XPATH, using = "//button[@type='submit'][@class='btn btn-info btn-rounded']")
    public static WebElement PositionTypeEditSave;


    @FindBy(how=How.XPATH, using = "//div[@class='toast-message']")
    public static WebElement PositionTypeUpdated;

    //Second website
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

    @FindBy(how=How.XPATH, using="//iframe[@role='presentation']")
    public static WebElement iframeToOnSignUp;

    @FindBy(how=How.ID, using="recaptcha-anchor")
    public static WebElement captchaOnSignUp;

    @FindBy(how=How.XPATH, using="//button[@type='submit']")
    public static WebElement registerOnSignUp;

    @FindBy(how=How.XPATH, using="//a[contains(text(), ' Jobs ')]")
    public static WebElement jobsText;

    //application sign in page
    @FindBy(how=How.ID, using="inputEmail")
    public static WebElement signInEmail;

    @FindBy(how=How.ID, using="inputPassword")
    public static WebElement signInPassword;

    @FindBy(how=How.XPATH, using="//button[@type='submit']")
    public static WebElement signInSubmit;

    @FindBy(how=How.XPATH, using="//h3[contains(text(),'Select a position to apply')]")
    public static WebElement selectPositionToApply;

    @FindBy(how=How.XPATH, using="(//a[contains(text(),'Apply')])[1]")
    public static WebElement applyButton;

    @FindBy(how=How.XPATH, using="//a[contains(text(),'Jobs')]")
    public static WebElement jobsHeader;

    @FindBy(how=How.ID, using="profile-submit")
    public static WebElement saveProfileButton;

    @FindBy(how=How.ID, using="update-profile")
    public static WebElement updateProfileButton;

    @FindBy(how=How.ID, using="logout")
    public static WebElement logoutButton;

    //@FindBy(how=How.ID, using="input-first_name")
    @FindBy(how=How.XPATH, using="//div[@id='input-group-first_name']/div")
    public static WebElement inputFirstName;

    @FindBy(how=How.ID, using="input-last_name")
    public static WebElement inputLastName;

    @FindBy(how=How.ID, using="input-address")
    public static WebElement inputAddress;

    @FindBy(how=How.XPATH, using="//label[@for='input-group-internal_BV_option_0']")
    public static WebElement NoRadioButtonAtProfile;

    @FindBy(how=How.ID, using="input-city")
    public static WebElement inputCity;

    @FindBy(how=How.ID, using="input-state")
    public static WebElement inputState;

    @FindBy(how=How.ID, using="input-zip_code")
    public static WebElement inputZipCode;

    @FindBy(how=How.ID, using="input-email")
    public static WebElement inputEmail;

    @FindBy(how=How.ID, using="input-phone")
    public static WebElement inputPhone;

    @FindBy(how=How.XPATH, using="//div[contains(text(), 'Job Application')]")
    public static WebElement jobAppSignIn;











































}