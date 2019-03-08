package pageObject.pages;

import org.openqa.selenium.By;
import pageObject.utils.AppDriver;

/**
 * @author zc
 * @date 2019-03-08 14:32
 */

public class Page我的 {

    By 点击登录 = By.xpath("//*[@text='点击登录' and @resource-id='com.xueqiu.android:id/tv_login']");

    public Page登录 enter登录(){
        AppDriver.driver.findElement(点击登录).click();
        return new Page登录();
    }

}
