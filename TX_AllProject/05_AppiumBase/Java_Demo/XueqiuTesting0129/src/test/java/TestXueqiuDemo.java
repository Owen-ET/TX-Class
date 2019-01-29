import io.appium.java_client.AppiumDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author zc
 * @date 2019-01-29 10:57
 */

public class TestXueqiuDemo {
    private AppiumDriver<WebElement> driver;

    @Before
    public void before() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("appPackage","com.xueqiu.android");
        capabilities.setCapability("appActivity",".view.WelcomeActivityAlias");

        // driver实例

        driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


    }

    @Test
    public void demo() throws InterruptedException {
        beforeFun();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        System.out.println("点击自选");
        locate("//*[@text='自选']").click();
        waitTime(10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='美股']"))).click();
//        locate("//*[@text='美股']").click();
        locate("action_create_cube").click();
        locate("search_input_text").sendKeys("ali");
        locate("//*[@text='取消']").click();

    }

    @Test
    public void testWait() throws InterruptedException{
        beforeFun();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        locate("//*[@text='自选']").click();
        System.out.println("动态完了");
    }

    @Test
    public void testWait2(){

    }

    // 封装查找元素方法
    public WebElement locate(String locator){
        if (locator.matches("\\/\\/.*")){
            return driver.findElement(By.xpath(locator));
        }else{
            return driver.findElement(By.id(locator));
        }
    }

    // 显式等待封装
    public WebDriverWait waitTime(int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        return wait;
    }

    // 前置步骤封装
    public void beforeFun(){
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
        driver.quit();
    }


}
