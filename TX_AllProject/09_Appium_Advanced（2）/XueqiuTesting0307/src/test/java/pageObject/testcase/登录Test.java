package pageObject.testcase;

import org.junit.Before;
import org.junit.Test;
import pageObject.pages.Page我的;
import pageObject.pages.Page登录;
import pageObject.pages.Page雪球首页;
import pageObject.utils.AppDriver;

import java.net.MalformedURLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author zc
 * @date 2019-03-08 14:56
 */

public class 登录Test {

    @Before
    public void before() throws MalformedURLException {

        new AppDriver().launchApp();
    }

    @Test
    public void testErrorMsg(){
        assertThat(
                new Page雪球首页()
                        .enter我的()
                        .enter登录()
                        .userLogin("123","123456")
                        .getErrorMsg()
                , equalTo("手机号码填写错误")
        );
    }
}
