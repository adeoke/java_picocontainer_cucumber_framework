package cucumberpicoframework.site.pages;

import cucumberpicoframework.site.common.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class MyAccount extends PageHelper {
    WebDriver driver;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
    WebElement dresses;

    public MyAccount(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
    }

    public void clickDresses() {
        dresses.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
