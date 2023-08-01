package test;

import driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;


public class ApiBaseTest extends DriverManager {

    @BeforeTest
    @Parameters(value={"browserName"})
    public void initializeBrowser(@Optional String browserName){
        if(browserName==null){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();

        }else{
            setDriver(browserName);
        }

    }


    @AfterTest
    public  void quitDriver(){
        terminateBrowser();
    }

    public static String screenshotsSubFolderName;

    /*@AfterMethod
    public void screenshotCapture(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(result.getTestContext().getName()+ "_" +result.getMethod().getMethodName()+".jpg");
        }
    }*/
   /* public void captureScreenshot(String fileName) {
        if(screenshotsSubFolderName == null) {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH.mm");
            screenshotsSubFolderName = myDateObj.format(myFormatObj);

        }*/

        /*TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./target/Screenshots/"+ screenshotsSubFolderName+"/"+fileName);
        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot saved successfully");
    }*/


    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;

    }
}
