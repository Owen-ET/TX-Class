package com.testZC.wework;

import io.restassured.RestAssured;

/**
 * @author zc
 * @date 2019-04-30 15:52
 */

public class Wework {

    private static String token;
    public static String getWeworkToken(){
        return RestAssured.given()
                .queryParam("corpid", WewordConfig.getInstance().corpid)
                .queryParam("corpsecret", WewordConfig.getInstance().secret)
        .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
        .then()
                .log().all()
                .statusCode(200)
                //把token取出来
                .extract().path("access_token");
    }

    // 单例获取token
    public static String getToken(){
        if (token==null){
            token = getWeworkToken();
        }
        return token;
    }
}
