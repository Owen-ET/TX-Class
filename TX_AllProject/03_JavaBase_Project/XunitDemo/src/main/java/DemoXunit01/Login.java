package DemoXunit01;

public class Login {


    public static boolean isLogin = false;


    public String userLogin(String user,String pwd){


        if (user.equals("") || user == null || pwd.equals("") || pwd == null){
            System.out.println("用户名或密码为空");
            isLogin = false;
            return "用户名密码不能为空！";
        }
        else if(user == "admin" | user.equals("admin") && pwd == "123456" || pwd.equals("123456")){
//        else if(user.equals("admin") || user == "admin" && pwd == "123456" || pwd.equals("123456")){
            System.out.println("管理员登录");
            isLogin = true;
            return "欢迎管理员！";
        }
        else if((user == "admin" | user.equals("admin")) && (pwd != "123456" || !pwd.equals("123456"))){
            System.out.println("管理员登录失败");
            isLogin = false;
            return "管理员密码错误！";
        }else if (user != null | !user.equals("") && (pwd == "123" || pwd.equals("123"))){
            System.out.println("正常用户登录");
            isLogin = true;
            return "欢迎"+user+"！";
        }else {
            System.out.println("用户密码错误");
            isLogin = false;
            return user+"密码错误！";
        }
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.userLogin("zc","123");
        System.out.println(isLogin);
    }


}

