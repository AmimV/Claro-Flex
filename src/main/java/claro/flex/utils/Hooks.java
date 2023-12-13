package claro.flex.utils;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private AddScreenShots addScreenShots;

    public Hooks() {
        addScreenShots = new AddScreenShots();
    }

    @Before
    public void setUp(Scenario scenario) {
        DriverManager.getDriver();
        addScreenShots.deleteDirectory(scenario.getName());
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        addScreenShots.addScreenshot(scenario, DriverManager.getDriver());
    }

    @After
    public void exitDriver(Scenario scenario) {
            DriverManager.quitDriver(scenario);
    }
}