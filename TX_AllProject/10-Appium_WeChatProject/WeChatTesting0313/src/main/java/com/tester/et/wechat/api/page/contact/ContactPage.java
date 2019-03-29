package com.tester.et.wechat.api.page.contact;

import com.tester.et.wechat.api.page.BasePage;
import com.tester.et.wechat.api.page.user.AddUserPage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

/**
 * @author zc
 * @date 2019-03-13 15:19
 */

public class ContactPage extends BasePage {
    By manage = By.id("e9h");


    public ContactManagePage gotoManage(){
        click(manage);
        return new ContactManagePage();
    }

    public String getdepName(String name){
        By depName = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().text(\""+ name +"\").instance(0));");

        return attribute(depName,"text");
    }

    public DepartmentPage gotoDepartment(String DepName){
        By depName = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().text(\""+ DepName +"\").instance(0));");
        click(depName);
        return new DepartmentPage();
    }

    // 跳转到添加成员页面
    public AddUserPage gotoUserPage(){
        gotoDepartment("添加成员");
        return new AddUserPage();
    }

    // 获取成员名称
    public String getUserName(String name){
        By userName = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().text(\""+ name +"\").instance(0));");

        return attribute(userName,"text");
    }
}
