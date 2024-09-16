package org.crowdar.test.login;

import org.crowdar.base.BaseTest;
import org.crowdar.dataproviders.MyDataProvider;
import org.crowdar.helpers.ConfigHelper;
import org.crowdar.objects.Usuario;
import org.crowdar.pages.LoginPage;
import org.crowdar.pages.StorePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeberiaGenerarProcesoDeLoginTest extends BaseTest {

    private final String BASE_URL = ConfigHelper.getConfiguracion().get("baseUrl").textValue();

    @Test(dataProvider = "getUsuarios", dataProviderClass = MyDataProvider.class)
    public void deberiaGenerarLoginExitoso2(Usuario usuario) {
        driver.get(BASE_URL);
        //System.out.println(BASE_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.tipearUsername(usuario.getUser());
        loginPage.tipearPassword(usuario.getPass());
        loginPage.clicEnLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product_sort_container")));
        StorePage storePage = new StorePage(driver);
        String nombreDelValidador = storePage.validarUnElementoExistenteEnStorePage();
        String titulo = driver.getTitle();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(titulo, "Swag Labs");
        Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html");
        String validadorEsperado = "Products";
        Assert.assertEquals(nombreDelValidador, validadorEsperado, "el elemento web no fue encontrado: TEST FAIL");
    }
    @Test(dataProvider = "getUsuarios_invalidos", dataProviderClass = MyDataProvider.class)
    public void deberiaGenerarLoginNegativo(Usuario usuario) {
        driver.get(BASE_URL);
        System.out.println(BASE_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.tipearUsername(usuario.getUser());
        loginPage.tipearPassword(usuario.getPass());
        loginPage.clicEnLoginButton();
        String validarError = loginPage.validarElError();
        String titulo = driver.getTitle();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(titulo, "Swag Labs");
        Assert.assertEquals(url, "https://www.saucedemo.com/");
        String errorEsperado = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(validarError, errorEsperado, "el error no es el esperado: TEST FAIL");
    }
}
