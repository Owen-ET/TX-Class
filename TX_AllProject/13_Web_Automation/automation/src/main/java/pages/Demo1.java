package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author zc
 * @date 2021-01-19 16:42
 */

public class Demo1 {

    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();
        driver.get("https://testerhome.com/");
        driver.findElement(By.cssSelector("#navbar-user-menu"));
        String text = driver.findElements(By.cssSelector("ul.justify-content-end>li.dropdown-avatar>div>a")).get(1).getText();
        System.out.println(text);

    }
}
