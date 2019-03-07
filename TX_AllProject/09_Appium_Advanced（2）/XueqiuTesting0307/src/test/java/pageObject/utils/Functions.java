package pageObject.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author zc
 * @date 2019-03-07 10:54
 */

public class Functions {

    public static void xwait(String text){
        for (int i=0;i<5;i++){
            System.out.println(waitTime(7).until(ExpectedConditions.elementToBeClickable(By.xpath(text))).getLocation());
        }
    }

    // 显式等待封装
    public static WebDriverWait waitTime(int time){
        WebDriverWait wait = new WebDriverWait(AppDriver.driver,time);
        return wait;
    }
}
