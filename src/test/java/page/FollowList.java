package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class FollowList extends  BasePage{
    public FollowList(WebDriver driver) {
        super(driver);
    }
    private  By followbutton= By.xpath("//*[@id=\"pf_w_v8\"]/span");


    public FollowList followList(){
        click(followbutton);
        Assert.assertEquals(isElementDisplayed(followbutton),true,"follow list is not opened");


        return new FollowList(driver);
    }
}
