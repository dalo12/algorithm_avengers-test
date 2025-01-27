package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public abstract class FormProductPage {
    protected WebDriver driver;
    public static final String NAME_FIELD_NAME = "nombre";
    public static final String DESCRIPTION_FIELD_NAME = "descripcion";
    public static final String PRICE_FIELD_NAME = "precio";
    public static final String IMAGE_FIELD_NAME = "imagen";
    public static final String SIZES_FIELD_NAME = "talles";
    public static final String CATEGORY_FIELD_NAME = "categoria_id";

    public void waitPageLoad(){
        By byNombreField = By.name(NAME_FIELD_NAME);
        WebElement nombreField = driver.findElement(byNombreField);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d->nombreField.isDisplayed());
    }

    public void fillNombreField(String name){
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

    public void fillPrecioField(String price){
        By byPrecioField = By.name(PRICE_FIELD_NAME);
        WebElement precioField = driver.findElement(byPrecioField);
        precioField.clear();
        precioField.sendKeys(price);
    }

    public void fillImagenInput(String image){
        By byImagenInput = By.name(IMAGE_FIELD_NAME);
        WebElement imageInput = driver.findElement(byImagenInput);
        imageInput.clear();
        imageInput.sendKeys(image);
    }

    public void fillTallesField(String sizes){
        By byTallesField = By.name(SIZES_FIELD_NAME);
        WebElement tallesField = driver.findElement(byTallesField);
        tallesField.clear();
        tallesField.sendKeys(sizes);
    }

    public void selectCategoriasSelect(int index){
        By byCategoriasSelect = By.name(CATEGORY_FIELD_NAME);
        WebElement categoriasSelectElement = driver.findElement(byCategoriasSelect);
        Select categoriasSelect = new Select(categoriasSelectElement);

        categoriasSelect.selectByIndex(index);
    }

    public void clickOnGuardarButton(){
        By byGuardarButton = By.cssSelector("input.btn");
        WebElement guardarButton = driver.findElement(byGuardarButton);
        guardarButton.submit();
    }

    public boolean allFieldFilledExcept(String field){
        boolean allFieldsFilled = true;
        List<String> listFieldNames = new ArrayList<String>();
        listFieldNames.add(NAME_FIELD_NAME);
        listFieldNames.add(DESCRIPTION_FIELD_NAME);
        listFieldNames.add(PRICE_FIELD_NAME);
        listFieldNames.add(IMAGE_FIELD_NAME);
        listFieldNames.add(SIZES_FIELD_NAME);

        Map<String, Boolean> fieldsStateMap = new HashMap<String, Boolean>();

        for(String fieldName : listFieldNames){
            By byFieldName = By.name(fieldName);
            boolean isFilled = !driver.findElement(byFieldName).getText().isEmpty();

            fieldsStateMap.put(fieldName, isFilled);
        }

        for(Map.Entry<String, Boolean> entry : fieldsStateMap.entrySet()){
            String fieldName = entry.getKey();
            Boolean isFilled = entry.getValue();

            if(!fieldName.equals(field)){
                allFieldsFilled = allFieldsFilled && isFilled;
            }
        }

        if(field.equals(CATEGORY_FIELD_NAME)){
            By byCategoriasSelect = By.name(CATEGORY_FIELD_NAME);
            WebElement categoriasSelectElement = driver.findElement(byCategoriasSelect);
            Select categoriasSelect = new Select(categoriasSelectElement);
            try {
                categoriasSelect.getFirstSelectedOption();
            }catch(NoSuchElementException e){
                allFieldsFilled = false;
            }
        }

        return allFieldsFilled;
    }

    public boolean allFieldFilled(){
        boolean allFieldsFilled = true;
        List<String> listFieldNames = new ArrayList<String>();
        listFieldNames.add(NAME_FIELD_NAME);
        listFieldNames.add(DESCRIPTION_FIELD_NAME);
        listFieldNames.add(PRICE_FIELD_NAME);
        listFieldNames.add(IMAGE_FIELD_NAME);
        listFieldNames.add(SIZES_FIELD_NAME);

        Map<String, Boolean> fieldsStateMap = new HashMap<String, Boolean>();

        for(String fieldName : listFieldNames){
            By byFieldName = By.name(fieldName);
            boolean isFilled = !driver.findElement(byFieldName).getText().isEmpty();

            fieldsStateMap.put(fieldName, isFilled);
        }

        for(Map.Entry<String, Boolean> entry : fieldsStateMap.entrySet()){
            Boolean isFilled = entry.getValue();

            allFieldsFilled = allFieldsFilled && isFilled;

        }

        By byCategoriasSelect = By.name(CATEGORY_FIELD_NAME);
        WebElement categoriasSelectElement = driver.findElement(byCategoriasSelect);
        Select categoriasSelect = new Select(categoriasSelectElement);
        try {
            categoriasSelect.getFirstSelectedOption();
        }catch(NoSuchElementException e){
            allFieldsFilled = false;
        }

        return allFieldsFilled;
    }

}
