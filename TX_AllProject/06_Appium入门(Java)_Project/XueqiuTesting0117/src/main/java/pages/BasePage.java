package pages;

import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author zc
 * @date 2019-01-17 09:54
 */

public class BasePage {
    static AndroidElement find(By locator){
        try{
            return Driver.getCurrentDriver().findElement(locator);
        }catch(Exception e){
            Driver.getCurrentDriver().findElement(text("下次再说")).click();
            return Driver.getCurrentDriver().findElement(locator);
        }
    }

     // 匹配
    static By locate(String locator){
        if (locator.matches("/.*")){
            return By.xpath(locator);
        }else{
            return By.id(locator);
        }
    }

    // Xpath:text
    static By text(String content){
        return By.xpath("//*[@text='" + content + "']");
    }
}
