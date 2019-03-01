import io.appium.java_client.AppiumDriver;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.aspectj.util.FileUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zc
 * @date 2019-01-29 10:57
 */

public class TestXueqiuDemo {
    private static AndroidDriver<AndroidElement> driver;

    //@BeforeClass
    public static void beforeClass() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("appPackage","com.example.android.apis");
        capabilities.setCapability("appActivity",".ApiDemos");
//        capabilities.setCapability("automationName","uiautomator2");
        // driver实例
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//        beforeFun();
    }


    @BeforeClass
    public static void before() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("appPackage","com.xueqiu.android");
        capabilities.setCapability("appActivity",".view.WelcomeActivityAlias");
//        capabilities.setCapability("automationName","uiautomator2");

        // driver实例
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        beforeFun();
    }

    @Test
    public void demo() throws InterruptedException {
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        System.out.println("点击自选");
        locate("//*[@text='自选']").click();
        waitTime(10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='美股']"))).click();
//        locate("//*[@text='美股']").click();
        locate("action_create_cube").click();
        locate("search_input_text").sendKeys("ali");
        locate("//*[@text='取消']").click();
        System.out.println("用例1：测试用例流程");

    }

    @Test
    public void testWait() throws InterruptedException{
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        locate("//*[@text='自选']").click();
        System.out.println("用例2：隐式等待测试用例");
    }

    @Test
    public void testWait2() {
        for (int i=0;i<5;i++){
            System.out.println(waitTime(7).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='自选']"))).getLocation());
        }
        locate("//*[@text='自选']").click();
        System.out.println("用例3：显式等待测试用例");
    }

    @Test
    // 横竖屏切换
    public void testRotate() throws InterruptedException {
        // 横屏
        driver.rotate(ScreenOrientation.LANDSCAPE);
        Thread.sleep(1000);
        // 竖屏
        driver.rotate(ScreenOrientation.PORTRAIT);
//        locate("//*[@text='自选']").click();
        locate("//*[@text='App']").click();
        // 退回上一步
        driver.navigate().back();
        Thread.sleep(5000);
        // 打开通知栏界面
        driver.openNotifications();
        Thread.sleep(10000);
    }

    @Test
    public void testLogs(){
        // 打印所有los信息
        System.out.println(driver.manage().logs().getAvailableLogTypes());
        for(Object l : driver.manage().logs().get("logcat").getAll().toArray()){
            System.out.println(l);
        }
    }

    @Test
    public void testPerformance() throws Exception {
        System.out.println(driver.getSupportedPerformanceDataTypes());
        System.out.println(driver.getPerformanceData("com.example.android.apis", "memoryinfo", 10));
//        System.out.println(driver.getPerformanceData("com.example.android.apis", "cpuinfo", 10));
        System.out.println(driver.getPerformanceData("com.example.android.apis", "batteryinfo", 10));
        System.out.println(driver.getPerformanceData("com.example.android.apis", "networkinfo", 10));
    }

    @Test
    public void testScreenshot() throws InterruptedException, IOException {

        for (int i=0;i<5;i++){
            swipe(0.8,0.8, 0.4,0.4);
            // 截图代码
            FileUtil.copyFile(
                    driver.getScreenshotAs(OutputType.FILE).getCanonicalFile(),
                    new File(i + ".png")
            );
        }
    }






    // 封装滑动方法
    public void swipe(double startX, double startY, double endX, double endY) throws InterruptedException {
//        double width = driver.manage().window().getSize().width;
//        double height = driver.manage().window().getSize().getHeight();
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


    // 2.28号，变更
    // 封装查找元素方法
    public static WebElement locate(String locator){
        try {
            if (locator.matches("\\/\\/.*")){
                return driver.findElement(By.xpath(locator));
            }else{
                return driver.findElement(By.id(locator));
            }
        }finally {
            //System.out.println(driver.getPageSource());
            for (AndroidElement e : driver.findElementsByXPath("//*")){
                //System.out.println(e.getTagName());
                System.out.println(e.getText());
            }
        }
    }

    // 显式等待封装
    public WebDriverWait waitTime(int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        return wait;
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


    @After
    public void tearDown(){
//        driver.quit();
    }


}
