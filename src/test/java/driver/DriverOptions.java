package driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverOptions {

    private  static ChromeOptions chromeOptions;
    private  static FirefoxOptions firefoxOptions;


    public  static  ChromeOptions getChromeOptions(){
        chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--remote-allow-origins=*");
        return chromeOptions;
    }
    public  static  FirefoxOptions getFirefoxOptions(){
        firefoxOptions=new FirefoxOptions();
        firefoxOptions.addArguments("--disable-notifications");
        firefoxOptions.addArguments("--disable-popup-blocking");
        firefoxOptions.addArguments("--disable-infobars");

        return  firefoxOptions;
    }
}
