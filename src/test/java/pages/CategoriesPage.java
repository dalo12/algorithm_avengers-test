package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CategoriesPage {
    WebDriver driver;

    public CategoriesPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitPageLoad(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By byLegend = By.xpath("/html/body/div/main/legend");
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLegend));
    }

    public int getCategoriesQuantity(){
        int qty = 0;

        By byQty = By.xpath("/html/body/nav/div[2]/div[1]/p/span[3]");
        List<WebElement> qtyList = driver.findElements(byQty);
        boolean qtyIsPresent = !qtyList.isEmpty();

        if(qtyIsPresent){
            WebElement qtyElement = qtyList.getFirst();
            String qtyText = qtyElement.getText();
            qty = Integer.parseInt(qtyText);
        }else{
            By byRows = By.xpath("/html/body/div/main/table/tbody/tr");
            List<WebElement> rows = driver.findElements(byRows);
            qty = rows.size();
        }

        return qty;
    }
}
