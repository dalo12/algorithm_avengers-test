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


// Before initializing WebDriver in your step definitions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-dev-shm-usage"); // Use /tmp instead of /dev/shm
        options.addArguments("--headless"); // Run in headless mode if no GUI is available
        options.addArguments("--disable-gpu"); // Disable GPU rendering
        options.addArguments("--remote-allow-origins=*"); // Handle potential CORS issues
        options.addArguments("--disable-extensions"); // Disable extensions for stability
        options.addArguments("--disable-software-rasterizer"); // Disable software rendering
        options.addArguments("--disable-setuid-sandbox"); // Disable setuid sandboxing

// Pass the options to the WebDriver
        driver = new ChromeDriver(options);

        //driver = new ChromeDriver();
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
