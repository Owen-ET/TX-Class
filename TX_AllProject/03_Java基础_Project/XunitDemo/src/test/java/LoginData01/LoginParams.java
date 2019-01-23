package LoginData01;

import org.testng.annotations.DataProvider;

public class LoginParams {
    /**
     * 提供用户登录测试方法数据
     * @return
     */
    @DataProvider
    public Object [][] getUsers(){
        return new Object[][]{
                {"zc","123","欢迎zc！"},
                {"","","用户名密码不能为空！"},
                {"admin","123456","欢迎管理员！"}
        };
    }
}
