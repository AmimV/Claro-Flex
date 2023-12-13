package claro.flex.pages;

import claro.flex.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Getter
public class HomePage {

    public HomePage() {
        AppiumDriver driver = DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "br.com.claro.flex.stg:id/consumption_progress")
    @iOSXCUITFindBy(id = "")
    private WebElement displayConsumption;
}
