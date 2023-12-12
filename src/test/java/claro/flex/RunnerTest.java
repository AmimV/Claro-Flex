package claro.flex;

import claro.flex.utils.Hooks;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"claro.flex.utils", "claro.flex.steps"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "pretty"},
        features = "src/test/resources/features.login",
        tags = "@test"
)

public class RunnerTest {

    @BeforeClass
    public static void getDriver() {
        Hooks.getDriver();
    }
}
