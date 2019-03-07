package pageObject.pages;

import org.openqa.selenium.By;
import pageObject.utils.AppDriver;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zc
 * @date 2019-03-01 13:57
 */

public class Page自选 {

    By stock = By.xpath("//android.widget.TextView[@resource-id='com.xueqiu.android:id/page_type_stock' and @text='股票']");
    By 美股 = By.xpath("//android.widget.TextView[@text='美股']");
    By stockList = By.id("portfolio_stockName");

    public Page自选 enter美股股票(){
        AppDriver.driver.findElement(stock).click();
        AppDriver.driver.findElement(美股).click();
        return this;
    }


    public List<String> getstockList(){
        return AppDriver.driver.findElements(stockList)
                .stream()
                .map(e->e.getText())
                .collect(Collectors.toList());
    }
}
