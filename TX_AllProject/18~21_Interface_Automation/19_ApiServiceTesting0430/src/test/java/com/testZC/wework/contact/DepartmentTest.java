package com.testZC.wework.contact;

import com.testZC.wework.Wework;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import java.util.HashMap;

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
//            department.deleteAll();
        }
    }

    @Test
    void list() {

        department.list("")
                .then().statusCode(200);
//                .body("department.name",equalTo("喵当家"));

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
//        department.update("21","Owen2","18","0")
//                .then().log().all().body("errmsg",equalTo("updated"));
        String name = "欧文"+random;
        //去除创建的部门id
        department.create(name,"18");
        Integer intID = department.list("").path("department.find{ it.name=='"+name+"'}.id");
        String id = String.valueOf(intID);
        department.update(id,"欧文1_"+random,"18").then().body("errcode",equalTo(0));
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

    //  json传递数据进行改造
    @Test
    void createByMap() {
        HashMap<String ,Object> map = new HashMap<String,Object>(){{
            put("name","Owen00");
            put("parentid","18");
        }};
        department.createByMap(map).then().log().all().body("errcode",equalTo(0));
    }

    //  数据驱动结合断言
    @ParameterizedTest
    @CsvFileSource(resources = "/data/csvAndDup.csv")
    void csvAndDup(String name,String parentid,Integer code){
        department.create(name+random,parentid).then().log().all().body("errcode",equalTo(0));
        department.create(name+random,parentid).then().log().all().body("errcode",equalTo(code));
    }

//    @Test
//    void deleteOne(){
//        String name = "Owen00";
//        Integer intID = department.list("").path("department.find{ it.name=='"+name+"'}.id");
//        String id = String.valueOf(intID);
//        department.delete(id);
//    }
//
//    @Test
//    void deleteAll() {
//        department.deleteAll();
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