package cucumberpicoframework.site;

import cucumberpicoframework.site.pages.AccountCreationPage;
import cucumberpicoframework.site.pages.HomePage;
import cucumberpicoframework.site.pages.LoginPage;
import cucumberpicoframework.site.pages.MyAccount;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Site {
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage homePage() {
        return PageFactory.initElements(getDriver(), HomePage.class);
    }

    public LoginPage loginPage() {
        return PageFactory.initElements(getDriver(), LoginPage.class);
    }

    public AccountCreationPage accountCreationPage() {
        return PageFactory.initElements(getDriver(), AccountCreationPage.class);
    }

    public MyAccount myAccountPage() {
        return PageFactory.initElements(getDriver(), MyAccount.class);
    }
}
