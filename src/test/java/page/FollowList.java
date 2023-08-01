package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class FollowList extends  BasePage{
    public FollowList(WebDriver driver) {
        super(driver);
    }
    private  By followbutton= By.xpath("//*[@id=\"H_f_v8\"]");


    public FollowList followList(){
        click(followbutton);
        Assert.assertEquals(isElementDisplayed(followbutton),true,"follow list is not opened");


        return this;
    }
}
