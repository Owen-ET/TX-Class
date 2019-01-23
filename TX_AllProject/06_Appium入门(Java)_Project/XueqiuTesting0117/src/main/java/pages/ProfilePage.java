package pages;

import driver.Driver;
import org.openqa.selenium.By;

/**
 * @author zc
 * @date 2019-01-16 16:29
 */

public class ProfilePage {
    // 点击登录按钮
    By login = By.id("tv_login");
    public LoginPage gotoLogin(){
        Driver.getCurrentDriver().findElement(login).click();
        return new LoginPage();
    }
}
