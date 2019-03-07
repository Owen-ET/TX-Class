package pageObject.pages;

import org.openqa.selenium.By;
import pageObject.utils.AppDriver;

/**
 * @author zc
 * @date 2019-03-01 13:51
 */

public class Page搜索 {

    By input = By.id("search_input_text");
    By stockName = By.id("stockName");

    public Page搜索 search(String keyword){
        AppDriver.driver.findElement(input).sendKeys(keyword);
        return this;
    }

    public String getStock(){

        return AppDriver.driver.findElement(stockName).getText();
    }
}
