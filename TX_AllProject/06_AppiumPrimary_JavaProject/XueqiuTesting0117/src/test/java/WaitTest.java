import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author zc
 * @date 2019-02-28 13:27
 */

public class WaitTest {

    @Test
    public void waitTest(){
        RemoteWebDriver driver = null;
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));
    }
}
