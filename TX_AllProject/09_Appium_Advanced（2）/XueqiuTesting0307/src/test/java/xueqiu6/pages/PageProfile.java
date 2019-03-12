package xueqiu6.pages;

import org.openqa.selenium.By;
import xueqiu6.utils.AppDriver;

/**
 * @author zc
 * @date 2019-03-12 16:08
 */

public class PageProfile {
    By login = By.id("tv_login");

    public PageLogin enterLogin(){
        AppDriver.driver.findElement(login).click();
        return new PageLogin();
    }
}
