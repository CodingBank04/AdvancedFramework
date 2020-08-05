package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "src/test/resources/features/SDMA/Sabire.feature",

        glue = {"stepDefs"},
        plugin = {"pretty", "html:target/cucumber-reports","json:target/cucumber.json"
                 },

                tags={"@TC8"}

)
public class Sabire_RunCukes extends AbstractTestNGCucumberTests {

}
