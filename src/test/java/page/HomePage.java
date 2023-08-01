package page;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends  BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    static  String PAGE_URL="https://www.akakce.com/";
    private By acceptCookiesButton= By.cssSelector("div.banner > div.banner__accept-button");

    private By logoAkakce = By.xpath("//*[@id=\"H_l_v8\"]");
    private By emaillocator = By.xpath("//*[@id=\"life\"]");

    private By passwordlocator = By.xpath("//*[@id=\"lifp\"]");
    private By butonsubmit = By.xpath("//*[@id=\"lfb\"]");
    private  By girisbutton=By.xpath("    //*[@id=\"H_rl_v8\"]/a[2]\n");
    private  By account= By.xpath("//*[@id=\"HM_v8\"]/i/a");
    private  By hesap= By.xpath("  //*[@id=\"H_a_v8\"]");

    @Step("Go to Akakce Home Page")
    public  HomePage getAkakcePage(){
        getPage(PAGE_URL);
        return this;
    }

    @Step("Accepting cookies")
    public  HomePage  acceptCookies() throws InterruptedException {
        Thread.sleep(2000);
        //click(acceptCookiesButton);
        return  this;
    }

    @Step("Verify Akakce Page is opened")
    public HomePage isAkakceMainPageOpened(){
        Assert.assertEquals(isElementDisplayed(logoAkakce),true,"home page is not opened");
        return  this;
    }


    @Step("Page Title")
    public  String getAkakceTitle(){
        Assert.assertEquals("Ne Nerede En Ucuz Akakçe'de",getPageTitle(),"Not on home page");
        return getPageTitle();

    }
    public HomePage loginPage(){
        click(girisbutton);
        setText(emaillocator,"beyzaa0204@gmail.com");
        setText(passwordlocator,"Beyza0600");
        click(butonsubmit);
        return this;

     }
     public  HomePage getOpenLoginPage(){
         Assert.assertEquals(isElementDisplayed(hesap),true,"login page is not opened");

         return  this;
     }

}
