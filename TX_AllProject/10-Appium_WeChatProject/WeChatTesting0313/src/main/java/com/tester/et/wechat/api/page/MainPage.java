package com.tester.et.wechat.api.page;

import com.tester.et.wechat.api.page.contact.ContactPage;
import org.openqa.selenium.By;

/**
 * @author zc
 * @date 2019-03-13 15:24
 */

public class MainPage extends BasePage{

    By contact = byText("通讯录");

    public ContactPage gotoContact(){
        click("通讯录");
        return new ContactPage();
    }

    static MainPage mainpage;
    public static MainPage getInstance(){
        if (mainpage==null){
            mainpage= new MainPage();
        }
        return mainpage;
    }
}
