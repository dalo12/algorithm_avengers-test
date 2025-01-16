package steps.newproduct;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.NewProductPage;

public class NewProductSteps {
    protected static String EMAIL = "admin@iaw.com";
    protected static String PASSWORD = "admin123";
    protected WebDriver driver;
    protected String newProductURL = "http://127.0.0.1:8000/productos/create?";
    protected String productsURL = "http://127.0.0.1:8000/productos";
    protected LoginPage loginPage;
    protected NewProductPage page;
    protected static int QTY_PRODUCTS = 11;

    @Given("the user is in the product creation page")
    public void the_user_is_in_the_product_creation_page(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(newProductURL);
        loginPage = new LoginPage(driver);
        logIn();

        page = new NewProductPage(driver);
    }

    protected void logIn(){
        loginPage.fillEmailField(EMAIL);
        loginPage.fillPasswordField(PASSWORD);
        loginPage.clickLoginButton();
    }

    @When("the user enters {string} in Nombre field")
    public void theUserEntersInNombreField(String name) {
        page.fillNombreField(name);
    }

    @When("the user enters {string} in Descripcion field")
    public void theUserEntersInDescripcionField(String description) {
        page.fillDescripcionField(description);
    }

    @When("the user enters {string} in Precio field")
    public void theUserEntersInPrecioField(String price) {
        page.fillPrecioField(price);
    }

    @When("the user enters {string} in Imagen field")
    public void theUserEntersInImagenField(String image) {
        page.fillImagenInput(image);
    }

    @When("the user enters {string} in Talles field")
    public void theUserEntersInTallesField(String sizes) {
        page.fillTallesField(sizes);
    }

    @When("the user selects {int} in Categoria select")
    public void theUserSelectsInCategoriaSelect(int index) {
        page.selectCategoriasSelect(index);
    }

    @When("the user clicks the Guardar button")
    public void theUserClicksTheGuardarButton() {
        page.clickOnGuardarButton();
    }

    @Then("the user is redirected to the products page")
    public void theUserIsRedirectedToTheProductsPage() {
        Assert.assertEquals(driver.getCurrentUrl(), productsURL);
    }
}
