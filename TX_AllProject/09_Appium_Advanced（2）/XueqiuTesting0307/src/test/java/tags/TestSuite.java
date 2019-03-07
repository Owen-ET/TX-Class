package tags;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pageObject.testcase.搜索Test;
import pageObject.testcase.自选Test;

/**
 * @author zc
 * @date 2019-03-07 16:49
 */

@RunWith(Categories.class)

// 只跑冒烟case
@Categories.IncludeCategory(冒烟测试.class)

@Suite.SuiteClasses({
        搜索Test.class,
        自选Test.class
})
public class TestSuite {

}
