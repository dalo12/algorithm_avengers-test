package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormCategoryPage {
    protected static final String NAME_FIELD_NAME = "nombre";
    protected static final String DESCRIPTION_FIELD_NAME = "descripcion";
    protected WebDriver driver;

    public FormCategoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitPageLoad(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By byNombre = By.name("nombre");
        wait.until(ExpectedConditions.visibilityOfElementLocated(byNombre));
    }

    public void fillNombreFiled(String name){
        By byNombreField = By.name(NAME_FIELD_NAME);
        WebElement nombreField = driver.findElement(byNombreField);
        nombreField.clear();
        nombreField.sendKeys(name);
    }

    public void fillDescripcionField(String description){
        By byDescripcionField = By.name(DESCRIPTION_FIELD_NAME);
        WebElement descripcionField = driver.findElement(byDescripcionField);
        descripcionField.clear();
        descripcionField.sendKeys(description);
    }

    public void clickOnGuardarButton(){
        By byGuardarButton = By.cssSelector("input.btn");
        WebElement guardarButton = driver.findElement(byGuardarButton);
        guardarButton.submit();
    }

    public boolean descripcionFieldIsFilled(){
        By byDescripcionField = By.name(DESCRIPTION_FIELD_NAME);
        WebElement descripcionField = driver.findElement(byDescripcionField);
        return !descripcionField.getText().isEmpty();
    }
}
