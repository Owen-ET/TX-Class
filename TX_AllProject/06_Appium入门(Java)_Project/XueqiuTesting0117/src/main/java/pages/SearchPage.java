package pages;

import com.sun.tools.javac.util.List;
import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * @author zc
 * @date 2019-01-21 15:06
 */

public class SearchPage extends BasePage{
    // 搜索
    public SearchPage search(String keyword){
        find(By.className("android.widget.EditText")).sendKeys(keyword);
        return this;
    }

    // 取消:返回首页
    public MainPage cancel(){
        find(By.id("action_close")).click();
        return new MainPage();
    }


    public ArrayList<String> getAll(){
        ArrayList<String> array = new ArrayList<String>();
        for(WebElement e : Driver.getCurrentDriver().findElements(By.id("stockName"))){
            array.add(e.getText());

        }

        return array;
    }

    public SearchPage getByStock(){
        return this;
    }

    public ArrayList<String> addSelected(){
        // appiumBUG，本来resourceId和resource-id都支持的
        ArrayList<String> array = new ArrayList<String>();
        AndroidElement select = find(By.xpath("//*[contains(@resource-id, 'follow') and contains(@resource-id, '_btn')]"));
        array.add(select.getAttribute("resourceId"));
        select.click();
        AndroidElement select2 = find(By.xpath("//*[contains(@resource-id, 'follow') and contains(@resource-id, '_btn')]"));
        array.add(select2.getAttribute("resourceId"));
        return array;
    }

    public SearchPage removeSelected(){
        return this;

    }
}
