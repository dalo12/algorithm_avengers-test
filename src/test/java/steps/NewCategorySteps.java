package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.CategoriesPage;
import pages.FormCategoryPage;
import pages.LoginPage;


public class NewCategorySteps {
    protected static final String EMAIL = "admin@iaw.com";
    protected static final String PASSWORD = "admin123";
    protected static final String NEW_CATEGORY_URL = "http://127.0.0.1:8000/categorias/create";
    protected static final String CATEGORIES_URL = "http://127.0.0.1:8000/categorias";
    protected WebDriver driver;
    protected FormCategoryPage newCategoryPage;
    protected CategoriesPage categoriesPage;
    protected int qtyCategories = 0;

    @Given("the user is in the category creation page")
    public void the_user_is_in_the_category_creation_page(){
        System.setProperty("webdriver.chrome.driver", "/snap/chromium/3025/usr/lib/chromium-browser/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/chromium-browser");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get(CATEGORIES_URL);
        logIn();

        categoriesPage = new CategoriesPage(driver);
        categoriesPage.waitPageLoad();
        qtyCategories = categoriesPage.getCategoriesQuantity();

        driver.get(NEW_CATEGORY_URL);

        newCategoryPage = new FormCategoryPage(driver);
        newCategoryPage.waitPageLoad();
    }

    protected void logIn(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmailField(EMAIL);
        loginPage.fillPasswordField(PASSWORD);
        loginPage.clickLoginButton();
    }


    @When("the user enters {string} in Nombre field in category creation page")
    public void theUserEntersInNombreFieldInCategoryCreationPage(String name) {
        newCategoryPage.fillNombreFiled(name);
    }

    @When("the user enters {string} in Descripcion field  in category creation page")
    public void theUserEntersInDescripcionFieldInCategoryCreationPage(String description) {
        newCategoryPage.fillDescripcionField(description);
    }

    @When("the user clicks the Guardar button in category creation page")
    public void theUserClicksTheGuardarButtonInCategoryCreationPage() {
        newCategoryPage.clickOnGuardarButton();
    }

    @Then("the user is redirected to the categories page")
    public void theUserIsRedirectedToTheCategoriesPage() {
        categoriesPage.waitPageLoad();
        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(CATEGORIES_URL, currentUrl);
    }

    @And("there is one more category in the categories page")
    public void thereIsOneMoreCategoryInTheCategoriesPage() {
        Assert.assertEquals(++qtyCategories, categoriesPage.getCategoriesQuantity());
        driver.quit();
    }


}
