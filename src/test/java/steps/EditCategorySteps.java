package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.FormCategoryPage;
import pages.LoginPage;

public class EditCategorySteps {
    protected static final String EMAIL = "admin@iaw.com";
    protected static final String PASSWORD = "admin123";
    protected static final String CATEGORIES_URL = "http://127.0.0.1:8000/categorias";
    protected String editCategoryUrl = "http://127.0.0.1:8000/categorias/category_id/edit";
    protected WebDriver driver;
    protected FormCategoryPage editCategoryPage;


    @Given("the user is in the edition page of category with id {string}")
    public void the_user_is_in_the_edition_page_of_category_with_id(String id){
        System.setProperty("webdriver.chrome.driver", "/snap/chromium/3025/usr/lib/chromium-browser/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/chromium-browser");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        editCategoryUrl = editCategoryUrl.replaceFirst("category_id", id);

        driver.get(editCategoryUrl);
        logIn();

        editCategoryPage = new FormCategoryPage(driver);
        editCategoryPage.waitPageLoad();
    }

    protected void logIn(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmailField(EMAIL);
        loginPage.fillPasswordField(PASSWORD);
        loginPage.clickLoginButton();
    }

    @When("the user edits the category Nombre field with {string}")
    public void theUserEditsTheCategoryNombreFieldWith(String name) {
        editCategoryPage.fillNombreFiled(name);
    }

    @When("the user edits the category Descripcion field with {string}")
    public void theUserEditsTheCategoryDescripcionFieldWith(String description) {
        editCategoryPage.fillDescripcionField(description);
    }

    @When("the user clicks the Guardar button in category edition page")
    public void theUserClicksTheGuardarButtonInCategoryEditionPage() {
        editCategoryPage.clickOnGuardarButton();
    }

    @Then("the user is redirected to the categories page from edit")
    public void theUserIsRedirectedToTheCategoriesPageFromEdit() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(CATEGORIES_URL, currentUrl);
        driver.quit();
    }

    @Then("the user remains in the category edition page")
    public void theUserRemainsInTheCategoryEditionPage() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(editCategoryUrl, currentUrl);
    }

    @And("the descripcion field is filled in edition page")
    public void theDescripcionFieldIsFilledInEditionPage() {
        Assert.assertTrue(editCategoryPage.descripcionFieldIsFilled());
        driver.quit();
    }
}
