import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;
import pages.SearchPage;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author zc
 * @date 2019-01-16 15:31
 */

public class SearchTest {
    static MainPage mainPage;
    static SearchPage searchPage;

    @BeforeAll
    static void beforeAll(){
        mainPage = MainPage.start();
        searchPage = mainPage.gotoSearch();

    }

    // 数据驱动
    @ParameterizedTest
    @CsvSource({
            "pdd, 拼多多",
            "alibaba, 阿里巴巴",
            "sogo, 搜狗"
    })
    void 搜索(String keyword, String searchName){


        String content = searchPage.search(keyword).getAll().get(0);
        System.out.println(content);
        assertThat(content,equalTo(searchName));
    }

    @Test
    void 选择(){
        ArrayList<String> array = searchPage.search("mi").addSelected();
        assertThat(array,hasItems("com.xueqiu.android:id/followed_btn", "com.xueqiu.android:id/follow_btn"));

    }
}
