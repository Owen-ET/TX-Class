package TestXunit01;

import DemoXunit01.Login;
import DemoXunit01.Shopping;
import LoginData01.DataParams;
import LoginData01.LoginParams;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @author zc
 * @date 2018-12-29 10:51
 */

public class ShoppingTest {

    Shopping shopping = new Shopping();
    Login login = new Login();

//    @BeforeClass
//    public void beforeMethod(){
//        login.userLogin("zc","123");
//    }

    @Test(dataProvider = "getProPrice",dataProviderClass = DataParams.class,dependsOnMethods = "LoginTest.testLogin")
    public void testGetPrice(int proId,int expect){
        int price =  shopping.getPrice(proId);
        Assert.assertEquals(price,expect);
    }

//    @AfterClass
//    public void afterMethod(){
//        login.userLogin("","");
//    }

}
