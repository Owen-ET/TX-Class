package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author zc
 * @date 2021-02-04 17:31
 */

public class BasePage {


    static WebDriver driver = new ChromeDriver();
    static WebDriverWait wait;

    static void open(){
        //  启动Chrome浏览器
        driver.get("https://testerhome.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    static WebElement find(By loc){
        // 单元素定位
        return driver.findElement(loc);
    }


    static WebElement finds(By loc, int num){
        // 多元素定位
        return driver.findElements(loc).get(num);
    }


    static WebElement explicitWait(By loc){
        //  显式等待
        wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
    }


    static void click(By loc){
        // 点击操作
        find(loc).click();
    }


    static void sendKeys(By loc,String text){
        // 输入操作
        find(loc).sendKeys(text);
    }


    static void clear(By loc){
        // 清空操作
        find(loc).clear();
    }


    static String getText(By loc){
        // 单元素获取文本
        return find(loc).getText();
    }


    static String getTexts(By loc,int num){
        // 多元素获取文本
        return finds(loc,num).getText();
    }
    /*
    test static

     */
}
