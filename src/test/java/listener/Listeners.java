package listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    private static final Logger log = LogManager.getLogger(Listeners.class);
    @Override
    public void onTestStart(ITestResult result) {
        log.debug("Test "+result.getName()+" started");
    }

    public void onTestSuccess(ITestResult result) {
    }

    public void onTestFailure(ITestResult result) {
        log.error("Test "+result.getName()+" Failed!!!!!!!!!");
    }

    public void onTestSkipped(ITestResult result) {log.error("Test "+result.getName()+" Skipped");}

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }
}
