package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.FormProductPage;
import pages.LoginPage;
import pages.NewProductPage;
import pages.ProductsPage;

public class NewProductSteps {
    protected static String EMAIL = "admin@iaw.com";
    protected static String PASSWORD = "admin123";
    protected WebDriver driver;
    protected String newProductURL = "http://127.0.0.1:8000/productos/create";
    protected String productsURL = "http://127.0.0.1:8000/productos";
    protected FormProductPage newProductPage;
    protected ProductsPage productsPage;
    protected int productsQty;

    @Given("the user is in the product creation page")
    public void the_user_is_in_the_product_creation_page(){
        System.setProperty("webdriver.chrome.driver", "/snap/chromium/3025/usr/lib/chromium-browser/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/chromium-browser");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        productsPage = new ProductsPage(driver);

        driver.get(productsURL);
        logIn();
        getCurrentProductsQty();

        driver.get(newProductURL);
        newProductPage = new NewProductPage(driver);
        newProductPage.waitPageLoad();
    }

    protected void getCurrentProductsQty(){
        productsPage.waitProductsPageLoad();
        productsQty = productsPage.getProductsQty();
    }

    protected void logIn(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmailField(EMAIL);
        loginPage.fillPasswordField(PASSWORD);
        loginPage.clickLoginButton();
    }

    @When("the user enters {string} in Nombre field")
    public void theUserEntersInNombreField(String name) {
        newProductPage.fillNombreField(name);
    }

    @When("the user enters {string} in Descripcion field")
    public void theUserEntersInDescripcionField(String description) {
        newProductPage.fillDescripcionField(description);
    }

    @When("the user enters {string} in Precio field")
    public void theUserEntersInPrecioField(String price) {
        newProductPage.fillPrecioField(price);
    }

    @When("the user enters {string} in Imagen field")
    public void theUserEntersInImagenField(String image) {
        newProductPage.fillImagenInput(image);
    }

    @When("the user enters {string} in Talles field")
    public void theUserEntersInTallesField(String sizes) {
        newProductPage.fillTallesField(sizes);
    }

    @When("the user selects {int} in Categoria select")
    public void theUserSelectsInCategoriaSelect(int index) {
        newProductPage.selectCategoriasSelect(index);
    }

    @When("the user clicks the Guardar button")
    public void theUserClicksTheGuardarButton() {
        newProductPage.clickOnGuardarButton();
    }

    @Then("the user is redirected to the products page")
    public void theUserIsRedirectedToTheProductsPage() {
        productsPage.waitProductsPageLoad();
        String currentURL = driver.getCurrentUrl();

        Assert.assertEquals(productsURL, currentURL);
    }

    @And("there is one more product in the products page")
    public void thereIsOneMoreProductInTheProductsPage() {
        Assert.assertEquals(++productsQty, productsPage.getProductsQty());
        driver.quit();
    }

    @Then("the user remains in the product creation page")
    public void theUserRemainsInTheProductCreationPage() {
        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(newProductURL, currentUrl);
    }

    @And("all fields are filled except category")
    public void allFieldsAreFilledExceptCategory() {
        newProductPage.waitPageLoad();
        Assert.assertTrue(newProductPage.allFieldFilledExcept(NewProductPage.CATEGORY_FIELD_NAME));
        driver.quit();
    }

    @And("all fields are filled")
    public void allFieldsAreFilled() {
        newProductPage.waitPageLoad();
        Assert.assertTrue(newProductPage.allFieldFilled());
        driver.quit();
    }

    @And("all fields are filled except size")
    public void allFieldsAreFilledExceptSize() {
        newProductPage.waitPageLoad();
        Assert.assertTrue(newProductPage.allFieldFilledExcept(NewProductPage.SIZES_FIELD_NAME));
        driver.quit();
    }

    @And("all fields are filled except image")
    public void allFieldsAreFilledExceptImage() {
        newProductPage.waitPageLoad();
        Assert.assertTrue(newProductPage.allFieldFilledExcept(NewProductPage.IMAGE_FIELD_NAME));
        driver.quit();
    }

    @And("all fields are filled except price")
    public void allFieldsAreFilledExceptPrice() {
        newProductPage.waitPageLoad();
        Assert.assertTrue(newProductPage.allFieldFilledExcept(NewProductPage.PRICE_FIELD_NAME));
        driver.quit();
    }

    @And("all fields are filled except name")
    public void allFieldsAreFilledExceptName() {
        newProductPage.waitPageLoad();
        Assert.assertTrue(newProductPage.allFieldFilledExcept(NewProductPage.NAME_FIELD_NAME));
        driver.quit();
    }
}
