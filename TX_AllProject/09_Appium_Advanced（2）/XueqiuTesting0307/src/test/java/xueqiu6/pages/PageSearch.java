package xueqiu6.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import xueqiu6.utils.AppDriver;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zc
 * @date 2019-03-12 10:19
 */

public class PageSearch {

    By searchInput = By.id("search_input_text");
    By stockName = By.id("stockName");
    By cancel = By.id("action_close");
    By userName = By.id("user_name");

    public PageSearch search(String text){
        AppDriver.driver.findElement(searchInput).sendKeys(text);
        return this;
    }

    public List<String> getStockList(){
        return AppDriver.driver.findElements(stockName)
                .stream()
                .map(e->e.getText())
                .collect(Collectors.toList());
    }

    public PageHome enterHome(){
        AppDriver.driver.findElement(cancel).click();
        return new PageHome();
    }


    public List<String> getUserName(){
        return AppDriver.driver.findElements(userName)
                .stream()
                .map(e->e.getText())
                .collect(Collectors.toList());
    }

}
