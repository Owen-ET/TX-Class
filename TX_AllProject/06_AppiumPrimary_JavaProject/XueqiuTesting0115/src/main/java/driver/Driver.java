package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author zc
 * @date 2019-01-16 16:10
 */

public class Driver {
    private static AndroidDriver driver;
    // 创造一个静态方法
    public static void start(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        // 自动加上权限
        desiredCapabilities.setCapability("autoGrantPermissions",true);

        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        // 设置隐式等待
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    // 给出一个driver对象,随时给出来一个driver
    public static AppiumDriver getCurrentDriver(){
        return driver;
    }
}
