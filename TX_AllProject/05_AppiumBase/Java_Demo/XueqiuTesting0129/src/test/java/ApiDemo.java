/**
 * @author zc
 * @date 2019-01-29 14:19
 */

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import javafx.scene.web.WebView;
import org.junit.BeforeClass;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApiDemo {

    private static AndroidDriver<AndroidElement> driver;

    //@BeforeClass
    public static void beforeClass() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("appPackage","com.example.android.apis");
        capabilities.setCapability("appActivity",".ApiDemos");
        capabilities.setCapability("automationName","uiautomator2");
        //capabilities.setCapability("noReset",true);
        //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        // driver实例
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }


    @BeforeClass
    public static void before() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("deviceName","emulator-5554");
        //capabilities.setCapability("deviceName","608ad0fe");
        capabilities.setCapability("appPackage","com.xueqiu.android");
        capabilities.setCapability("appActivity",".view.WelcomeActivityAlias");
//        capabilities.setCapability("automationName","uiautomator2");
        capabilities.setCapability("chromedriverExecutableDir","");

        // driver实例
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        beforeFun();
    }

    @Test
    public void testToast() throws InterruptedException {
        lacate("//*[@text='Views']").click();
        Thread.sleep(1000);

        // 滚动到元素(推荐)
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" +
                        "new UiSelector().text(\"Popup Menu\").instance(0));").click();

        //lacate("//*[@text='Popup Menu']").click();
        lacate("//*[@text='MAKE A POPUP!']").click();
        lacate("//*[@text='Search']").click();
        for (int i=0;i<5;i++){
            //System.out.println(driver.findElementByClassName("android.widget.Toast").getText());

            System.out.println(driver.findElementByXPath("//*[@class='android.widget.Toast']").getText());
            System.out.println(driver.getPageSource());
            Thread.sleep(1000);
        }
    }


    @Test
    public void webview(){
        locate("//*[@text='沪深' and @resource-id='com.xueqiu.android:id/button_text']").click();
        driver.findElementByAccessibilityId("立即开户").click();
        driver.findElementByAccessibilityId("开始").click();
        locate("com.xueqiu.android:id/md_buttonDefaultPositive").click();
        for (int i=0;i<2;i++){
            locate("com.android.packageinstaller:id/permission_allow_button").click();
        }
    }

    @Test
    public void context() throws InterruptedException {
        for (Object c : driver.getContextHandles()){
            System.out.println(c.toString());
        }
        //System.out.println(driver.getPageSource());
        locate("//*[@text='沪深' and @resource-id='com.xueqiu.android:id/button_text']").click();
        System.out.println(" 再打印");
        for (Object c : driver.getContextHandles()){
            System.out.println(c.toString());
        }
        Thread.sleep(3000);
        for (Object c : driver.getContextHandles()){
            System.out.println(c.toString());
        }

        //driver.context("WEBVIEW_com.android.browser");
        //System.out.println(driver.getPageSource());


        //locate("com.xueqiu.android:id/md_buttonDefaultPositive").click();
        //for (int i=0;i<2;i++){
        //    locate("com.android.packageinstaller:id/permission_allow_button").click();
        //}
    }

    //



    public AndroidElement lacate(String lacator){
        if (lacator.matches("\\/\\/.*")){
            return driver.findElement(By.xpath(lacator));
        }else{
            return driver.findElement(By.id(lacator));
        }
    }

    // 封装滑动方法
    public void swipe(double startX, double startY, double endX, double endY) throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        Duration duration = Duration.ofSeconds(1);
        TouchAction action1 = new TouchAction(driver);

        action1.press(PointOption.point((int)(size.width * startX),(int)(size.height * startY)))
                .waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point((int)(size.width * endX),(int)(size.height * endY)))
                .release()
                .perform();
        Thread.sleep(1000);
    }

    // 显式等待封装
    public WebDriverWait waitTime(int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        return wait;
    }


    // 封装查找元素方法
    public static WebElement locate(String locator){
        if (locator.matches("\\/\\/.*")){
            return driver.findElement(By.xpath(locator));
        }else{
            return driver.findElement(By.id(locator));
        }
    }

    // 前置步骤封装a
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

}
