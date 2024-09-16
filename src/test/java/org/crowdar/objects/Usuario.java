package org.crowdar.objects;

import org.crowdar.utils.JacksonUtils;

import java.io.IOException;

public class Usuario {
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    private String user;
    private String pass;
    public Usuario() {
    }
    public Usuario(String user) throws IOException {
        Usuario[] usuarios = JacksonUtils.deserializeJson("usuarios.json", Usuario[].class);
        for (Usuario usuario: usuarios){
            if (usuario.getUser() == user){
                this.user = user;
                this.pass = usuario.getPass();
            }
        }
    }
}
