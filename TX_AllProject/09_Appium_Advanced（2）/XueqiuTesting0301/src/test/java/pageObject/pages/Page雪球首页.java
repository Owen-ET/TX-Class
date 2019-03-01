package pageObject.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObject.utils.AppDriver;

/**
 * @author zc
 * @date 2019-03-01 11:50
 */

public class Page雪球首页 {

    By home_search = By.id("home_search");

    // 进入搜索页面
    public Page搜索 enterSearch(){
        AppDriver.driver.findElement(home_search).click();
        return new Page搜索();
    }

    // 进入自选页面
    public void enter自选(){

    }
}
