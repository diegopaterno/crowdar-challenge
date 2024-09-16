package org.crowdar.pages;

import io.qameta.allure.Step;
import org.crowdar.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private final By username = By.cssSelector("#user-name");
    private final By password = By.cssSelector("#password");
    private final By loginButton = By.cssSelector("#login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Step("INGRESAR USUARIO")
    public void tipearUsername(String user){
        driver.findElement(username).sendKeys(user);
    }
    @Step("INGRESAR CONTRASEÑA")
    public void tipearPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    @Step("HACER CLIC EN BOTON LOGIN")
    public StorePage clicEnLoginButton(){
        driver.findElement(loginButton).click();
        return new StorePage(driver);
    }
    @Step("VALIDAR EL MENSAJE DE ERROR")
    public String validarElError(){
        WebElement mensajeError = driver.findElement(By.xpath("//h3[@data-test='error']"));
        System.out.println("este es el mensaje: "+mensajeError);
        return mensajeError.getText();
    }
}
