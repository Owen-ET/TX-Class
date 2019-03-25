package com.tester.et.wechat.api.page.contact;

import com.tester.et.wechat.api.driver.AppDriver;
import com.tester.et.wechat.api.page.MainPage;
import com.tester.et.wechat.api.testcase.BaseTestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class ContactManagePageTest extends BaseTestCase {

    @BeforeAll
    static void beforeAllContactManagePageTest() {
        String depName1 = "子部门01";
        String depName2 = "子部门02";
        List<String> name = new ArrayList<>();
        name.add(depName2);
        name.add(depName1);

        try {
            for(String n : name){
                MainPage.getInstance()
                        .gotoContact()
                        .gotoDepartment(n)
                        .gotoManage()
                        .delDepartment();
            }
        }catch (Exception e){
            System.out.println("没有找到部门"+ name +"，可以添加部门！");
//            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        AppDriver.getInstance().appiumDriver.quit();
    }

    @Test
    void addDepartment() {
        String newDepname = "子部门01";
        String po = MainPage.getInstance()
                .gotoContact()
                .gotoManage()
                .addDepartment(newDepname)
                .backContactPage()
                .getdepName(newDepname);

        assertThat(po,equalTo("子部门01"));
    }

    @Test
    void deleteDepartment(){
        // todo:滑动不确定，需要封装
        String depName = "子部门02";
        MainPage.getInstance()
                .gotoContact()
                .gotoManage()
                .addDepartment(depName)
                .backContactPage()
                .gotoDepartment(depName)
                .gotoManage()
                .delDepartment();
    }
}