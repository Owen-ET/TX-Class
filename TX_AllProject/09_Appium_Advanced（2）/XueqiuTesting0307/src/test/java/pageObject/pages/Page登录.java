package pageObject.pages;

import org.openqa.selenium.By;
import pageObject.utils.AppDriver;

/**
 * @author zc
 * @date 2019-03-08 14:37
 */

public class Page登录 {

    By 手机及其他登录 = By.id("tv_login_by_phone_or_others");
    By 邮箱手机登录 = By.id("tv_login_with_account");
    By usernameLogin = By.id("login_account");
    By passwordLogin = By.id("login_password");
    By button = By.id("button_next");

    By errorMsg = By.id("md_content");

    public Page登录 userLogin(String username, String password){

        AppDriver.driver.findElement(手机及其他登录).click();
        AppDriver.driver.findElement(邮箱手机登录).click();
        AppDriver.driver.findElement(usernameLogin).sendKeys(username);
        AppDriver.driver.findElement(passwordLogin).sendKeys(password);
        AppDriver.driver.findElement(button).click();
        return this;
    }


    public String getErrorMsg(){
        return AppDriver.driver.findElement(errorMsg).getText();
    }


}
