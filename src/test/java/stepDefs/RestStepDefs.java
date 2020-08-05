package stepDefs;

import Utilities.AutomationContext;
import Utilities.ConfigFileReader;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestStepDefs {
    AutomationContext context;

    public RestStepDefs(AutomationContext context) {
        this.context = context;
    }

    @Then("^I verify (get|post|put|delete)Service for \"(.*)\" has status (\\d+) on \"(.*)\" with header params \"(.*)\", path params \"(.*)\", query params \"(.*)\", form params \"(.*)\", auth \"(.*)\", body \"(.*)\"$")
    public void i_validate_rest_service(String method, String storingkey, int statusCode, String URL, String headerkey, String pathkey, String querykey, String formkey, String auth, String body) throws Exception {
        ConfigFileReader c = new ConfigFileReader("sdma");
        String url = c.getPropertyValue(URL);
        RequestSpecification request = given();
        Response response = null;

        if (!pathkey.equals("")) request = request.pathParams(context.getCacheParamMap(pathkey));
        if (!auth.equals("")) request = request.auth().basic(context.getCacheParamMap(auth).get("username"), context.getCacheParamMap(auth).get("password"));
        if (!headerkey.equals("")) request = request.headers(context.getCacheParamMap(headerkey));
        if (!querykey.equals("")) request = request.queryParams(context.getCacheParamMap(querykey));
        if (!formkey.equals("")) request = request.formParams(context.getCacheParamMap(formkey));
        if (!body.equals("")) request = request.body(new JSONObject(context.getCacheParamMap(body)));

        switch (method) {
            case "get":
                response = request.get(url);
                break;
            case "post":
                response = request.post(url);
                break;
            case "put":
                response = request.put(url);
                break;
            case "delete":
                response = request.delete(url);
                break;
            default:
                throw new Exception("Method name is incorrect");
        }

        response.then().assertThat().statusCode(statusCode);
        context.setResponseHashMap(storingkey, response);
        context.getScenarioManager().getScenario().write("Rest service call completed with status code " + statusCode + ". Response json:\r\n" + context.getResponseHashMap(storingkey).asString());
    }

    @Then("^I store parameters in (\\w+) map$")
    public void i_store_map(String key, Map<String, String> params) {
        Map<String, String> paramsMap = new HashMap<>();
        for (Map.Entry<String, String> param : params.entrySet()) {
            paramsMap.put(param.getKey(), param.getValue());
        }
        context.setCacheParamMap(key, paramsMap);
    }

    @Then("^I verify rest response data for (\\w+)$")
    public void i_verify_rest_response(String retrievingkey, Map<String, String> expectedmap) throws Exception {
        boolean pass = true;
        Response response = context.getResponseHashMap(retrievingkey);

        for (Map.Entry<String, String> param : expectedmap.entrySet()) {
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



}
