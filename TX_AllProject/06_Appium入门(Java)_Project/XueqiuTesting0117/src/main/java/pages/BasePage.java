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
        //todo:只是Demo，更好的根据弹出框列表进行批量检索
        try{
            return Driver.getCurrentDriver().findElement(locator);
        }catch(Exception e){
            //打印异常log
            e.printStackTrace();
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
