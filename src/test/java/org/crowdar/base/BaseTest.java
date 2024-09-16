package org.crowdar.base;

import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.crowdar.factory.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;

    protected WebDriver getDriver(){
        return this.driver;
    }

    @BeforeMethod
    public void startDriver(){
        driver = new DriverManager().getDriver();
    }

    @Parameters("browser")
    @AfterMethod
    public synchronized void quitDriver(@Optional String browser, ITestResult result) throws InterruptedException, IOException {

        if(result.getStatus() == ITestResult.FAILURE){
            File destFile = new File("scr" + File.separator + browser + File.separator +
                    result.getTestClass().getRealClass().getSimpleName() + "_" +
                    result.getMethod().getMethodName() + ".png");
              takeScreenshot(destFile);
        }
        driver.quit();
    }
    @Step("Se incluye captura de pantalla del error")
    private void takeScreenshot(File destFile) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, destFile);
    }
}
