package test_case;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import pages.LoginPage;
import static pages.BasePage.explicitWait;
import static pages.BasePage.getTexts;
import static pages.BasePage.quit;

/**
 * @author zc
 * @date 2021-01-20 13:59
 */

public class LoginPO {

    int num = 1;
    LoginPage loginPage;
    private By errorMsg_loc = By.cssSelector(".alert-warning");
    private By userInfo_loc = By.cssSelector("ul.justify-content-end>li.dropdown-avatar>div>a");


    @BeforeClass
    public void beforeClass(){
        System.out.println("开始class");
        loginPage = new LoginPage();

    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("===========beforeTest11===========");
    }


    @BeforeMethod
    public void before(){
        System.out.println("开始测试");
        Reporter.log("用例前log",true);

    }


    @Test
    public void test1(){
        System.out.println("开始用例1");
        loginPage.loginAction("OWEN_ET","(Dayuzhou77)");
        String errorMsg = explicitWait(errorMsg_loc).getText();
        Assert.assertEquals(errorMsg,"密码错误多次，你还有最后一次机会，如果还是不对，账号将被锁定一小时。");

    }


    @Test
    public void test2(){
        System.out.println("开始用例2");
        loginPage.userInfo("OWEN_ET","(Dayuzhou66)");
        String text = getTexts(userInfo_loc,num);
        System.out.println(text);
        Assert.assertEquals(text,"个人资料设置","msg:'" + text + "'显示不对");
    }


    @AfterMethod
    public void After(){
        System.out.println("结束测试");
        quit();
    }


    @AfterClass
    public void AfterClass() throws InterruptedException {
        System.out.println("结束class");
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println((i + 1) + "秒");
        }
    }

    @AfterTest
    public void afterTest(){
        System.out.println("===========afterTest11===========");
    }

}
