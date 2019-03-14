package com.tester.et.wechat.api.page.contact;

import com.tester.et.wechat.api.page.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

/**
 * @author zc
 * @date 2019-03-13 15:19
 */

public class ContactPage extends BasePage {
    By manage = By.id("e0f");


    public ContactManagePage gotoManage(){
        click(manage);
        return new ContactManagePage();
    }

    public String getdepName(String name){
        By depName = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().text(\""+ name +"\").instance(0));");

        return attribute(depName,"text");
    }
}
