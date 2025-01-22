package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditProductPage extends FormProductPage {

    public EditProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitPageLoad(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By byLegendEdit = By.xpath("/html/body/div/main/form/legend");
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLegendEdit));
    }
}
