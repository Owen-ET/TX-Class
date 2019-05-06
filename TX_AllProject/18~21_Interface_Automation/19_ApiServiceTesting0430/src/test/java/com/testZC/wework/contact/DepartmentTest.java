package com.testZC.wework.contact;

import com.testZC.wework.Wework;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    Department department;
    // 随机数
    String random = String.valueOf(System.currentTimeMillis());

    @BeforeEach
    void setUp() {
        if (department==null){
            department = new Department();
        }
    }

    @Test
    void list() {

        department.list("")
                .then().statusCode(200)
                .body("department.name[0]",equalTo("喵当家"));

        department.list("")
                .then().statusCode(200)
                .body("department.id[0]",equalTo(1));
    }

    @Test
    void create() {
        department.create("Owen01","18")
                .then().body("errcode",equalTo(0));
        department.create("Owen02","18")
                .then().body("errcode",equalTo(0));;
    }

    @Test
    void update() {
///        department.update("21","Owen2","18","0")
//                .then().log().all().body("errmsg",equalTo("updated"));
        String name = "欧文"+random;
        //去除创建的部门id
        department.create(name,"18");
        Integer intID = department.list("").path("department.find{ it.name=='"+name+"'}.id");
        String id = String.valueOf(intID);
        department.update(id,"欧文0_"+random,"18").then().body("errcode",equalTo(0));
    }

    @Test
    void delete() {
        String name = "Owen3";
        //去除创建的部门id
        department.create(name,"18");
        Integer intID = department.list("").path("department.find{ it.name=='"+name+"'}.id");
        String id = String.valueOf(intID);
        department.update(id,"Owen03","18").then().body("errcode",equalTo(0));
        department.delete(id)
                .then().body("errcode",equalTo(0));
    }

//    @Test
//    void deleteAll(){
//        String name = "欧文1557125986302";
//        Integer intID = department.list("").path("department.find{ it.name=='"+name+"'}.id");
//        String id = String.valueOf(intID);
//        department.delete(id);
//    }

//    @Test
//    void createChiness(){
//        given().log().all()
//                .queryParam("access_token", Wework.getToken())
//                // UTF-8中文
//                .contentType(ContentType.JSON)
//                .body("{\n" +
//                        "   \"name\": \"广州研发中心\",\n" +
//                        "   \"parentid\": 1,\n" +
//                        "}")
//        .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
//        .then().log().all().statusCode(200);
//    }
}