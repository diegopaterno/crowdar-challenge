package org.crowdar.test.mercado_libre;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.crowdar.apis.SpecBuilder;
import org.crowdar.helpers.ConfigHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class verificarServicioDeMercadoLibreTest {

   private final String BASE_URI = ConfigHelper.getConfiguracion().get("baseUri").textValue();
    private final String END_POINT = ConfigHelper.getConfiguracion().get("endPoint").textValue();
    @Test
    public void deberiaVerificarDepartamentosDeServicioMercadoLibreTest(){
       Response response = given(SpecBuilder.getRequestSpecification(BASE_URI)).when().get(END_POINT);
        Assert.assertEquals(response.getStatusCode(), 200, "El código de estado no es 200: TEST FAIL");
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("departments"), "La respuesta no contiene 'departamentos': TEST FAIL");
        System.out.println("Respuesta del servicio: " + responseBody);;
    }
}
