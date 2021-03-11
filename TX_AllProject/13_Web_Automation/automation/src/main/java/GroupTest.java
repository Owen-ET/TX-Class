import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

/**
 * @author zc
 * @date 2021-01-20 13:59
 */

public class GroupTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass(){
        System.out.println("===========开始class===========");

    }


    @BeforeMethod
    public void before(){
        System.out.println("===========开始测试===========");


    }


    @BeforeTest
    public void beforeTest(){
        System.out.println("===========beforeTest22===========");
    }

//    @Test(groups = "CS")
    @Test(priority = 1)
    public void test11(){
        System.out.println("===========开始用例CS===========");
        Assert.assertTrue(true);
        Reporter.log("开始用例测试",true);

    }


//    @Test(groups = "BAT")
//    @Test(dependsOnMethods = "test11")
    @Test(priority = 0)
    public void test2(){
        System.out.println("===========开始用例BAT===========");
    }


    @AfterTest
    public void afterTest(){
        System.out.println("===========afterTest22===========");
    }


    @AfterMethod
    public void After(){
        System.out.println("===========结束测试===========");
    }


    @AfterClass
    public void AfterClass() {
        System.out.println("===========结束class===========");
    }

}
