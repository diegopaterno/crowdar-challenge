package org.crowdar.test.carrito;

import com.fasterxml.jackson.databind.JsonNode;
import org.crowdar.base.BaseTest;
import org.crowdar.helpers.ConfigHelper;
import org.crowdar.pages.Carrito;
import org.crowdar.pages.LoginPage;
import org.crowdar.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class deberiaAgregarProductosAlCarritoTest extends BaseTest {
    private final String BASE_URL = ConfigHelper.getConfiguracion().get("baseUrl").textValue();
    private final JsonNode TEST_DATA = ConfigHelper.getConfiguracion().get("test_data");

    @Test
    public void agregarProductoAlCarrito(){
        driver.get(BASE_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.tipearUsername(TEST_DATA.get("username").textValue());
        loginPage.tipearPassword(TEST_DATA.get("password").textValue());
        loginPage.clicEnLoginButton();
        StorePage storePage = new StorePage(driver);
        storePage.clicAddToCartButon();
        Carrito carrito = new Carrito(driver);
        String nombreDelProducto = carrito.verProductoAgregadoAlCarrito();
        System.out.println("este es el nombre del producto agregado: "+nombreDelProducto);
        String nombreEsperado = "Sauce Labs Backpack";
        Assert.assertEquals(nombreDelProducto, nombreEsperado, "El nombre del producto en el carrito no es el esperado.");
    }
}
