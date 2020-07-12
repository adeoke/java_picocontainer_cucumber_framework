package cucumberpicoframework.site.pages;

import cucumberpicoframework.data.UserAccount;
import cucumberpicoframework.site.common.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class AccountCreationPage extends PageHelper {
    WebDriver driver;
    final String genderId = "id_gender1";

    @FindBy(id = genderId)
    WebElement mrRadioButton;

    @FindBy(css = "#customer_firstname")
    WebElement firstName;

    @FindBy(css = "#customer_lastname")
    WebElement customerLastName;

    @FindBy(css = "#passwd")
    WebElement password;

    @FindBy(css = "#days")
    WebElement day;

    @FindBy(css = "#months")
    WebElement month;

    @FindBy(css = "#years")
    WebElement year;

    @FindBy(css = "#address1")
    WebElement addressOne;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#id_state")
    WebElement state;

    @FindBy(css = "#postcode")
    WebElement zipcode;

    @FindBy(css = "#phone")
    WebElement phone;

    @FindBy(css = "#alias")
    WebElement alias;

    @FindBy(css = "#submitAccount")
    WebElement register;

    @FindBy(css = "#id_country")
    WebElement country;

    private String optionValue = "option[value='%s']";

    public AccountCreationPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
    }

    public void createAccount(UserAccount userAccount) throws IOException {
        waitForElementPresentById(genderId);
        selectState(userAccount.getStateIndex());
        mrRadioButton.click();
        typeText(firstName, userAccount.getFirstName());
        typeText(customerLastName, userAccount.getLastName());
        System.out.println(String.format("This isht euser password: '%s'", userAccount.getPassword()));
        typeText(password, userAccount.getPassword());
        selectDay(userAccount.getDayOfBirth());
        selectMonth(userAccount.getMonthOfBirth());
        selectYear(userAccount.getYearOfBirth());
        typeText(addressOne, userAccount.getAddress());
        typeText(city, userAccount.getCity());
        typeText(zipcode, userAccount.getPostCode());
        selectCountry(userAccount.getCountryIndex());
        typeText(phone, userAccount.getPhoneNumber());
        typeText(alias, userAccount.getAlias());
        register.click();
    }

    private void selectDay(String day) {
        this.day.findElement(By.cssSelector(String.format(optionValue, day))).click();
    }

    private void selectMonth(String month) {
        this.month.findElement(By.cssSelector(String.format(optionValue, month))).click();
    }

    private void selectYear(String year) {
        this.year.findElement(By.cssSelector(String.format(optionValue, year))).click();
    }

    private void selectState(int stateIndex) {
        state.findElement(By.cssSelector(String.format(optionValue, stateIndex))).click();
    }

    private void selectCountry(int countryIndex) {
        country.findElement(By.cssSelector(String.format(optionValue, countryIndex))).click();
    }
}
