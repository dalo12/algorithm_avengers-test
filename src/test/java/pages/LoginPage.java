package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillEmailField(String email){
        By emailField = By.id("email");
        driver.findElement(emailField).sendKeys(email);
    }

    public void fillPasswordField(String password){
        By emailField = By.id("password");
        driver.findElement(emailField).sendKeys(password);
    }

    public void clickLoginButton(){
        By loginButton = By.xpath("//button");
        driver.findElement(loginButton).click();
    }
}
