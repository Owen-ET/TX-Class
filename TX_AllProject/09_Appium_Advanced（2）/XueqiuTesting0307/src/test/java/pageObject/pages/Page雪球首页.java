package pageObject.pages;

import org.openqa.selenium.By;
import pageObject.utils.AppDriver;
import pageObject.utils.Functions;

/**
 * @author zc
 * @date 2019-03-01 11:50
 */

public class Page雪球首页 {

    By home_search = By.id("home_search");
    String 自选 = "//*[@text='自选']";
    By 自选_page = By.xpath(自选);
    By 我的_page = By.id("user_profile_icon");


    // 进入搜索页面
    public Page搜索 enterSearch(){
        AppDriver.driver.findElement(home_search).click();
        return new Page搜索();
    }

    // 进入自选页面
    public Page自选 enter自选(){
        Functions.xwait(自选);
        AppDriver.driver.findElement(自选_page).click();
        return new Page自选();
    }

    // 进入我的页面
    public Page我的 enter我的(){
        AppDriver.driver.findElement(我的_page).click();
        return new Page我的();
    }
}
