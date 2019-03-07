package pageObject.testcase;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import pageObject.pages.Page自选;
import pageObject.pages.Page雪球首页;
import pageObject.utils.AppDriver;
import tags.冒烟测试;
import tags.行情;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

/**
 * @author zc
 * @date 2019-03-06 17:38
 */

public class 自选Test {

    @Before
    public void before() throws MalformedURLException {
        new AppDriver().launchApp();
    }

//    @Category({冒烟测试.class, 行情.class})
    @Test
    public void 美股(){
        Page雪球首页 首页 = new Page雪球首页();
        Page自选 自选 = 首页.enter自选();
        Page自选 美股 = 自选.enter美股股票();
        int list = 美股.getstockList().size();
        // 判断list是否大于0
        assertThat(list,greaterThan(0));
    }
}
