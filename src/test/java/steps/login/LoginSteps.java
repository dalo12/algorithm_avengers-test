package steps.login;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;
import pages.LoginPage;

import java.time.Duration;

public class LoginSteps {
    protected WebDriver driver;
    protected String loginURL = "http://127.0.0.1:8000/";
    protected String dashboardURL = "http://127.0.0.1:8000/dashboard";
    protected LoginPage loginPage;
    protected Wait<WebDriver> wait;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(loginURL);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
    }

    @When("the user enters {string} as email and {string} as password")
    public void the_user_enters_email_and_password(String email, String password){
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField(password);
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button(){
        loginPage.clickLoginButton();
    }

    @Then("the user is redirected to the dashboard page")
    public void the_user_is_redirected_to_the_dashboard_page(){
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.waitDashboardPageLoad();

        String currentUrl = driver.getCurrentUrl();
        driver.quit();

        Assert.assertEquals(dashboardURL, currentUrl);
    }

    @Then("the user remains in the login page")
    public void the_user_remains_in_the_login_page(){
        String currentUrl = driver.getCurrentUrl();
        driver.quit();

        Assert.assertEquals(loginURL, currentUrl);
    }
}
