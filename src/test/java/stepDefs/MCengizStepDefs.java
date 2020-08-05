package stepDefs;

import PageFactory.MCengizStaffPage;
import Utilities.AutomationContext;
import Utilities.ConfigFileReader;
import Utilities.WebElementMgr;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import managers.Driver;
import net.bytebuddy.implementation.bytecode.Throw;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static io.restassured.config.RedirectConfig.redirectConfig;

public class MCengizStepDefs {
    AutomationContext context;

    public MCengizStepDefs(AutomationContext context) {
        this.context = context;
    }


    @Then("I validate all sections are present")
    public void i_validate_all_sections_are_present(List<String> sections) throws Exception {
        WebElement fileUpload = (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), "fileUpload");
        int count = 1;
        int listCount = 0;
        String label = "";
        boolean fail = false;

        while (count < sections.size() + 1) {
            if (count != 2) {
                label = Driver.getDriver().findElement(By.xpath("//*[@id='newHireForm']/div/div[" + count + "]/label")).getAttribute("innerHTML");

                if (sections.get(listCount).equals(label)) {
                    context.getScenarioManager().getScenario().write(sections.get(listCount) + " section is present");
                } else {
                    context.getScenarioManager().getScenario().write(sections.get(listCount) + " section is not present");
                    fail = true;
                }
                listCount++;
            }


            count++;

        }

        if (fileUpload.isEnabled()) {
            context.getScenarioManager().getScenario().write(sections.get(listCount) + " section is present");
        } else {
            context.getScenarioManager().getScenario().write(sections.get(listCount) + " section is not present");
            fail = true;
        }


        if (fail) {
            throw new Exception("some sections are not present");
        }


    }

    @Then("I validate when only selected department employee displayed")
    public void iValidateWhenOnlySelectedDepartmentEmployeeDisplayed() throws Exception {
        By positionLoc = By.xpath("//div[@class='row']/div[4]/div");
        boolean fail = false;
        ArrayList<WebElement> jobs = new ArrayList<>(Driver.getDriver().findElements(By.xpath("//*[@id='v-pills-tab']/select[1]/option")));
        String position = "";


        for (int i = 1; i < jobs.size(); i++) {
            jobs.get(i).click();
            position = jobs.get(i).getText();
            By newPositionLoc = By.xpath("//div[contains(text(),'" + position + "')]");
            ArrayList<WebElement> staff = new ArrayList<>(Driver.getDriver().findElements(By.xpath("//div[@id='v-pills-tab']/div/a")));

            for (int j = 0; j < staff.size(); j++) {

                try {

                    staff.get(j).click();
                    Thread.sleep(1000);
                    Driver.getDriver().findElement(newPositionLoc).isDisplayed();


                } catch (Exception e) {
                    context.getScenarioManager().getScenario().write("(" + position + ") filter is NOT working \n" +
                            " Filtered position: (" + position + ") \n" +
                            " Displayed staff position: (" + Driver.getDriver().findElement(positionLoc).getText() + ")");


                    fail = true;
                    break;
                } finally {
                    if (j == staff.size() - 1) {

                        if (position.isEmpty()) {
                            context.getScenarioManager().getScenario().write("-----WARNING!-- There is an empty field on the filter");

                        }
                    }
                }
            }
        }

        if (fail) {
            throw new Exception("At least one of the filters is not working");
        } else {
            context.getScenarioManager().getScenario().write("All filters are working");
        }
    }


    @Then("I validate Home Address is changed")
    public void iValidateHomeAddressIsChanged() throws Exception {
        WebElement storeElement = (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), "HomeAddress");
        try{
            storeElement.click();
        }
        catch (Exception e){
            storeElement.sendKeys(Keys.RETURN);
        }
        String actValue = storeElement.getText();
        String expected = "1234 maple street, apt 321, Buffalo NY 14201";
        if (actValue.equals(expected)) {
            context.getScenarioManager().getScenario().write("Pass; expected " + actValue + " is matching with found :" + expected);

        } else {

            context.getScenarioManager().getScenario().write("Fail; expected " + actValue + " is not matching with found :" + expected);
            throw new Exception("Fail; expected " + actValue + " is not matching with found :" + expected);
        }
    }

    @Then("I validate Home address reverted")
    public void I_validate_Home_address_reverted() throws Exception {
        WebElement storeElement = (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), "HomeAddress");
        storeElement.click();
        String actValue = storeElement.getText();
        String expected = "1234 oak street, apt 123, New York NY 10118";
        if (actValue.equals(expected)) {
            context.getScenarioManager().getScenario().write("Pass; Address Reverted; expected " + actValue + " is matching with found :" + expected);

        } else {

            context.getScenarioManager().getScenario().write("Fail; Address Not Reverted; expected " + actValue + " is not matching with found :" + expected);
            throw new Exception("Fail; expected " + actValue + " is not matching with found :" + expected);
        }
    }

    @Then("I Validate the {string} drop down list below")
    public void iValidateTheDropDownListBelow(String list,List<String> expectedList) throws Exception {
        List<WebElement> actualList = (List<WebElement>) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(),list );

        String expectedValue;
        String actualValue;
        boolean fail=false;
        System.out.println();
        for (int i = 0; i < actualList.size() ; i++) {
            expectedValue = expectedList.get(i);
            actualValue = actualList.get(i).getText();
           // System.out.println("|"+actualValue+"|");
            if (expectedValue == null && actualValue.isEmpty()) {
                context.getScenarioManager().getScenario().write(" Pass; \n Expected: " + expectedValue + " \n Found : " + actualValue + " \n Empty filter but working");
            }
            else{
                if (!actualValue.equals(expectedValue)) {
                    context.getScenarioManager().getScenario().write(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
                    fail=true;
                } else {
                   // context.getScenarioManager().getScenario().write(" Pass; \n Expected: " + expectedValue + " \n Found : " + actualValue);
                }
            }
            if(fail){
                throw new Exception(" Fail; \n Expected: " + expectedValue + " \n Found : " + actualValue);
            }
        }

    }


    @Then("I verify rest response data contains for {string}")
    public void iVerifyRestResponseDataContainsFor(String retrievingkey, List<String> expectedvalues) throws Exception {
        boolean fail = false;
        String rsp = context.getResponseHashMap(retrievingkey).asString();
        String expectedValue = "";

        for (int i = 0; i < expectedvalues.size(); i++) {
            expectedValue = expectedvalues.get(i);

            if (!rsp.contains(expectedValue)) {
                context.getScenarioManager().getScenario().write(" Fail; Could not find " + expectedValue + " in response");
                fail = true;
            } else {
                context.getScenarioManager().getScenario().write(" Pass; " + expectedValue + " is present in response");
            }

        }
        if (fail) {
            throw new Exception(" Fail; Could not find " + expectedValue + " in response");
        }
    }

    @Then("I verify {string} postMethod created data with {string}")
    public void iVerifyPostMethodCreatedDataWith(String id, String bodyKey) throws Exception {
        boolean pass = true;

        String ID = context.getResponseHashMap(id).asString();
        Map<String, String> rsBody = context.getCacheParamMap(bodyKey);
        ConfigFileReader c = new ConfigFileReader("sdma");
        String url = c.getPropertyValue("getStaffInfo");
        RequestSpecification request = given();
        Response response = null;
        request = request.pathParam("staff_id", ID);
        response = request.get(url);
        response.then().assertThat().statusCode(200);

        for (Map.Entry<String, String> param : rsBody.entrySet()) {
            String paramKey;
            String paramValue = "";
            String respValue;
            Object rspVl;
            paramKey = param.getKey();
            rspVl = response.then().extract().path(paramKey);
            if (rspVl != null) {
                respValue = String.valueOf(rspVl).trim();
            } else {
                respValue = String.valueOf(rspVl);
            }

            if (paramKey.equals("cell_phone")) {
                String tempParamValue = param.getValue();

                for (int i = 0; i < tempParamValue.length(); i++) {
                    if (i == 0) {
                        paramValue = paramValue + "(" + tempParamValue.charAt(i);
                    } else if (i == 2) {
                        paramValue = paramValue + tempParamValue.charAt(i) + ") ";
                    } else if (i == 5) {
                        paramValue = paramValue + tempParamValue.charAt(i) + "-";
                    } else {
                        paramValue = paramValue + tempParamValue.charAt(i);
                    }

                }
                System.out.println("original format cell phone: " + respValue);
                System.out.println("new format cell phone: " + paramValue);

            } else {
                paramValue = param.getValue();

            }

            if (respValue.equals(paramValue)) {
                context.getScenarioManager().getScenario().write("Pass; Found " + paramKey + " : " + respValue);
            } else {
                pass = false;
                context.getScenarioManager().getScenario().write("Fail; Expected " + paramValue + "; Found " + paramKey + " : " + respValue);
            }

        }
        if (!pass) throw new Exception("Fail! Check outputs below for details.");
    }

    @Then("I delete {string} staff")
    public void iDeleteStaff(String id) {
        String ID = context.getResponseHashMap(id).asString();

        ConfigFileReader c = new ConfigFileReader("sdma");
        String url = c.getPropertyValue("postExit");
        RequestSpecification request = given();
        Response response = null;

        request.pathParams("staff_id",ID);
        request = request.formParams("exit_date","03/23/2020","exit_reason","RES");
        request = request.formParams("exit_reason","RES");

         response = request.post(url);


        response.then().assertThat().statusCode(200);

        context.getScenarioManager().getScenario().write("Rest service call completed with status code 200 and Staff "+ ID+" deleted ");

    }

}
