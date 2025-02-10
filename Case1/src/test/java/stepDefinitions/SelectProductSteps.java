package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.SelectProduct;
import util.DriverFactory;

public class SelectProductSteps {


    WebDriver driver = DriverFactory.getDriver();
    SelectProduct selectProduct = new SelectProduct(driver);


    @Given("The user navigates to hepsiburada")
    public void theUserNavigatesToHepsiburada() {
        selectProduct.LogoCheck();

    }

    @When("The user selects elektonik>Bilgisayartablet>Tablet category")
    public void theUserSelectsElektonikBilgisayartabletTabletCategory() {
        selectProduct.GoToTabletMenu();

    }

    @And("The user applies filters")
    public void theUserAppliesFilters() {
        selectProduct.chooseFilter();

    }

    @And("The user clicks on the most expensive product without using the sorting filter")
    public void theUserClicksOnTheMostExpensiveProductWithoutUsingTheSortingFilter() {
        selectProduct.highgestPrice();
    }

    @And("The user clicks the Add to Cart button on the product detail page")
    public void theUserClicksTheAddToCartButtonOnTheProductDetailPage() {
        selectProduct.AddCart();
    }

    @Then("The user verifies that the product is added to the cart")
    public void theUserVerifiesThatTheProductIsAddedToTheCart() {
        selectProduct.goToCart();
    }

    @And("The user verifies that the price in the cart matches the product detail page")
    public void theUserVerifiesThatThePriceInTheCartMatchesTheProductDetailPage() {
        selectProduct.priceCheck();
    }



}
