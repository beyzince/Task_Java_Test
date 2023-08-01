package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    public WebDriver driver;

    public WebDriver setDriver(String browserName){
        switch (browserName){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver(DriverOptions.getChromeOptions());
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver(DriverOptions.getFirefoxOptions());
                break;

        }
        return  driver;
    }

    public  void terminateBrowser(){
        if(driver!=null){
            driver.quit();
        }
    }

}
