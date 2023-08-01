package test;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import page.*;

public class AkakceTest extends  BaseTest{

    HomePage homePage;
    SearchPage searchPage;
    FollowList followList;

    @Test
    @Description(" Test Cases")
    public void test() throws InterruptedException {
        //initializeBrowser("chrome");
        homePage= new HomePage(driver);
        searchPage =new SearchPage(driver);


        homePage.getAkakcePage()
                //.acceptCookies()
                .isAkakceMainPageOpened()
                        .getAkakceTitle();
        homePage.loginPage()
                .getOpenLoginPage();
        searchPage.search()
                .searchList();
        searchPage.addProduct();
        //followList.followList();














    }

}
