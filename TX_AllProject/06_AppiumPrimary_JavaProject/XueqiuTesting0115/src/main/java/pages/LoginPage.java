package pages;

import org.openqa.selenium.By;

import static pages.BasePage.find;
import static pages.BasePage.text;

/**
 * @author zc
 * @date 2019-01-17 09:16
 */

public class LoginPage {
    private By other = text("手机及其他登录");
    private By pwdLogin = text("邮箱手机号密码登录");
    private By username = By.id("login_account");
    private By password = By.xpath("//*[@password='true']");
    private By button = By.id("button_next");
    By msg = By.id("md_content");
    By sure = By.id("md_buttonDefaultPositive");
    By back = By.id("iv_action_back");

    String message;

    // 登录失败方法返回当前页面
    public LoginPage passwordFail(String username,String password){
        find(other).click();
        find(pwdLogin).click();
        find(this.username).sendKeys(username);
        find(this.password).sendKeys(password);
        find(button).click();
        // 校验信息
        message = find(msg).getText();
        find(sure).click();
        // 返回初始界面

        return this;
    }

    public String getMessage(){
        return message;
    }


    // 新建返回初始页面的方法
    public ProfilePage gotoProfile() {
        find(back).click();
        return new ProfilePage();
    }
}
