package testRunners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/SDMA/benjamin.feature",
        glue = {"stepDefs"},

        plugin = {"pretty", "json:target/cucumber.json",
                 "html:target/cucumber-html-reports" }
        //,tags = {"@SDMA14 or @SDMA22"}
        ,tags = {"@SMDA-59"}


)
public class CukesRunner_Benjamin extends AbstractTestNGCucumberTests {

}
