package com.tester.et.wechat.api.page.contact;

import com.tester.et.wechat.api.driver.AppDriver;
import com.tester.et.wechat.api.page.MainPage;
import com.tester.et.wechat.api.testcase.BaseTestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class ContactManagePageTest extends BaseTestCase {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
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
}