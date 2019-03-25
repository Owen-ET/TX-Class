package com.tester.et.wechat.api.page.contact;

import com.tester.et.wechat.api.driver.AppDriver;
import com.tester.et.wechat.api.page.BasePage;
import org.openqa.selenium.By;

/**
 * @author zc
 * @date 2019-03-25 11:53
 */

public class DepartmentPage extends BasePage {
    By manage = By.id("e9h");

    public ContactManagePage gotoManage(){
        click(manage);
        return new ContactManagePage();
    }
}
