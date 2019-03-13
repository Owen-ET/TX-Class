package com.tester.et.wechat.api.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author zc
 * @date 2019-03-13 11:38
 */

public class AppDriver {

    public AppiumDriver appiumDriver;

    static AppDriver driver;
    public static AppDriver getInstance(){
        if (driver==null){
            driver = new AppDriver();
        }
        return driver;
    }

    public void start() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("deviceName","xxx");
        capabilities.setCapability("appPackage","com.tencent.wework");
        capabilities.setCapability("appActivity",".launch.LaunchSplashActivity");
        capabilities.setCapability("autoGrantPermissions",true);
        // 数据不重置
        capabilities.setCapability("noReset",true);

        appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

    // 追加一个方法封装，定位一个元素
    public WebElement find(By by){
        return appiumDriver.findElement(by);
    }
}
