package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

public class LoginSteps {
    protected WebDriver driver;
    protected String URL = "http://127.0.0.1:8000/";
    protected String dashboardURL = "http://127.0.0.1:8000/dashboard";
    protected LoginPage loginPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page(){
        System.setProperty("webdriver.chrome.verboseLogging", "true");
        //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        //ChromeOptions options = new ChromeOptions();
        //options.setBinary("/usr/bin/chromium-browser");
        //driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        loginPage = new LoginPage(driver);
    }

    @When("the user enters {string} as email and {string} as password")
    public void the_user_enters_email_and_password(String email, String password){
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField(password);
    }

    @Then("the user is redirected to the dashboard page")
    public void the_user_is_redirected_to_the_dashboard_page(){
        Assert.assertEquals(driver.getCurrentUrl(), dashboardURL);
    }
}
