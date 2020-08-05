package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "src/test/resources/features/SDMA/Zhannat.feature",

        glue = {"stepDefs"},
        plugin = {"pretty", "json:target/cucumber.json"},

        tags={"@SDMA#50"}

)

public class Zhannat_RunCukes extends AbstractTestNGCucumberTests {


}

