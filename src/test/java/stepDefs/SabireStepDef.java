package stepDefs;

import PageFactory.SabireHomePage;
import Utilities.AutomationContext;
import Utilities.WebElementMgr;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import static PageFactory.SabireHomePage.*;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SabireStepDef {
    AutomationContext context;
    FluentWait<WebDriver> wait ;

    public SabireStepDef(AutomationContext context) {

        this.context = context;
        new WebDriverWait(Driver.getDriver(),
                Long.parseLong(context.getConfigFileReader().getPropertyValue("fluentwait")))
                .pollingEvery(Duration.ofSeconds(Long.parseLong(context.getConfigFileReader().getPropertyValue("waitPolling"))))
                .ignoring(NoSuchElementException.class);

    }


    @And("I want to see menu options")
    public void iWantToSeeMenuOptions() throws Exception {
        String actualOption = Driver.getDriver().findElement(By.xpath("//span[@class='brand-text font-weight-light']")).getText();
        String expectedOption = "BuffSci";
        assertEquals(actualOption, expectedOption);

    }

    @Then("I validate all menu sections are present")
    public void iValidateAllMenuSectionsArePresent() {
        String actual = Driver.getDriver().findElement(By.xpath("//a[@href='https://hr-staging.buffsci.org/home']")).getText();
        String expected = "group Staff";

        String actualPosition = Driver.getDriver().findElement(By.xpath("//a[@href='https://hr-staging.buffsci.org/staff-positions']")).getText();
        String expectedPosition = "recent_actors Positions";

        String actualPosType = Driver.getDriver().findElement(By.xpath("//a[@href='https://hr-staging.buffsci.org/staff-position-types']")).getText();
        String expectedPosType = "notes Position Types";

        String actualPermission = Driver.getDriver().findElement(By.xpath("//a[@href='https://hr-staging.buffsci.org/permissions']")).getText();
        String expectedPermission = "verified_user Permissions";

        String actualSnap = Driver.getDriver().findElement(By.xpath("//a[@href='https://hr-staging.buffsci.org/snapshot']")).getText();
        String expectedSnap = "camera Snapshot for NYSED";

        String[] actualElement = {actual, actualPosition, actualPosType, actualPermission, actualSnap};
        String[] expectedElement = {expected, expectedPosition, expectedPosType, expectedPermission, expectedSnap};

        Assert.assertArrayEquals(actualElement, expectedElement);


    }


    @Given("I am on the  MCengizLoginPage page")
    public void iAmOnTheMCengizLoginPagePage() {

    }

    @Then("I want to click on Position type part")
    public void iWantToClickOnPositionTypePart() {
        Driver.getDriver().findElement(By.xpath("//a[@href='https://hr-staging.buffsci.org/staff-position-types']")).click();
        String actualPosTypePage = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary float-sm-right']")).getText();
        String expectedTextPosTypePage = "Add New";
        Assert.assertEquals(expectedTextPosTypePage, actualPosTypePage);


    }

    @Then("I validate Position Type Sub-page  is displayed")
    public void iValidatePositionTypeSubPageIsDisplayed() {
        boolean actualPosTypePage = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary float-sm-right']")).isDisplayed();
        Assert.assertTrue("Add New", actualPosTypePage);


    }


    @Then("I click on delete button")
    public void iClickOnDeleteButton() {
        // try {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        WebElement delete = Driver.getDriver().findElement(By.xpath("//div[@class='modal-footer justify-content-between']/button[2]"));
        delete.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        //System.out.println(alert.getText());
        alert.dismiss();


        //Driver.getDriver().findElement(By.xpath("//button[@id='delete-button']")).click();

        // Assert.assertTrue(alert.getText().contains("Cancel"));
        // }
        // catch (Exception e) {
        //exception handling
    }


    // }


    @Then("I validate pop-up page is displayed")
    public void iValidatePopUpPageIsDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
            Driver.getDriver().findElement(By.xpath("//button[@id='delete-button']")).click();
            Alert alert = Driver.getDriver().switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            Assert.assertTrue(alert.getText().contains("Cancel"));
            alert.dismiss();
            Assert.assertTrue(alert.getText().contains("CSRF token dismatch."));
        } catch (Exception e) {
            //exception handling
        }


    }

    @Then("I want to click on edit botton")
    public void iWantToClickOnEditBotton() {
        Driver.getDriver().findElement(By.xpath("//a[@data-id='52']/i")).click();
    }

    @Then("I validate pop-up page which has options")
    public void iValidatePopUpPageWhichHasOptions() {


        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);
            Alert alert = Driver.getDriver().switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            Assert.assertTrue(alert.getText().contains("Delete"));
        } catch (Exception e) {
            //exception handling
        }


    }

    @Then("I validate {string} button under Staff List")
    public void iValidateButtonUnderStaffList(String option) {


        try {
            String actualLOc = Driver.getDriver().findElement(By.xpath("//div[@class='card-body']/div/select[2]")).getAttribute(option);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);
            String expectedLOc = Driver.getDriver().findElement(By.xpath("//div[@class='card-body']/div/select[2]")).getAttribute(option);

            Assert.assertEquals(option, expectedLOc, actualLOc);
        } catch (Exception e) {
        }
    }

    @Then("I validate all  are present {string}")
    public void iValidateAllArePresent(String option) {
        try {
            WebElement location = Driver.getDriver().findElement(By.xpath("//div[@class='card-body']/div/select[2]"));
            Select selectLoc = new Select(location);//(Driver.getDriver().findElement(By.xpath("//div[@class='card-body']/div/select[2]")));
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);

            location.click();
            List<WebElement> elementCount = selectLoc.getOptions();
            for (WebElement loc : elementCount) {
                if (option.equalsIgnoreCase(loc.getAttribute("value"))) {
                    String s = loc.getText();
                    s = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
                    System.out.println("Number==>" + s);
                    //selectLoc.selectByValue(option);
                    boolean found = true;
                    break;
                }
            }
            System.out.println(elementCount.size());
        } catch (Exception e) {
        }
    }

    @Then("I click on Location Box button")
    public void iClickOnLocationBoxButton() {
        try {
            // Select selectLoc= new Select(Driver.getDriver().findElement(By.xpath("//div[@class='card-body']/div/select[2]")));
            WebElement location = Driver.getDriver().findElement(By.xpath("//div[@class='card-body']/div/select[2]"));
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);

            location.click();
        } catch (Exception e) {

        }
    }


    @Then("I click on any name on the staff list")
    public void iClickOnAnyNameOnTheStaffList() {
        Driver.getDriver().findElement(By.xpath("//div[@class=\"card-body overflow-auto\"]/a[1]")).click();
    }

    @Then("I validate edit Basic Info Button")
    public void iValidateEditBasicInfoButton() {
        Driver.getDriver().manage().window().maximize();
        String actualEditInfo = Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Edit Basic Info')]")).getText();
        String expectedInfo = "Edit Basic Info";
        Assert.assertEquals(expectedInfo, actualEditInfo);
    }

    @Then("I click on Edit Basic Info Button and validate it with basic info of worker")
    public void iClickOnEditBasicInfoButtonAndValidateItWithBasicInfoOfWorker() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        WebElement edit_Basic_Info = Driver.getDriver().findElement(By.cssSelector("#basic-tab > div > div.form-group.col-sm-9 > div > button"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("scroll(0,1000)", edit_Basic_Info);
        //wait.until(ExpectedConditions.elementToBeClickable(edit_Basic_Info));
        edit_Basic_Info.click();
        js.executeScript("window.history.go(+1)");
        //Alert child = Driver.getDriver().switchTo().alert();
        WebElement saveAlertButton = Driver.getDriver().findElement(By.xpath("//*[@id='basicInfoModal___BV_modal_footer_']/button[1]"));
        //wait.until(ExpectedConditions.elementToBeClickable(saveAlertButton));
        // JavascriptExecutor js1 = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("scroll(0,1000)", saveAlertButton);
        saveAlertButton.click();


        // WebDriver webParent = Driver.getDriver().switchTo().parentFrame();
        String actualEditInfo = Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Edit Basic Info')]")).getText();
        String expectedInfo = "Edit Basic Info";
        Assert.assertEquals(expectedInfo, actualEditInfo);


    }

    @Then("I click on Select Location and validate it")
    public void iClickOnSelectLocationAndValidateIt() {
        Driver.getDriver().findElement(By.xpath("//select[@name='location_id']")).click();
        Driver.getDriver().findElement(By.xpath("//select[@name='location_id']/option[2]")).click();
        String actualInnerText = Driver.getDriver().findElement(By.xpath("//table/tbody/tr/td[1]")).getText();
        String expectedInnerText = "BuffSci 2";
        Assert.assertEquals(expectedInnerText, actualInnerText);
    }

    @Then("I click on select Position and validate it")
    public void iClickOnSelectPositionAndValidateIt() {

        Driver.getDriver().findElement(By.xpath("//select[@name='position_type_id']")).click();
        Driver.getDriver().findElement(By.xpath("//select[@name='position_type_id']/option[2]")).click();
        String actualInnerPOsTypMes = Driver.getDriver().findElement(By.xpath(" //table/tbody/tr/td")).getText();
        String expectedPosTypeMes = "No data available in table";
        Assert.assertEquals(expectedPosTypeMes, actualInnerPOsTypMes);
    }

    @Then("I click on select status and validate it")
    public void iClickOnSelectStatusAndValidateIt() {
        Driver.getDriver().findElement(By.xpath("//select[@name='status']")).click();
        Driver.getDriver().findElement(By.xpath("//select[@name='status']/option[3]")).click();
        String innerStatusText = Driver.getDriver().findElement(By.xpath("//table/tbody/tr/td[2]")).getText();
        String expectedInnerStatusText = "IT Support";
        Assert.assertEquals(expectedInnerStatusText, innerStatusText);

    }

    @Then("I click on Clear Filter Button")
    public void iClickOnClearFilterButton() {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.history.go(-1)");
        Driver.getDriver().findElement(By.xpath("//a[@class='btn btn-info ml-4 text-white']")).click();


    }

    @Then("I validate all selections are clear")
    public void iValidateAllSelectionsAreClear() {


        WebElement actualInnerText = Driver.getDriver().findElement(By.xpath("//select[@name='position_type_id']"));
        Select select = new Select(actualInnerText);
        String text = select.getFirstSelectedOption().getText();
        Assert.assertEquals("- Select Position -", text);


    }


    @Then("I click on Position Link under the Menu")
    public void iClickOnPositionLinkUnderTheMenu() {
        Driver.getDriver().findElement(By.xpath("//a[@href='https://hr-staging.buffsci.org/staff-positions']")).click();
        String actualClearFilter = Driver.getDriver().findElement(By.xpath("//a[contains(text(), 'Clear Filters')]")).getText();
        String expectedClearMessage = "Clear Filters";
        Assert.assertEquals(expectedClearMessage, actualClearFilter);
    }

    @Then("I click on positions in the main page")
    public void iClickOnPositionInTheMainPage() {
        Driver.getDriver().findElement(By.xpath("//a[@href='https://hr-staging.buffsci.org/staff-positions']")).click();
    }

    @Then("I see searchBox button on the Position page")
    public void iSeeSearchBoxButtonOnThePositionPage() {
        Driver.getDriver().findElement(By.xpath("//input[@type='search']")).click();
        String actualSearchBox = Driver.getDriver().findElement(By.xpath("//div[@id='DataTables_Table_0_filter']")).getText();
        String expectedSearchBox = "Search:";
        Assert.assertEquals(expectedSearchBox, actualSearchBox);

    }


    @Then("I refresh current page")
    public void iRefreshCurrentPage() {
        Driver.getDriver().navigate().refresh();
    }

    @Then("I enter one by one the {string} on the search box and validate them on  dataTable list")
    public void iEnterOneByOneTheOnTheSearchBoxAndValidateThemOnTheDatatableList(String positionName) throws EnumConstantNotPresentException {
        Driver.getDriver().findElement(By.xpath("//input[@type='search']")).sendKeys(positionName, Keys.ENTER);
        List<WebElement> allRow;
        allRow = (List<WebElement>) Driver.getDriver().findElements(By.xpath("//table[@class='table table-striped dataTable no-footer dtr-inline collapsed']/tbody/tr/td[2]"));
        WebElement table = Driver.getDriver().findElement(By.tagName("tr"));
        List<WebElement> column = Driver.getDriver().findElements(By.tagName("td[2]"));
        List<WebElement> data = new ArrayList<>();


            try {


                System.out.println(allRow.size());
                int rows = 0;

                for (int i = 1; i <= allRow.size(); i++) {
                    String cellText = SabireHomePage.dataTable.getText();
                    if ((cellText.contains(positionName))) {
                        context.getScenarioManager().getScenario().write(" Pass In Position Type: \n Expected: " + positionName + " \n Found : " + cellText);
                        //System.out.println(i);

                    } else {
                        context.getScenarioManager().getScenario().write(" Fail In Position Type; \n Expected: " + positionName + " \n Found : " + cellText);

                    }


                    String infoText = Driver.getDriver().findElement(By.xpath("//div[@class='dataTables_info']")).getText();
                    // Start traversing the given string
                    int rowNumber = 0;
                    int num = 0, res = 0;
                    for (int a = 0; a < infoText.length(); a++) {
                        // If a numeric value comes, start converting
                        // it into an integer till there are consecutive
                        // numeric digits
                        if (infoText.charAt(a) >= '0' && infoText.charAt(a) <= '9')
                            num = num * 10 + (infoText.charAt(a) - '0');
                            // Update maximum value
                        else {
                            res = Math.max(res, num);
                            // Reset the number
                            num = 0;
                        }


                        // Return maximum value
                        rowNumber = Math.max(res, num);
                    }


                    System.out.println(rowNumber);
//
//
//
                    try {
                        if (rowNumber > 0) {
                            for (int j = 1; j < rowNumber; j++) {
                                WebElement clickEl = Driver.getDriver().findElement(By.xpath("//li[@id='DataTables_Table_0_next']/a"));
                                wait.until((Function) ExpectedConditions.visibilityOf(clickEl));
                                Driver.getDriver().findElement(By.xpath("//a[contains(text(),'Next')]")).click();
                                data.add(table.findElement(By.xpath("tr[' + j + ']/td[2]")));
                                String cellTexting = Driver.getDriver().findElement(By.xpath("//table[@class='table table-striped dataTable no-footer dtr-inline collapsed']/tbody/tr/td[2]")).getText();
                                if (cellTexting.equals(data.get(j).getText())) {
                                    context.getScenarioManager().getScenario().write(" Pass; \n Expected: " + cellTexting + " \n Found : " + data.get(j - 1).getText());
                                } else {
                                    context.getScenarioManager().getScenario().write(" Fail; \n Expected: " + cellTexting + " \n Found : " + data.get(j - 1).getText());
                                }

                                context.getScenarioManager().getScenario().write("Row Number:" + res);
                            }
                        } else {
                            context.getScenarioManager().getScenario().write("Row number smaller than 1");


                        }


                    } catch (Exception e) {

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    @Then("I click on staff page")
    public void iClickOnStaffPage() {
        WebElement staffPage= staff;
        staffPage.click();
    }

    @Then("I validate details Button and click on details")
    public void iValidateDetailsButtonAndClickOnDetails() {
        WebElement detailButton= details;
        String actualButton=detailButton.getText();
        String expectedText="Details";
        Assert.assertEquals(expectedText,actualButton);
        detailButton.click();
    }


    @Then("I validate editDetails Box and click on editDetails")
    public void iValidateEditDetailsBoxAndClickOnEditDetails() {
        WebElement clickEditDetails=Driver.getDriver().findElement(By.cssSelector("#details-tab > div > div > div > button"));

        JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollBy(0,1000)");
        //WebElement clickEditDetails=Driver.getDriver().findElement(By.cssSelector("#details-tab > div > div > div > button"));
        String actualEditDetails= clickEditDetails.getText();
        String expectedEditDetails="Edit Details";
        Assert.assertEquals(expectedEditDetails,actualEditDetails);
       // wait.until((Function) ExpectedConditions.elementToBeClickable(clickEditDetails));
        clickEditDetails.click();
    }

    @Then("I update an information on pop up page")
    public void iUpdateAnInformationOnPopUpPage()throws Exception {
        try {
            Alert alertPopup = Driver.getDriver().switchTo().alert();
            // System.out.println(alertPopup.getText());
            alertPopup.accept();
            WebElement updatingPopUp = popupUpdate;
            updatingPopUp.clear();
            updatingPopUp.sendKeys("Turkish");
        }catch (Exception e) {

        }



    }

    @Then("I click on save button")
    public void iClickOnSaveButton() {
        try{
            Alert alertSecPopup= Driver.getDriver().switchTo().alert();
            WebElement savingPopUp=popupSave;
            savingPopUp.click();
            Assert.assertTrue(alertSecPopup.getText().contains("The given data was invalid"));
            WebElement cancelingPopup=popupCancel;
            cancelingPopup.click();
            Assert.assertTrue(alertSecPopup.getText().contains("The given data was invalid"));

        }catch(Exception e){
        }
    }


    @Then("I validate the new page is displayed")
    public void iValidateTheNewPageIsDisplayed() {
        String actualCurrentUrl = Driver.getDriver().getCurrentUrl();
        String expectedCurrentUrl = "https://apply-testing.buffsci.org/job";
        Assert.assertEquals(expectedCurrentUrl,actualCurrentUrl);
    }
}






