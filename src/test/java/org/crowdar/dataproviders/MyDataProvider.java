package org.crowdar.dataproviders;

import org.crowdar.objects.Usuario;
import org.crowdar.utils.JacksonUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class MyDataProvider {

    @DataProvider(name = "getUsuarios", parallel = false)
    public Object[] getUsuarios() throws IOException {
        return JacksonUtils.deserializeJson("usuarios.json", Usuario[].class);
    }
    @DataProvider(name = "getUsuarios_invalidos", parallel = false)
    public Object[] getUsuariosInvalidos() throws IOException {
        return JacksonUtils.deserializeJson("usuarios_invalidos.json", Usuario[].class);
    }
}
