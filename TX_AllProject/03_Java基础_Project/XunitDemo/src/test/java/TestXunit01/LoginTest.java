package TestXunit01;

import DemoXunit01.Login;
import LoginData01.LoginParams;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {


    @Test(dataProvider = "getUsers",dataProviderClass = LoginParams.class)
    public void testLogin(String user1,String pwd1,String expect1){
        Login login = new Login();
        String ac = login.userLogin(user1,pwd1);
        Assert.assertEquals(ac,expect1);
    }

}
