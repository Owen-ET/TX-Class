package com.tester.et.wechat.api.testcase;

import com.tester.et.wechat.api.driver.AppDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.net.MalformedURLException;

/**
 * @author zc
 * @date 2019-03-14 11:02
 */

public class BaseTestCase {

    @BeforeAll
    public static void beforeAllAppTestCase() throws MalformedURLException {
        AppDriver.getInstance().start();
    }

    @AfterAll
    public static void afterAllAppTestCase(){
//        AppDriver.getInstance().appiumDriver.quit();
    }
}
