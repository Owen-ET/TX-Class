/**
 * @author zc
 * @date 2019-01-29 14:19
 */

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestDemo {

    @Test
    public void test(){
        int i = 8;
        double d2 = 0.5;
        double d = (double) i;
        System.out.println(d*d2);
    }


}
