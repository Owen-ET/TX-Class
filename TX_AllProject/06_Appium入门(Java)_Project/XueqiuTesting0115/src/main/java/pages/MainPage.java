package pages;
/**
 * @author zc
 * @date 2019-01-16 15:54
 */

import driver.Driver;
import org.openqa.selenium.By;

public class MainPage {
    // 创建一个定位符
    By profile = By.id("user_profile_icon");


    public static MainPage start(){
        Driver.start();
        // 进入主界面
        return new MainPage();
    }

    public ProfilePage gotoProfile(){
        // 点击头像元素
        Driver.getCurrentDriver().findElement(profile).click();
        // 进入新的界面
        return new ProfilePage();
    }
}
