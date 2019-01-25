import org.junit.Test;
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
    @Test
    public void 密码登录(){
        MainPage mainPage = MainPage.start();
        ProfilePage profilePage = mainPage.gotoProfile();
        LoginPage loginPage = profilePage.gotoLogin();
        loginPage.passwordFail("1231231","123456");
        String po = loginPage.getMessage();
//        toast = loginPage.password("123","456");
        System.out.println(po);
        assertThat(po,equalTo("手机号码填写错误"));
    }
}
