package com.testZC.wework.contact;

import com.testZC.wework.Wework;

import static io.restassured.RestAssured.given;

/**
 * @author zc
 * @date 2019-04-30 16:43
 */

public class Department {
    public void list(){
        given().queryParam("access_token", Wework.getToken());
    }
}
