package LoginData01;

import DemoXunit.Products;
import org.testng.annotations.DataProvider;

/**
 * @author zc
 * @date 2018-12-29 14:13
 */

public class DataParams01 {

    @DataProvider
    public Object[][]getProPrive(){
        return new Object[][]{
//                {1,3},
//                {0,-1},
//                {3,80}
                {1,"围巾"}
        };
    }

}
