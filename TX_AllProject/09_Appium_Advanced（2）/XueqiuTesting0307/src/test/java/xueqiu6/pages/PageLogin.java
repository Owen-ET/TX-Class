package xueqiu6.pages;

import org.openqa.selenium.By;
import xueqiu6.utils.AppDriver;

/**
 * @author zc
 * @date 2019-03-12 16:11
 */

public class PageLogin {
    By others1 = By.id("tv_login_by_phone_or_others");
    By others2 = By.id("tv_login_with_account");

    By loginUser = By.id("login_account");
    By loginPswd = By.id("login_password");
    By loginBtn = By.id("button_next");
    By errorMsg = By.id("md_content");


    public PageLogin login(String username,String password){
        AppDriver.driver.findElement(others1).click();
        AppDriver.driver.findElement(others2).click();
        AppDriver.driver.findElement(loginUser).sendKeys(username);
        AppDriver.driver.findElement(loginPswd).sendKeys(password);
        AppDriver.driver.findElement(loginBtn).click();
        return this;
    }

    public String getErrorMsg(){
        return AppDriver.driver.findElement(errorMsg).getText();
    }
}
