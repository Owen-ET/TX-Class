import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

/**
 * @author zc
 * @date 2021-01-20 13:59
 */

public class assertTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass(){
        System.out.println("开始class");

    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("===========beforeTest11===========");
    }


    @BeforeMethod
    public void before(){
        System.out.println("开始测试");
        driver = new ChromeDriver();
        driver.get("https://testerhome.com/");
        wait = new WebDriverWait(driver,10);
        driver.findElement(By.xpath("//div[3]/form/input")).sendKeys("111");
        driver.findElement(By.xpath("//*[contains(@class,'form-control')][contains(@type,'text')]")).clear();
        driver.findElement(By.xpath("//input[contains(@placeholder,'搜索') and contains(@class,'form-control')]")).sendKeys("222");
        driver.findElement(By.linkText("登录")).click();
        Reporter.log("用例前log",true);

    }


    @Test
    public void test1(){
        System.out.println("开始用例1");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".new_user>div.form-group>input[type='text']"))).sendKeys("OWEN_ET");
        driver.findElement(By.name("user[password]")).sendKeys("(Dayuzhou77)");
        driver.findElement(By.className("btn-primary")).click();
        String errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".alert-warning")))).getText();
        Assert.assertEquals(errorMsg,"密码错误多次，你还有最后一次机会，如果还是不对，账号将被锁定一小时。");

    }


    @Test
    public void test2(){
        System.out.println("开始用例2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".new_user>div.form-group>input[type='text']"))).sendKeys("OWEN_ET");
        driver.findElement(By.name("user[password]")).sendKeys("(Dayuzhou66)");
        driver.findElement(By.className("btn-primary")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#navbar-user-menu"))).click();
        String text = driver.findElements(By.cssSelector("ul.justify-content-end>li.dropdown-avatar>div>a")).get(1).getText();
        System.out.println(text);
        Assert.assertEquals(text,"个人资料设置","msg:'" + text + "'显示不对");
    }


    @AfterMethod
    public void After(){
        System.out.println("结束测试");
        driver.quit();
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
