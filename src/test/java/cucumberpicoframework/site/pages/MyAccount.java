package cucumberpicoframework.site.pages;

import cucumberpicoframework.site.common.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class MyAccount extends PageHelper {
    private final String title = "My account - My Store";
    WebDriver driver;

    @FindBy(css = "title")
    WebElement pageTitle;

    public MyAccount(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
    }

    public String getPageTitle() throws InterruptedException {
        return driver.getTitle();
    }
}
