package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchPage extends  BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private By searchnav= By.xpath("//*[@id=\"q\"]");
    private  By searchlocator=By.xpath("//*[@id=\"H_s_v8\"]/button");
    private  By  product=By.xpath("//*[@id=\"CPL\"]/li[1]/a/span/span[5]");
    private  By follow = By.xpath("//*[@id=\"pf_w_v8\"]/span");


    public SearchPage search(){
        //click(searchnav);
        setText(searchnav,"iphone");
        click(searchlocator);
        return this;
    }


    public void searchList(){
        List<WebElement> allProduct = driver.findElements(By.xpath("//ul[@id='CPL']/li"));

        for( WebElement product : allProduct){

            System.out.println(product.getText());
            System.out.println("test");


    }
        //allProduct.get(0).click();
        System.out.println("test2");

    }


    public SearchPage addProduct(){

        click(product);
        scrollToPage();
        scrollToElement(follow);
        Assert.assertTrue(isElementDisplayed(follow),"follow  not screen!");

        //elementJS(follow);
        return  this;

    }
}
