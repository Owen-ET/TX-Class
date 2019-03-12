package xueqiu6.testcase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import xueqiu6.pages.PageHome;
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
public class SearchUserNameTest {

    PageSearch search;

    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {"seveniruby","seveniruby"},
                {"seveniruby_2","seveniruby_2"}
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

    @AfterClass
    public static void AfterClass(){
        AppDriver.driver.quit();
    }

    @After
    public void after(){
        search.enterHome();
    }

    @Test
    public void testSearch(){
        PageHome home = new PageHome();
        search = home.enterSearch();
        String po = search.search(keyword).getUserName().get(0);
        assertThat(po,equalTo(name));
    }
}