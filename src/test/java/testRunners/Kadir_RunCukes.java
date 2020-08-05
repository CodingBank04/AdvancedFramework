package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/SDMA/Kadir.feature",
        glue = {"stepDefs"},
        plugin = {"pretty", "json:target/cucumber.json",
        "html:target/cucumber-html-report"
        }
        ,tags = {"@SDMA-52"}
)

public class Kadir_RunCukes extends AbstractTestNGCucumberTests{

}
