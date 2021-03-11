import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author zc
 * @date 2021-01-21 13:23
 */

public class testNG2 {


    @BeforeMethod
    public void before(){
        System.out.println("开始测试2");
    }

    @Test
    public void test(){
        System.out.println("测试用例2");
    }

    @AfterMethod
    public void after(){
        System.out.println("结束测试2");
    }
}
