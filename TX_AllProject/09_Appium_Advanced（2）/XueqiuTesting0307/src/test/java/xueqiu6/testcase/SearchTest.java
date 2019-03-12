package xueqiu6.testcase;

import org.junit.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import xueqiu6.pages.PageHome;
import xueqiu6.pages.PageSearch;
import xueqiu6.utils.AppDriver;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author zc
 * @date 2019-03-12 10:46
 */

@RunWith(Parameterized.class)
public class SearchTest {

    PageSearch search;

    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {"pdd","拼多多"},
                {"ali","阿里巴巴"},
                {"xiaom","小米"}
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
        String po = search.search(keyword).getStockList().get(0);
        assertThat(po,equalTo(name));
    }
}