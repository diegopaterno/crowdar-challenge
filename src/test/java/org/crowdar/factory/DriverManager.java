package org.crowdar.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    WebDriver driver;

    /**
     * descarga el ejecutable para evitar incompatibilidad de versiones
    * Inicializa chromedriver
    * */
    public WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getDriver() {
        String browser = System.getProperty("browser");
        switch (browser){
            case "Chrome":
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Nombre de navegador invalido : "+browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
}
