package listener;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class GenericListener implements ITestListener {

    public void onStart(ITestResult iTestResult) {
        log.info("start test for"+ iTestResult);
        if(iTestResult.getMethod().isBeforeClassConfiguration()){
            log.info(iTestResult.getMethod().getDescription(),String.valueOf(iTestResult.getStatus()));
        }
    }

    public void onTestFailure(ITestResult iTestResult) {
        log.info("test failed for"+ iTestResult);
        if(iTestResult.getMethod().isBeforeClassConfiguration()){
            log.info(iTestResult.getMethod().getDescription(),String.valueOf(iTestResult.getStatus()));
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
