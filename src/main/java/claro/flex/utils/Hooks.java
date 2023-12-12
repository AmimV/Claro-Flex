package claro.flex.utils;

import com.aventstack.extentreports.ExtentReports;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {
    private static AppiumDriver driver;
    public ScenarioContext scenarioContext;

    public Hooks() {
        scenarioContext = new ScenarioContext();
    }

    public static AppiumDriver validarDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "br.com.claro.flex.stg");
        capabilities.setCapability("appActivity", "br.com.claro.flex.features.splash.ui.SplashActivity");
        capabilities.setCapability("newCommandTimeout", 60);

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        return driver;
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            try {
                driver = validarDriver();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {

        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    }

    @After
    public void quitDriver2() {
            quitDriver();
    }
}