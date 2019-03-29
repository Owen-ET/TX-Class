package com.tester.et.wechat.api.page.contact;

import com.tester.et.wechat.api.driver.AppDriver;
import com.tester.et.wechat.api.page.BasePage;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author zc
 * @date 2019-03-13 15:23
 */

public class ContactManageAppiumPage extends BasePage {

//    By 添加成员 = byText("添加成员");
//    By 添加子部门 = byText("添加子部门");
//    By 更多管理 = byText("更多管理");

    @FindBy(xpath = "xxxxxx")
    @AndroidBy(xpath = "")
    @iOSFindBy(xpath = "")

    By cancel = By.id("e9k");

    ContactManageAppiumPage(){
        PageFactory.initElements(
                new AppiumFieldDecorator(AppDriver.getInstance().appiumDriver, Duration.ofSeconds(20)),
                this
        );
    }

    // 添加部门
    public ContactManageAppiumPage addDepartment(String name){
        click("添加子部门");
        sendKeys(byText("请输入部门名称"),name);
        click("确定");
        return this;
    }

    public ContactPage backContactPage(){
        click(cancel);
        return new ContactPage();
    }

}
