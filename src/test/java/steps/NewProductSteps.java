package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

public class NewProductSteps {
    protected WebDriver driver;
    protected String newProductURL = "http://127.0.0.1:8000/productos/create?";
    protected NewProductPage newProductPage;

    public NewProductSteps(WebDriver driver)

    @Given("the user is in the product creation page")
    public void the_user_is_in_the_product_creation_page(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(newProductURL);

        NewProductPage page = NewProductPage(driver);
    }


}
