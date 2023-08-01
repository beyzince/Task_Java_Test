package page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    public WebDriver driver;
    private WebDriverWait wait;
    JavascriptExecutor js;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        js=(JavascriptExecutor)driver;
        PageFactory.initElements(driver,this);
    }

    public void waitFor(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));


    }

    private WebElement findBy(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }
    public void click(By locator){
        waitFor(locator);
        findBy(locator).click();
    }
    public void setText(By locator, String text){
        waitFor(locator);
        findBy(locator).clear();
        findBy(locator).sendKeys(text);

    }

    public boolean isElementDisplayed(By locator){
        waitFor(locator);
        return  findBy(locator).isDisplayed();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public  void  getPage(String url){
        driver.get(url);
    }
    public String getText(By locator){
        waitFor(locator);
        return findBy(locator).getText();
    }
    protected Boolean contains(By locator, String text) {
        return getText(locator).contains(text);
    }
//    public void scrollDown(){
//        js.executeScript("window.scrollBy(0,600)");
//    }
//
//    public void scrollDownByValue(int value){
//        String script = "window.scrollBy(0,"+ value + ")";
//        js.executeScript(script);
//    }

    public void scrollToPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

    }

    protected void selection(By locator, String text) {
        Select select = new Select(findBy(locator));
        select.selectByVisibleText(text);
    }
    public void scrollToElement(By locator) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", findBy(locator));
}

    public List<WebElement> listElements(By locator){

        return driver.findElements(locator);
    }



//    public String getTextAttribute(By locator) {
//        return findBy(locator).getAttribute("innerHTML");
//    }
    public void elementJS( By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", findBy(locator));

    }


}
