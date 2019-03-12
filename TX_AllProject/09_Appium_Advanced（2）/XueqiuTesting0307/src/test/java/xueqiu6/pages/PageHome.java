package xueqiu6.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xueqiu6.utils.AppDriver;

/**
 * @author zc
 * @date 2019-03-12 10:05
 */

// 首页
public class PageHome {

    /*
    定位元素
     */
    //  搜索框
    By homeSearch = By.id("tv_search");
    //  我的
    By profile = By.id("user_profile_icon");


    //  定义搜索页面
    public PageSearch enterSearch(){
        AppDriver.driver.findElement(homeSearch).click();
        return new PageSearch();
    }

    // 进入我的页面
    public PageProfile enterProfile(){
        AppDriver.driver.findElement(profile).click();
        return new PageProfile();
    }
}
