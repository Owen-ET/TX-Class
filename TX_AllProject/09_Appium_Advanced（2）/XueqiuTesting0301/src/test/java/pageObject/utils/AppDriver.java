package pageObject.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author zc
 * @date 2019-03-01 15:28
 */

public class AppDriver {

    public static AndroidDriver<AndroidElement> driver;

    public static void launchApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("appPackage","com.xueqiu.android");
        capabilities.setCapability("appActivity",".view.WelcomeActivityAlias");
//        capabilities.setCapability("automationName","uiautomator2");
        capabilities.setCapability("autoGrantPermissions",true);
        // driver实例
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //beforeFun();
    }

    // 前置步骤封装
    public static void beforeFun(){
        locate("//*[@text='开启']").click();
        for (int i=0;i<2;i++){
            locate("com.android.packageinstaller:id/permission_allow_button").click();
        }
        String loc = "//*[@text='好的']";
        try {
            boolean bo = locate(loc).isEnabled();
            if (bo){
                locate(loc).click();
                locate("com.android.packageinstaller:id/permission_allow_button").click();
            }else {
                return;
            }
        }catch (Exception e) {
//            e.printStackTrace();
            System.out.println("没有定位，继续执行！");
        }
    }

    // 封装查找元素方法
    public static WebElement locate(String locator){
        //try {
            if (locator.matches("\\/\\/.*")){
                return driver.findElement(By.xpath(locator));
            }else{
                return driver.findElement(By.id(locator));
            }
        //}finally {
        //    //System.out.println(driver.getPageSource());
        //    for (AndroidElement e : driver.findElementsByXPath("//*")){
        //        //System.out.println(e.getTagName());
        //        System.out.println(e.getText());
        //    }
        //}
    }
}
