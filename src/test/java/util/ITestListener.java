package util;

import org.testng.ITestResult;
import test.BaseTest;

public class ITestListener extends BaseTest implements org.testng.ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getTestContext().getName()+ "_" +result.getMethod().getMethodName());
        captureScreenshot(result.getTestContext().getName()+ "_" +result.getMethod().getMethodName()+".jpg");
    }
}
