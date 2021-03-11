import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @author zc
 * @date 2021-01-20 13:59
 */

public class assertTest1 {

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

    @Test
    public void test1(){
        System.out.println("===========开始用例1===========");


    }


    @Test
    public void test2(){
        System.out.println("===========开始用例2===========");
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
