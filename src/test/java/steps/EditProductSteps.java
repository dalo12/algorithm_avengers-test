package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

public class EditProductSteps {
    protected static String EMAIL = "admin@iaw.com";
    protected static String PASSWORD = "admin123";
    protected WebDriver driver;
    protected String editProductUrl = "http://127.0.0.1:8000/productos/product_id/edit";
    protected String productsUrl = "http://127.0.0.1:8000/productos";
    protected FormProductPage editProductPage;
    protected ProductsPage productsPage;


    @Given("the user is in the edition page of product with id {string}")
    public void the_user_is_in_the_edition_page_of_product_with_id(String id){
        System.setProperty("webdriver.chrome.driver", "/snap/chromium/3025/usr/lib/chromium-browser/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/chromium-browser");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        editProductUrl = editProductUrl.replaceFirst("product_id", id);

        driver.get(editProductUrl);
        logIn();

        editProductPage = new EditProductPage(driver);
        editProductPage.waitPageLoad();
        
        productsPage = new ProductsPage(driver);
    }

    protected void logIn(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmailField(EMAIL);
        loginPage.fillPasswordField(PASSWORD);
        loginPage.clickLoginButton();
    }

    @When("the user edits the Nombre field with {string}")
    public void theUserEditsTheNombreFieldWith(String name) {
        editProductPage.fillNombreField(name);
    }

    @When("the user edits the Description field with {string}")
    public void theUserEditsTheDescriptionFieldWith(String description) {
        editProductPage.fillDescripcionField(description);
    }

    @When("the user edits the Precio field with {string}")
    public void theUserEditsThePrecioFieldWith(String price) {
        editProductPage.fillPrecioField(price);
    }

    @When("the user edits the Imagen field with {string}")
    public void theUserEditsTheImagenFieldWith(String imageUrl) {
        editProductPage.fillImagenInput(imageUrl);
    }

    @When("the user edits the Talles field with {string}")
    public void theUserEditsTheTallesFieldWith(String sizes) {
        editProductPage.fillTallesField(sizes);
    }

    @When("the user edits the Categoria field selecting {int}")
    public void theUserEditsTheCategoriaFieldSelecting(int index) {
        editProductPage.selectCategoriasSelect(index);
    }

    @When("the user edits the Categoria field selecting none")
    public void theUserEditsTheCategoriaFieldSelectingNone() {
        editProductPage.selectCategoriasSelect(0);
    }

    @When("the user clicks the Guardar button in edit page")
    public void theUserClicksTheGuardarButtonInEditPage() {
        editProductPage.clickOnGuardarButton();
    }

    @Then("the user is redirected to the products page from edit")
    public void theUserIsRedirectedToTheProductsPage() {
        productsPage.waitProductsPageLoad();
        String currentURL = driver.getCurrentUrl();

        Assert.assertEquals(productsUrl, currentURL);
    }

    @Then("the user remains in the product edition page")
    public void theUserRemainsInTheProductEditionPage() {
        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(editProductUrl, currentUrl);
    }

    @Then("all fields in edition are filled except category")
    public void allFieldsAreFilledExceptCategory() {
        editProductPage.waitPageLoad();
        Assert.assertTrue(editProductPage.allFieldFilledExcept(NewProductPage.CATEGORY_FIELD_NAME));
        driver.quit();
    }

    @Then("all fields in edition are filled")
    public void allFieldsAreFilled() {
        editProductPage.waitPageLoad();
        Assert.assertTrue(editProductPage.allFieldFilled());
        driver.quit();
    }

    @Then("all fields in edition are filled except size")
    public void allFieldsAreFilledExceptSize() {
        editProductPage.waitPageLoad();
        Assert.assertTrue(editProductPage.allFieldFilledExcept(NewProductPage.SIZES_FIELD_NAME));
        driver.quit();
    }

    @Then("all fields in edition are filled except image")
    public void allFieldsAreFilledExceptImage() {
        editProductPage.waitPageLoad();
        Assert.assertTrue(editProductPage.allFieldFilledExcept(NewProductPage.IMAGE_FIELD_NAME));
        driver.quit();
    }

    @Then("all fields in edition are filled except price")
    public void allFieldsAreFilledExceptPrice() {
        editProductPage.waitPageLoad();
        Assert.assertTrue(editProductPage.allFieldFilledExcept(NewProductPage.PRICE_FIELD_NAME));
        driver.quit();
    }

    @Then("all fields in edition are filled except name")
    public void allFieldsAreFilledExceptName() {
        editProductPage.waitPageLoad();
        Assert.assertTrue(editProductPage.allFieldFilledExcept(NewProductPage.NAME_FIELD_NAME));
        driver.quit();
    }
}
