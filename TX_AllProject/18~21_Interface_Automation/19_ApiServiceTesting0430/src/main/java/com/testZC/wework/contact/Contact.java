package com.testZC.wework.contact;

import com.testZC.wework.Restful;
import com.testZC.wework.Wework;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

/**
 * @author zc
 * @date 2019-05-06 13:22
 */

public class Contact extends Restful {
    public Contact(){
        reset();
    }


    public void reset(){
        requestSpecification=given().log().all().queryParam("access_token", Wework.getToken())
                .contentType(ContentType.JSON);
///                .expect().log().all().statusCode(200);
    }
}
