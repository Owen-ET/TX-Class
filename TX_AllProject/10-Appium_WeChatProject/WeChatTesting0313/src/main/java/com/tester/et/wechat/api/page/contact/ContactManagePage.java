package com.tester.et.wechat.api.page.contact;

import com.tester.et.wechat.api.page.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

/**
 * @author zc
 * @date 2019-03-13 15:23
 */

public class ContactManagePage extends BasePage {

//    By 添加成员 = byText("添加成员");
//    By 添加子部门 = byText("添加子部门");
//    By 更多管理 = byText("更多管理");
    By cancel = By.id("e9k");


    // 添加部门
    public ContactManagePage addDepartment(String name){
        click("添加子部门");
        sendKeys(byText("请输入部门名称"),name);
        click("确定");
        return this;
    }

    public ContactPage backContactPage(){
        click(cancel);
        return new ContactPage();
    }

    // 更多管理
    public ContactManagePage delDepartment(){
        click("更多管理");
        click("删除部门");
        click("确定");
        return this;
    }

    public String getDepName(String name){
        By depName = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().text(\""+ name +"\").instance(0));");

        return attribute(depName,"text");
    }

}
