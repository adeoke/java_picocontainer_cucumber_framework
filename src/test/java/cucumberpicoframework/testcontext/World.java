package cucumberpicoframework.testcontext;

import cucumberpicoframework.data.UserAccount;
import cucumberpicoframework.site.Site;
import cucumberpicoframework.utils.BrowserManager;
import cucumberpicoframework.utils.Config;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class World {
    private BrowserManager browserManager = new BrowserManager();
    private UserAccount userAccount = new UserAccount();
    WebDriver driver;
    Site site = new Site();

    public World() throws IOException {
    }

    public WebDriver driverInstance() throws IOException {
        driver = browserManager.getDriver();
        driver.get(Config.getInstance().getProperty("app.url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public UserAccount userAccountInstance() {
        return userAccount;
    }

    public Site siteInstance() {
        site.setDriver(driver);
        return site;
    }
}
