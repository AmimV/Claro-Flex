package claro.flex.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Comandos {

    private WebDriverWait wait;

    public Comandos(AppiumDriver driver) {
        try {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
            wait = new WebDriverWait(driver, Duration.ofSeconds(15)) {
            };
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao inicializar os elementos da página: " + e.getMessage());
        }
    }

    public void waitClick  (WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            System.out.println("Impossível clicar no elemento selecionado");
            e.printStackTrace();
        }
    }
    public void waitSendKeys(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(text);
        } catch (Exception e) {
            System.out.println("Impossível clicar no elemento selecionado");
            e.printStackTrace();
        }
    }

    public void whileElementFound(WebElement element) {
        boolean elementFound = true;
        while (elementFound) {
            try {
                element.click();
            } catch (Exception e) {
                elementFound = false;
            }
        }
    }

    public void waitElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
