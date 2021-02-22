package selenium_API;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author zc
 * @date 2021-02-10 11:52
 */

public class Switch {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.out.println("start");
        driver = new ChromeDriver();
    }

//    @Test
    public void test1(){
        driver.get("https://www.cnblogs.com/Owen-ET/p/9636215.html");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("mac 安装MySQL")).click();
        String handel1 = driver.getWindowHandle();
        for (String handel: driver.getWindowHandles()){
            if (handel.equals(handel1)){
                driver.switchTo().window(handel);
                break;
            }
            System.out.println(handel);
        }
    }

    @Test
    public void test2(){
        driver.get("");
    }

    @AfterMethod
    public void afterTest(){
        System.out.println("stop");
    }

}
