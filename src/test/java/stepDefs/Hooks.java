package stepDefs;

import Utilities.AutomationContext;
import Utilities.Constant;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {
    AutomationContext context;

    public Hooks(AutomationContext context) {
        this.context = context;
    }

    @Before
    public void setup(Scenario scenario) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        if (Constant.TEST_APP.equalsIgnoreCase("web")) {

            Driver.createInstance(Constant.BROWSER_NAME,Constant.BROWSER_VERSION,Constant.PLATFORM);

        }
        scenario.write("Browser is:" + Constant.BROWSER_NAME);
        scenario.write("Platform is:" + Constant.PLATFORM);
        scenario.write("Test app is:" + Constant.TEST_APP);
        scenario.write("Test time: " + timeStamp);

        context.getScenarioManager().setScenario(scenario);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (Constant.TEST_APP.equalsIgnoreCase("web")) {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/jpeg", "failure_image");

            }
            Driver.getDriver().quit();
        }



    }
}
