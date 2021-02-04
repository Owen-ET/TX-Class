package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author zc
 * @date 2021-01-18 18:03
 */



public class Demo {


    public static void main(String[] args) {

        //  headless模式
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");

        //  获取路径
//        String path = System.getProperty("user.dir");
//        String driverPath = path + "/src/main/java/tools/geckodriver";
//        System.out.println(driverPath);
//        System.setProperty("webdriver.gecko.driver",driverPath);

        //  启动Chrome浏览器
        WebDriver driver = new ChromeDriver();
        driver.get("https://testerhome.com/");
        //  ①隐式等待
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        driver.findElement(By.cssSelector("#kw")).sendKeys("Java-selenium");
//        driver.findElement(By.cssSelector("#su")).click();
//        driver.findElement(By.xpath("//input[@id='kw']")).sendKeys("selenium");
//        driver.findElement(By.xpath("//input[@id='su']")).click();
//        By inputEl = By.cssSelector("#kw");
//        By buttonEl = By.cssSelector("#su");
//        WebElement element1 = driver.findElement(inputEl);
//        WebElement element2 = driver.findElement(buttonEl);
//        element1.sendKeys("selenium");
//        element2.click();
//        System.out.println("打印：启动浏览器");
//        Thread.sleep(5000);
//        System.out.println("停顿了5秒");
//
//        for (int i = 0; i < 5; i++){
//            System.out.println("打印循环5次");
//        }
//        driver.findElement(By.linkText("百度首页")).click();

        //  ④XPATH定位
        driver.findElement(By.xpath("//div[3]/form/input")).sendKeys("111");
        driver.findElement(By.xpath("//*[contains(@class,'form-control')][contains(@type,'text')]")).clear();
        driver.findElement(By.xpath("//input[contains(@placeholder,'搜索') and contains(@class,'form-control')]")).sendKeys("222");
        driver.findElement(By.linkText("登录")).click();
//        Thread.sleep(1000);
        //  ②显式等待③CSS定位
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".new_user>div.form-group>input[type='text']"))).sendKeys("OWEN_ET");
        driver.findElement(By.name("user[password]")).sendKeys("(Dayuzhou66)");
        driver.findElement(By.className("btn-primary")).click();
        //  ④XPATH定位上一级元素
//        String att = driver.findElement(By.xpath("//*[@name='commit']//parent::div")).getAttribute("class");
//        System.out.println(att);



//        driver.quit();
//        String errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".alert-warning")))).getText();
//        Assert.assertEquals(errorMsg,"密码错误多次，你还有最后一次机会，如果还是不对，账号将被锁定一小时。");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#navbar-user-menu"))).click();
        String text = driver.findElements(By.cssSelector("ul.justify-content-end>li.dropdown-avatar>div>a")).get(1).getText();
        System.out.println(text);
        Assert.assertEquals(text,"个人资料设置1","msg:'" + text + "'显示不对");







    }
}