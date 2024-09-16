package org.crowdar.pages;

import io.qameta.allure.Step;
import org.crowdar.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.PreparedStatement;

public class Carrito extends BasePage {
    public Carrito(WebDriver driver) {
        super(driver);
    }
    @Step("VALIDAR PRODUCTO EN CARRITO")
    public String verProductoAgregadoAlCarrito() {
        WebElement producto = driver.findElement(By.className("inventory_item_name"));
        return producto.getText();
    }
}
