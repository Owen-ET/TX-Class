package com.tester.et.wechat.api.page.user;

import com.tester.et.wechat.api.driver.AppDriver;
import com.tester.et.wechat.api.page.MainPage;
import com.tester.et.wechat.api.testcase.BaseTestCase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class AddUserPageTest extends BaseTestCase {

    @AfterAll
    static void afterAll(){
        AppDriver.getInstance().appiumDriver.quit();
    }

    @Test
    public void addUser(){
        String userName = "demo";
        String phoneNum = "13612345678";

        String po = MainPage.getInstance()
                .gotoContact()
                .gotoUserPage()
                .input(userName,phoneNum)
                .getUserName(userName);
        System.out.println(po);
        assertThat(po,equalTo("demo"));
    }
}