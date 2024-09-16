package org.crowdar.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
public class ConfigHelper {
    private static JsonNode configuration;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static void leerConfiguracion(){
        URL resource = ConfigHelper.class.getClassLoader().getResource("configs/qa_config.json");
        if (resource == null) throw new IllegalArgumentException("archivo de configuracion no encontrado");
        configuration = createJsonNode(new File(resource.getPath()));}
    public static JsonNode getConfiguracion(){
        leerConfiguracion();
        return configuration;
    }
    public static JsonNode createJsonNode(File file) {
        try {
        return objectMapper.readTree(file);
    } catch (FileNotFoundException e) {
        throw new RuntimeException("JSON file not found", e);
    }  catch (Exception e) {
        throw new RuntimeException("Failed to parse JSON string from file", e);
    }
    }
}
