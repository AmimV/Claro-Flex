package claro.flex.utils;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddScreenShots {

    public void addScreenshot(Scenario scenario, AppiumDriver driver) {

        try {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
            String directoryPath = "screenshots/" + scenarioName + "/";
            Files.createDirectories(Paths.get(directoryPath));

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = "screenshot_" + timestamp + ".png";

            Path screenshotPath = Paths.get(directoryPath, fileName);
            Files.write(screenshotPath, screenshot);
            scenario.attach(screenshot, "image/png", "Screenshot: " + scenarioName);
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDirectory(String scenario) {
        String scenarioName = scenario.replaceAll("[^a-zA-Z0-9]", "_");
        File directory = new File("screenshots/" + scenarioName);
        if (!directory.exists()) {
            return;
        }

        if (directory.list().length == 0) {
            directory.delete();
            return;
        }

        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                file.delete();
            } else {
                deleteDirectory("screenshots/" + scenarioName);
            }
        }
        directory.delete();
    }
    }

