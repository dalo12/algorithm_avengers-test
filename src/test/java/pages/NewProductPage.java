package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewProductPage {
    protected WebDriver driver;

    public NewProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillNombreField(String name){
        By nombreField = By.name("nombre");
        driver.findElement(nombreField).sendKeys(name);
    }

    public void fillDescripcionField(String description){
        By descripcionField = By.name("descripcion");
        driver.findElement(descripcionField).sendKeys(description);
    }

    public void fillPrecioField(String price){
        By precioField = By.name("precio");
        driver.findElement(precioField).sendKeys(price);
    }

    public void fillImagenInput(String image){
        By imagenInput = By.name("imagen");
        driver.findElement(imagenInput).sendKeys(image);
    }

    public void fillTallesField(String sizes){
        By tallesField = By.name("talles");
        driver.findElement(tallesField).sendKeys(sizes);
    }

    public void selectCategoriasSelect(int index){
        By byCategoriasSelect = By.name("categoria_id");
        WebElement categoriasSelectElement = driver.findElement(byCategoriasSelect);
        Select categoriasSelect = new Select(categoriasSelectElement);

        categoriasSelect.selectByIndex(index);
    }

    public void clickOnGuardarButton(){
        By byGuardarButton = By.cssSelector("input.btn");
        WebElement guardarButton = driver.findElement(byGuardarButton);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", guardarButton);
        guardarButton.click();
    }

}
