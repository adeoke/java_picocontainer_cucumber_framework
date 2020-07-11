package cucumberpicoframework.site.pages;

import cucumberpicoframework.data.UserAccount;
import cucumberpicoframework.site.common.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LoginPage extends PageHelper {
    WebDriver driver;

    @FindBy(css = "#email_create")
    public WebElement email;

    @FindBy(css = "#SubmitCreate")
    public WebElement createAnAccount;

    @FindBy(className="login")
    public WebElement signIn;

    public LoginPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
    }

    public void createNewAccount(UserAccount account) throws IOException {
        waitForElementVisibility(signIn);
        typeText(email, account.getEmail());
        createAnAccount.click();
    }
}
