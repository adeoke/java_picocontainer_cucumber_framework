package cucumberpicoframework.site.common;

import cucumberpicoframework.utils.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class PageHelper {
    WebDriver driver;
    private WebDriverWait waiter;

    public PageHelper(WebDriver driver) throws IOException {
        this.driver = driver;
        waiter = new WebDriverWait(driver, Integer.parseInt(Config.getInstance().getProperty("default.wait.time")));
        PageFactory.initElements(driver, this);
//        Actions actions = new Actions(driver);
    }

    public void waitForElementVisibility(WebElement element) throws IOException {
        waiter.pollingEvery(Duration.ofSeconds(Integer.parseInt(Config.getInstance().getProperty("poll.time"))))
                .until(ExpectedConditions.visibilityOf(element));
    }

//    public PageHelper pageTitle(String title) throws IOException {
//        waiter.pollingEvery(Duration.ofSeconds(Integer.parseInt(Config.getInstance().getProperty("poll.time"))))
//                .until(ExpectedConditions.titleIs(title));
//        return this;
//    }

    public PageHelper typeText(WebElement element, String value) throws IOException {
        waitForElementVisibility(element);
        element.clear();
        element.sendKeys(value);
        return this;
    }

    public WebElement waitForElementPresentById(String id) {
        return waiter.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
}
