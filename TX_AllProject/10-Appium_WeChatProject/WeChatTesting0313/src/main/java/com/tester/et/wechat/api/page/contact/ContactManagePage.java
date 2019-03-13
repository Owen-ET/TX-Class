package com.tester.et.wechat.api.page.contact;

import com.tester.et.wechat.api.page.BasePage;
import org.openqa.selenium.By;

/**
 * @author zc
 * @date 2019-03-13 15:23
 */

public class ContactManagePage extends BasePage {

//    By 添加成员 = byText("添加成员");
//    By 添加子部门 = byText("添加子部门");
//    By 更多管理 = byText("更多管理");

    // 添加部门
    public ContactManagePage addDepartment(String name){
        click("添加子部门");
        sendKeys(name);
        click("确定");
        return this;
    }

}
