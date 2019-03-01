package pageObject.testcase;

import org.junit.Before;
import org.junit.Test;
import pageObject.pages.Page搜索;
import pageObject.pages.Page雪球首页;
import pageObject.utils.AppDriver;

import java.net.MalformedURLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


/**
 * @author zc
 * @date 2019-03-01 14:59
 */

public class 搜索Test {

    @Before
    public void before() throws MalformedURLException {
        AppDriver.launchApp();
    }

    @Test
    public void search(){
        Page雪球首页 首页 = new Page雪球首页();
        Page搜索 搜索 = 首页.enterSearch();
        搜索.search("pdd");
        String po = 搜索.getStock();
        assertThat(po,equalTo("拼多多"));
    }

    @Test
    public void search2(){
        assertThat(
                new Page雪球首页().enterSearch().search("xyyh").getStock(),
                equalTo("兴业银行")
        );
    }
}
