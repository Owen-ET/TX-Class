package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author zc
 * @date 2019-01-16 16:10
 */

public class Driver {
    private static AndroidDriver<AndroidElement> driver;
    // 创造一个静态方法
    public static void start(){

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        GlobalConfig config = GlobalConfig.load("/data/globalConfig.yaml");
        config.appium.capabilities.keySet().forEach(key->{
            Object value = config.appium.capabilities.get(key);
            desiredCapabilities.setCapability(key,value);
        });
        // todo:下面可以不要了
//        desiredCapabilities.setCapability("platformName", "android");
//        desiredCapabilities.setCapability("deviceName", "emulator-5554");
//        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
//        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
//        // 自动加上权限
//        desiredCapabilities.setCapability("autoGrantPermissions",true);

        URL remoteUrl = null;
        try {
            remoteUrl = new URL(config.appium.url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        // 设置隐式等待
        driver.manage().timeouts().implicitlyWait(config.appium.wait, TimeUnit.SECONDS);
    }

    // 给出一个driver对象,随时给出来一个driver
    public static AndroidDriver<AndroidElement> getCurrentDriver(){

        return driver;
    }
}
