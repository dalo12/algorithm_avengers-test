package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    protected WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitDashboardPageLoad(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By byMessage = By.xpath("/html/body/div/main/div/h4/div");
        wait.until(ExpectedConditions.visibilityOfElementLocated(byMessage));
    }

}
