package com.tester.et.wechat.api.page;

import com.tester.et.wechat.api.driver.AppDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author zc
 * @date 2019-03-13 14:00
 */

public class BasePage {
    WebElement findElement(By by){
        // TODO:弹框处理
        return AppDriver.getInstance().find(by);
    }

    // click方法①
    public void click(By by){
        findElement(by).click();
    }

    // click方法②
    public void click(String text){
        findElement(byText(text)).click();
    }

    // ①之前默认定位过元素，直接输入值
    public void sendKeys(String content){
        AppDriver.getInstance().appiumDriver.getKeyboard().sendKeys(content);
    }

    // ②定位并输入值
    public void sendKeys(By by,String content){
        findElement(by).sendKeys(content);
    }

    // 定位简写
    public By byText(String text){
        return By.xpath("//*[@text='"+ text +"']");
    }

    // 获取属性
    public String attribute(By by,String name){
        return findElement(by).getAttribute(name);
    }
}
