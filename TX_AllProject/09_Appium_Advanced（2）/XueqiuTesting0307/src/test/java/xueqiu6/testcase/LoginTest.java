package xueqiu6.testcase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import xueqiu6.pages.PageHome;
import xueqiu6.pages.PageLogin;
import xueqiu6.pages.PageProfile;
import xueqiu6.pages.PageSearch;
import xueqiu6.utils.AppDriver;

import java.net.MalformedURLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author zc
 * @date 2019-03-12 10:46
 */

@RunWith(Parameterized.class)
public class LoginTest {

    PageLogin login;

    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {"15600534760","xueqiu12345678"}
//                ,{"seveniruby_2","seveniruby_2"}
        };
    }

    @Parameterized.Parameter
    public String keyword;
    @Parameterized.Parameter(1)
    public String name;

    @BeforeClass
    public static void beforeClass() throws MalformedURLException {
        AppDriver.launchApp();
    }

//    @AfterClass
//    public static void AfterClass(){
//
//        AppDriver.driver.quit();
//    }

//    @After
//    public void after(){
//
//        search.enterHome();
//    }

    @Test
    public void testLogin1(){
        PageHome home = new PageHome();
        login = home.enterProfile().enterLogin();
        String po = login.login("123","123456").getErrorMsg();
        assertThat(po,equalTo("手机号码填写错误！"));
    }

    @Test
    public void testLogin2(){
//        assertThat(
                new PageHome()
                .enterProfile()
                .enterLogin()
                .login(keyword,name);
//                .getErrorMsg()
//                ,equalTo("")
//        );
    }
}