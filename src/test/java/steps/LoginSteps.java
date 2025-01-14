package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class LoginSteps {
    protected WebDriver driver;
    protected String URL = "http://127.0.0.1:8000/";
    protected LoginPage loginPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        loginPage = new LoginPage(driver);
    }

}
