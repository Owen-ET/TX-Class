package pageObject.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObject.pages.Page搜索;
import pageObject.pages.Page雪球首页;

import java.lang.reflect.Parameter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zc
 * @date 2019-03-01 15:28
 */

// 数据驱动参数化的类
@RunWith(Parameterized.class)
public class AppDriver {

    public static AndroidDriver<AndroidElement> driver;

    @Parameterized.Parameters
    public static List<String[]> data(){
        return Arrays.asList(new String[][]{
                {"6.0","192.168.56.101:5555"}
                ,{"7.0","emulator-5554"}
        });
    }
    @Parameterized.Parameter
    public String version;
    @Parameterized.Parameter(1)
    public String deviceName;

//    @Before
    public void launchApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("platformVersion","7.0");
        capabilities.setCapability("appPackage","com.xueqiu.android");
        capabilities.setCapability("appActivity",".view.WelcomeActivityAlias");
//        capabilities.setCapability("automationName","uiautomator2");
        // 默认加手机权限
        capabilities.setCapability("autoGrantPermissions",true);
        // driver实例
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //beforeFun();
    }

    // 数据驱动
//    @Test
//    public void search(){
//        Page雪球首页 首页 = new Page雪球首页();
//        Page搜索 搜索 = 首页.enterSearch();
////        搜索.search("pdd");
////        String po = 搜索.getStock();
////        assertThat(po,equalTo("拼多多"));
//    }

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
