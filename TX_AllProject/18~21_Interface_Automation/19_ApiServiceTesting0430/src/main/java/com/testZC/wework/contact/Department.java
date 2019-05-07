package com.testZC.wework.contact;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.testZC.wework.WewordConfig;
import com.testZC.wework.Wework;
import io.restassured.response.Response;


import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * @author zc
 * @date 2019-04-30 16:43
 */

public class Department extends Contact{
    public Response list(String id){
        Response response =
//                given().log().all()   改造删除
//                .queryParam("access_token", Wework.getToken())    改造删除
        requestSpecification    //  改造添加
                .queryParam("id", id)
        .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
        .then()
//                .log().all().statusCode(200)  改造删除
                .extract().response();
        reset();
        return response;
    }

    public Response create(String name,String parentid){

        reset();    // 改造
        String body = JsonPath.parse(this.getClass().getResourceAsStream("/data/create.json"))
                .set("$.name",name)
                .set("$.parentid",parentid).jsonString();
        return requestSpecification //改造
                .body(body)
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then()
//                .log().all().statusCode(200)  改造删除
                .extract().response();
    }

    //  json传递数据进行改造
    public Response createByMap(HashMap<String,Object> map){

        reset();
        // JsonPath地址:https://github.com/json-path/JsonPath
        DocumentContext documentContext = JsonPath.parse(this.getClass().getResourceAsStream("/data/create.json"));
        map.entrySet().forEach(entry->{
            documentContext.set(entry.getKey(),entry.getValue());
        });
        //  改造删除
//        String body = JsonPath.parse(this.getClass().getResourceAsStream("/data/create.json"))
//                .set("$.name",name)
//                .set("$.parentid",parentid).jsonString();
        return requestSpecification //改造
                .body(documentContext.jsonString()) //  改造
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then()
                .extract().response();
    }

    public Response update(String id,String name,String parentid){

        reset();
        String body = JsonPath.parse(this.getClass().getResourceAsStream("/data/update.json"))
                .set("$.id",id)
                .set("$.name",name)
                .set("$.parentid",parentid).jsonString();
//                .set("$.order",order).jsonString();
        return
                requestSpecification
                .queryParam("id",19)
                .body(body)
        .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/update")
        .then()
//                .log().all().statusCode(200)
                .extract().response();
    }

    public Response delete(String id){
        reset();
        return requestSpecification
                .queryParam("id",id)
        .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
        .then()
                .log().all().statusCode(200)
                .extract().response();
    }

    public Response deleteAll(){
        reset();
        List<Integer> list = list("").then().log().all().extract().path("department.id");
        System.out.println(list);
        list.forEach(id->delete(id.toString()));
        return null;
    }
}
