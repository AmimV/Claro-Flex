package claro.flex.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:/Users/mathe/IdeaProjects/Claro-Flex2/src/test/reports/tests/relatorio.html");
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }
}

