package testRunners;

import Utilities.Constant;
import io.cucumber.java.en.Then;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import java.util.List;

@CucumberOptions(
        features = "src/test/resources/features/SDMA/MCengiz.feature",
        glue = {"stepDefs"},

        plugin = {"pretty", "json:target/cucumber.json",
                 "html:target/cucumber-html-reports" }
        //,tags = {"@SDMA14 or @SDMA22"}
        ,tags = {"@SDMA18-2"}


)
public class MCengiz_RunCukes extends AbstractTestNGCucumberTests {

}
