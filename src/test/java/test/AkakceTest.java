package test;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import page.*;

public class AkakceTest extends  BaseTest{



      HomePage homePage;
      SearchPage searchPage;


    @Test
    @Description(" Test Cases")
    public void test() throws InterruptedException {
        //initializeBrowser("chrome");
        homePage= new HomePage(driver);
        searchPage =new SearchPage(driver);


        homePage.getAkakcePage()
                .acceptCookies().isAkakceMainPageOpened();
        homePage.getOpenLoginPage();
        homePage.loginPage();
        searchPage.search().searchList();
        searchPage.addProduct();














    }

}
