package claro.flex.utils;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Scenario;

public class ScenarioContext {
    private final AppiumDriver driver;

    public ScenarioContext() {
        driver = Hooks.getDriver();
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void quitDriver(Scenario scenario) {
        if (driver != null) {
            Hooks.quitDriver();
            scenario.log("Driver encerrado com sucesso");
        }
    }
}