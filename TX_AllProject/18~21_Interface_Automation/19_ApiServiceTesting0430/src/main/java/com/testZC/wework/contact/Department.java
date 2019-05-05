package com.testZC.wework.contact;

import com.jayway.jsonpath.JsonPath;
import com.testZC.wework.WewordConfig;
import com.testZC.wework.Wework;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

/**
 * @author zc
 * @date 2019-04-30 16:43
 */

public class Department {
    public Response list(String id){
        return given().log().all()
                .queryParam("access_token", Wework.getToken())
                .queryParam("id", id)
        .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
        .then()
                .log().all()
                .statusCode(200).extract().response();
    }

    public Response create(String name,String parentid){

        String body = JsonPath.parse(this.getClass().getResourceAsStream("/data/create.json"))
                .set("$.name",name)
                .set("$.parentid",parentid).jsonString();
        return given().log().all().queryParam("access_token",Wework.getToken())
                .body(body)
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().all().statusCode(200).extract().response();
    }

    public Response update(String id,String name,String parentid){
        String body = JsonPath.parse(this.getClass().getResourceAsStream("/data/update.json"))
                .set("$.id",id)
                .set("$.name",name)
                .set("$.parentid",parentid).jsonString();
//                .set("$.order",order).jsonString();
        return
        given().log().all()
                .queryParam("access_token",Wework.getToken())
                .queryParam("id",19)
                .body(body)
        .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/update")
        .then()
                .log().all().statusCode(200).extract().response();
    }

    public Response delete(String id){
        return given().log().all()
                .queryParam("access_token",Wework.getToken())
                .queryParam("id",id)
        .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
        .then()
                .log().all().statusCode(200)
                .extract().response();
    }
}
