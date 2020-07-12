package cucumberpicoframework.site.pages;

import cucumberpicoframework.data.SortByPrices;
import cucumberpicoframework.site.common.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryPage extends PageHelper {
    WebDriver driver;
    private String optionValue = "option[value='%s']";

    @FindBy(css = "#selectProductSort")
    WebElement sortBy;

    @FindBy(css = "#list > a > i")
    WebElement listView;

    @FindBy(css = ".product-container .right-block .content_price span[itemprop='price']")
    List<WebElement> prices;

    //could potentially move to a page fragment
    @FindBy(css = "#layer_cart_product_title")
    WebElement addedItem;

    @FindBy(css = "a.logout")
    WebElement signOut;

    @FindBy(css = "a.login")
    WebElement login;

    @FindBy(css = "a[title='Proceed to checkout']")
    WebElement proceedToCheckout;

    public CategoryPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
    }

    public void softDressesBy(SortByPrices sortByPrices) {
        sortBy.findElement(By.cssSelector(String.format(optionValue, sortByPrices.getName()))).click();
    }

    public void pricesList() {
        listView.click();

        List<Double> cleanedPrices = new ArrayList<>();

        for (WebElement price : prices) {
            cleanedPrices.add(Double.valueOf(price.getText().substring(1)));
        }

        Collections.sort(cleanedPrices);
        Collections.reverse(cleanedPrices);

        WebElement result = prices.stream()
                .filter(e -> e.getText().contains(String.valueOf(cleanedPrices.get(0))))
                .findFirst()
                .get();

        result.findElement(By.xpath("..")).findElement(By.xpath("..")).findElement(By.cssSelector("a")).click();
    }

    public String getAddedItem() {
        System.out.println(addedItem.getText());
        return addedItem.getText();
    }

    public void signOut() {
        signOut.click();
    }

    public void login() {
        login.click();
    }

    public void proceedToCheckout() {
        proceedToCheckout.click();
    }
}
