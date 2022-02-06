package com.demoblaze.stepDefinitions;

import com.demoblaze.pages.ProductPage;
import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PurchaseSteps {

    ProductPage productPage = new ProductPage();

    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        Driver.get().get(ConfigurationReader.get("demoblaze.url"));
    }
    @When("User adds {string} from {string}")
    public void user_adds_from(String product, String category) {
        productPage.navigateTo(product,category);
        productPage.addToCart();
        productPage.home.click();
    }


    @And("User navigates to cart and removes {string}")
    public void userNavigatesToCartAndRemoves(String product) {
        productPage.cart.click();
        productPage.deleteProduct(product);

    }

    @And("User clicks on place order")
    public void userClicksOnPlaceOrder() {
        productPage.cart.click();
        BrowserUtils.sleep(2);
        productPage.placeOrder.click();
    }
}
