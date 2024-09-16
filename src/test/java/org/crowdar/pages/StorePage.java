package org.crowdar.pages;

import io.qameta.allure.Step;
import org.crowdar.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StorePage extends BasePage {
    private final By addToCartButton = By.cssSelector("#add-to-cart-sauce-labs-backpack");
    public StorePage(WebDriver driver) {
        super(driver);
    }
    @Step("AGREGO PRODUCTO AL CARRITO")
    public Carrito clicAddToCartButon(){
        driver.findElement(addToCartButton).click();
        return new Carrito(driver);
    }
    @Step("VALIDAR PRODUCTO EXISTENTE")
    public String validarUnElementoExistenteEnStorePage() {
        WebElement elementoProductos = driver.findElement(By.cssSelector(".title"));
        System.out.println("este es el sub-titulo 'Products' : " + elementoProductos);
        return elementoProductos.getText();
    }

}
