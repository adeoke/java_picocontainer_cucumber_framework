package cucumberpicoframework.utils;

import cucumberpicoframework.exceptions.BrowserOptionException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrowserManager {
    private WebDriver driver;
    private Logger testLoggerWrapper = TestLoggerWrapper.getInstance();

    public BrowserManager() throws IOException {
    }

    public WebDriver getDriver() {
        String browser = System.getProperty("browser").toLowerCase();
        BrowserOptions[] browsers = BrowserOptions.values();

        try {
            driver = browserCheckAndDriverInitialisation(browsers, browser);
            testLoggerWrapper.log(Level.INFO, String.format("Starting test with browser '%s'.", browser));
        } catch (BrowserOptionException ex) {
            ex.printStackTrace();
            testLoggerWrapper.log(Level.WARNING, String.format("Got exception '%s'.", ex));
        }

        return driver;
    }

    private WebDriver browserCheckAndDriverInitialisation(BrowserOptions[] browsers, String browser) throws BrowserOptionException {
        boolean result = Arrays.stream(browsers).anyMatch(item -> item.name().toLowerCase().equals(browser));

        if (result) {
            testLoggerWrapper.log(Level.INFO, String.format("browser %s was found in list", browser));
            switch (browser) {
                case "opera":
                    return operaInstance();
                case "firefox":
                    return firefoxInstance();
                case "ie":
                    return ieInstance();
                default:
                    return chromeInstance();
            }

        } else {
            String msg = String.format("Browser option '%s' does not exist", browser);
            testLoggerWrapper.log(Level.INFO, msg);
            throw new BrowserOptionException(msg);
        }
    }

    private WebDriver chromeInstance() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver firefoxInstance() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private WebDriver ieInstance() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    private WebDriver operaInstance() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }
}
