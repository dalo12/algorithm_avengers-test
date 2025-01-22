package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.EditProductPage;
import pages.LoginPage;
import pages.NewProductPage;
import pages.ProductsPage;

public class EditProductSteps {
    protected static String EMAIL = "admin@iaw.com";
    protected static String PASSWORD = "admin123";
    protected WebDriver driver;
    protected String editProductUrl = "http://127.0.0.1:8000/productos/product_id/edit";
    protected String productsUrl = "http://127.0.0.1:8000/productos";
    protected EditProductPage editProductPage;
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
    }

    protected void logIn(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmailField(EMAIL);
        loginPage.fillPasswordField(PASSWORD);
        loginPage.clickLoginButton();
    }
}
