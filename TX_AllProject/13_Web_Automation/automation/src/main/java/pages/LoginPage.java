package pages;


import org.openqa.selenium.By;
import org.testng.Assert;

import static pages.BasePage.open;
import static pages.BasePage.clear;
import static pages.BasePage.click;
import static pages.BasePage.sendKeys;
import static pages.BasePage.getTexts;
import static pages.BasePage.explicitWait;

/**
 * @author zc
 * @date 2021-01-18 18:03
 */



public class LoginPage {

    private By searchInput1_loc = By.xpath("//div[3]/form/input");
    String input1 = "111";
    private By clearInput_loc = By.xpath("//*[contains(@class,'form-control')][contains(@type,'text')]");
    private By searchInput2_loc = By.xpath("//input[contains(@placeholder,'搜索') and contains(@class,'form-control')]");
    String input2 = "222";
    private By loginButton1_loc = By.linkText("登录");
    private By username_loc = By.cssSelector(".new_user>div.form-group>input[type='text']");
//    String username = "OWEN_ET";
    private By password_loc = By.name("user[password]");
//    String password = "(Dayuzhou66)";
    private By loginButton2_loc = By.className("btn-primary");
    private By userDropDown_loc = By.cssSelector("#navbar-user-menu");
    private By userInfo_loc = By.cssSelector("ul.justify-content-end>li.dropdown-avatar>div>a");
    int num = 1;


    public void loginAction(String username,String password) {


        //  TODO PO模式
        open();
        //  输入搜索框1
        sendKeys(searchInput1_loc,input1);
        //  清空搜索框
        clear(clearInput_loc);
        //  输入搜索框2
        sendKeys(searchInput2_loc,input2);
        //  点击登录按钮1
        click(loginButton1_loc);
        //  显式等待输入用户名
        explicitWait(username_loc).sendKeys(username);
        //  输入密码
        sendKeys(password_loc,password);
        //  点击登录按钮2
        click(loginButton2_loc);

//        return this;

    }


    public void userInfo(String username,String password){

        loginAction(username,password);
        //  显式等待个人信息下拉框
        explicitWait(userDropDown_loc).click();


        //  获取下拉列表信息
//        String text = getTexts(userInfo_loc,num);
//        System.out.println(text);
//        Assert.assertEquals(text,"个人资料设置2","msg:'" + text + "'显示不对");

    }


    public static void main(String[] ags){
        //  调试代码
//        new LoginPage().loginAction();
//        new LoginPage().userInfo("","");
    }
}