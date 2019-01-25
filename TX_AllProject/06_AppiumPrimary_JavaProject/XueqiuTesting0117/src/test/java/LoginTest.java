import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author zc
 * @date 2019-01-16 15:31
 */

public class LoginTest {
    static MainPage mainPage;
    static ProfilePage profilePage;

    @BeforeAll
    static void beforeAll(){
        mainPage = MainPage.start();
        profilePage = mainPage.gotoProfile();

    }


    // 数据驱动
    @ParameterizedTest
    @CsvSource({
            "1231231, 123456, 手机号码填写错误",
            "13642012345, 543211, 用户名或密码错误"
    })
    void 密码登录(String username,String password, String expection){


        LoginPage loginPage = profilePage.gotoLogin();
        loginPage.passwordFail(username,password);
        String po = loginPage.getMessage();
//        toast = loginPage.password("123","456");
        System.out.println(po);
        assertThat(po,equalTo(expection));
        profilePage = loginPage.gotoProfile();

    }
}
