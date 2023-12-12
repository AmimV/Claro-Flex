package claro.flex.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AssertionHelper {

    public static Comandos comandosUtils;
    private static WebDriverWait wait;
    public ScenarioContext scenarioContext;

    public AssertionHelper() {
        scenarioContext = new ScenarioContext();
        AppiumDriver driver = scenarioContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        comandosUtils = new Comandos(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void assertTwoElementDisplayed(WebElement element1, WebElement element2) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element1));
            Assert.assertTrue(element1.isEnabled());
        } catch (NoSuchElementException e1) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element2));
                Assert.assertTrue(element2.isDisplayed());
            } catch (NoSuchElementException e2) {
                Assert.fail("Não foi encontrado nenhum dos elementos esperados");
            }
        }
    }
}