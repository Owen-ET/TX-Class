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
import org.junit.BeforeClass;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApiDemo {

    private static AndroidDriver<AndroidElement> driver;

    @BeforeClass
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

}
