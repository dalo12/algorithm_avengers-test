package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    protected WebDriver driver;

    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitProductsPageLoad(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By byTitle = By.xpath("/html/body/div/main/legend");
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(byTitle));
    }
}
