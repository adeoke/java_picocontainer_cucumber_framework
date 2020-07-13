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

    @FindBy(css = "#email")
    WebElement emailSignInField;

    @FindBy(css = "#passwd")
    WebElement password;

    @FindBy(css = "#SubmitLogin")
    WebElement signInButton;

    public LoginPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
    }

    public void createNewAccount(UserAccount account) throws IOException {
        waitForElementVisibility(signIn);
        typeText(email, account.getEmail());
        createAnAccount.click();
    }

    public void signInUser(UserAccount userAccount) throws IOException {
        typeText(emailSignInField, userAccount.getEmail());
        typeText(password, userAccount.getPassword());
        signInButton.click();
    }
}
