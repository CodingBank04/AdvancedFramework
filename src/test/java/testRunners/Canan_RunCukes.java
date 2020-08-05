package testRunners;

import Utilities.Constant;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/SDMA/Canan.feature",
        glue = {"stepDefs"},
        plugin = {"pretty", "json:target/cucumber.json",}    //html:target/cucumber-html-reports
        ,tags = {"@SDMA53"}
)
public class Canan_RunCukes extends AbstractTestNGCucumberTests {

}
