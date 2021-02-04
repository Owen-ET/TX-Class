import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author zc
 * @date 2021-01-21 13:23
 */

public class testNG1 {


    @BeforeMethod
    public void before(){
        System.out.println("开始测试1");
    }

    @Test(enabled = true)
    public void test1(){
        System.out.println("①测试用例1");
    }


    @Test
    public void test2(){
        String[][] obj = new String[2][2];
        System.out.println(obj);
        System.out.println("②测试用例1");
    }

    @AfterMethod
    public void after(){
        System.out.println("结束测试1");
    }
}
