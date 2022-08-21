package listeners;

import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

@Slf4j
public class TestListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        log.info("onTestStart for " + iTestResult);
        if (iTestResult.getMethod().isBeforeClassConfiguration()) {
            log.info(iTestResult.getMethod().getMethodName());
        }
    }
    public void onFinish(ITestResult iTestResult) {
        log.info("onTestFinish for " + iTestResult);
        if (iTestResult.getMethod().isAfterClassConfiguration()) {
            log.info(iTestResult.getMethod().getMethodName());
        }
    }

    public void onTestFailure(ITestResult iTestResult) {
        log.info("onTestFailure for " + iTestResult);
        log.info(iTestResult.getTestName() + " " +
                iTestResult.getMethod().getDescription(), String.valueOf(iTestResult.getStatus()));
    }

    @Attachment(value = "Screenshot", type ="image/png")
    public byte[] screenshot(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

}