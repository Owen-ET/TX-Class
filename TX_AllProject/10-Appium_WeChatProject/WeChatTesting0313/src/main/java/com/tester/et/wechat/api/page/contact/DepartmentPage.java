package com.tester.et.wechat.api.page.contact;

import com.tester.et.wechat.api.driver.AppDriver;
import com.tester.et.wechat.api.page.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc
 * @date 2019-03-25 11:53
 */

public class DepartmentPage extends BasePage {
    By manage = By.id("e9h");

    public ContactManagePage gotoManage(){
        click(manage);
        return new ContactManagePage();
    }

    // 父部门进入子部门
    public DepartmentPage gotoChildrenDepartment(String DepName){
        By depName = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().text(\""+ DepName +"\").instance(0));");
        click(depName);
        return new DepartmentPage();
    }

    // 获取子部门
    public List<String> getChildrenDepartmentNames(){
        List<String> array = new ArrayList();
        for (WebElement elements : findElements (By.xpath("//*[contains(@resource-id,'com.tencent.wework:id/alt')]/android.widget.TextView"))){
            array.add(elements.getText());
        }
        System.out.println(array);
        return array;
    }

    // 删除所有部门
    public DepartmentPage deleteAll(){
        while(findElements(byText("部门无成员")).size()==0){
            String sub = getChildrenDepartmentNames().get(0);
            gotoChildrenDepartment(sub).gotoManage().delDepartment().back();
        }
        return this;
    }
}
