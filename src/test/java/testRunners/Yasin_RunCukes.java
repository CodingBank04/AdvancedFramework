package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/SDMA/Yasin.feature",
        glue = {"stepDefs"},
        plugin = {"pretty", "json:target/cucumber.json",
                "html:target/cucumber-html-reports" },
        tags = {"@SDMA46"}
)
public class Yasin_RunCukes extends AbstractTestNGCucumberTests {
}
