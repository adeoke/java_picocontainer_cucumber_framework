package cucumberpicoframework.site.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    WebDriver driver;

    @FindBy(className = "login")
    public WebElement signIn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
}
