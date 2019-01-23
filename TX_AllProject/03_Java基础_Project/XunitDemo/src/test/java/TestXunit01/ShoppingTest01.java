package TestXunit01;

import DemoXunit01.Login;
import DemoXunit01.Products;
import DemoXunit01.Shopping;
import LoginData01.DataParams;
import LoginData01.DataParams01;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author zc
 * @date 2018-12-29 14:04
 */

public class ShoppingTest01 {

    Shopping shopping = new Shopping();
    Login login = new Login();

    @BeforeMethod
    public void beforeMethod(){
        login.userLogin("zc","123");
    }

//    dependsOnMethods = "TestXunit01.LoginTest.testLogin"
    @Test(dataProvider = "getProPrive",dataProviderClass = DataParams01.class)
    public void testGetPrice01(int proId,int except){
//        int pro = shopping.getPrice(proId);
        Products pro = shopping.getPro(proId);
        String proName = pro.getProName();
        Assert.assertEquals(proName,except);
    }

    @AfterMethod
    public void afterMethod(){
        login.userLogin("","");
    }
}
