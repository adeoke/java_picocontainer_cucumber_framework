package cucumberpicoframework.steps;

import cucumberpicoframework.data.SortByPrices;
import cucumberpicoframework.data.UserAccount;
import cucumberpicoframework.site.Site;
import cucumberpicoframework.testcontext.World;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccountSteps {
    WebDriver driver;
    private UserAccount userAccount;
    private Site site;
    private String addedItemText;

    public AccountSteps(World world) throws IOException {
        driver = world.driverInstance();
        userAccount = world.userAccountInstance();
        site = world.siteInstance();
    }

    @Given("the user initiates the account creation process from the homepage")
    public void the_user_initiates_the_account_creation_process_from_the_homepage() throws IOException {
        site.homePage().signIn.click();
        site.loginPage().createNewAccount(userAccount);
    }

    @When("the user provides the required account registration details")
    public void the_user_provides_the_required_account_registration_details() throws IOException {
        site.accountCreationPage().createAccount(userAccount);
    }

    @Then("the user account is registered")
    public void the_user_account_is_registered() throws IOException, InterruptedException {
        String expectedPageTitle = "My account - My Store";
        assertThat(site.myAccountPage().getPageTitle(), is(equalTo(expectedPageTitle)));
    }

    @Given("adds the most expensive item to the cart")
    public void adds_the_most_expensive_item_to_the_cart() {
        site.myAccountPage().clickDresses();

        site.categoryPage().softDressesBy(SortByPrices.DESCENDING);
        site.categoryPage().pricesList();
        addedItemText = site.categoryPage().getAddedItem();
        site.categoryPage().proceedToCheckout();
    }

    @When("the user logs out")
    public void the_user_logs_out() {
        site.categoryPage().signOut();
    }
    @When("logs back in again")
    public void logs_back_in_again() throws IOException {
        site.categoryPage().login();
        site.loginPage().signInUser(userAccount);
    }

    @Then("the dress is still present int he cart")
    public void the_dress_is_still_present_in_the_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
