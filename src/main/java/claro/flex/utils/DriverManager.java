package claro.flex.utils;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static AppiumDriver driver;

    private DriverManager() {

    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            initializeDriver();
            System.out.println("Driver iniciado com sucesso");
        }
        return driver;
    }

    private static void initializeDriver() {
        // Lógica de inicialização do driver
        // Exemplo: Configuração de DesiredCapabilities e criação do driver
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "br.com.claro.flex.stg");
        capabilities.setCapability("appActivity", "br.com.claro.flex.features.splash.ui.SplashActivity");
        capabilities.setCapability("newCommandTimeout", 60);

        try {
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void quitDriver(Scenario scenario) {
        if (driver != null) {
            driver.quit();
            driver = null;
            scenario.log("Driver encerrado com sucesso");
        }
    }
}