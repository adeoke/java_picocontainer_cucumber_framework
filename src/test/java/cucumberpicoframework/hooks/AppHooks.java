package cucumberpicoframework.hooks;

import cucumberpicoframework.utils.TestLoggerWrapper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppHooks {
    WebDriver driver;
    private Logger testLoggerWrapper = TestLoggerWrapper.getInstance();

    public AppHooks() throws IOException {
    }

    @Before
    public void beforeHook(Scenario scenario) {
        testLoggerWrapper.log(Level.INFO, String.format("test %s is running", scenario.getName()));
    }

    @After
    public void afterHook(Scenario scenario) {
        testLoggerWrapper.log(Level.INFO, String.format("test %s is finished!", scenario.getName()));
    }
}
