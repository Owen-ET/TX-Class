package com.tester.et.wechat.api.page.user;

import com.tester.et.wechat.api.page.BasePage;
import com.tester.et.wechat.api.page.contact.ContactPage;
import org.openqa.selenium.By;

/**
 * @author zc
 * @date 2019-03-28 15:20
 */

public class AddUserPage extends BasePage {
    By 手动输入添加 = byText("手动输入添加");
    By 姓名 = By.xpath("//*[@class='android.widget.EditText' and @instance=0]");
    By 手机号 = By.xpath("//*[@class='android.widget.EditText' and @instance=1]");
    By 设置部门 = byText("设置部门");
    By 返回 = By.id("e91");

    public ContactPage input(String name,String phoneNum){
        click(this.手动输入添加);
        sendKeys(this.姓名,name);
        sendKeys(this.手机号,phoneNum);
        click(this.设置部门);
        click("确定(1)");
        click("保存");
        click(this.返回);
        return new ContactPage();
    }
}
