package com.testZC.wework;

import io.restassured.RestAssured;

/**
 * @author zc
 * @date 2019-04-30 15:52
 */

public class Wework {

    private static String token;
    public static String getWeworkToken(String secret){
        return RestAssured.given()
                .queryParam("corpid", WewordConfig.getInstance().corpid)
                .queryParam("corpsecret", secret)
        .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
        .then()
                .log().all()
                .statusCode(200)
                //把token取出来
                .extract().path("access_token");
    }

//    public static String getWeworkTokenForContact(){
//
//    }

    // 单例获取token
    public static String getToken(){
        //todo:两种token
        if (token==null){
            token = getWeworkToken(WewordConfig.getInstance().通讯录Secret);
        }
        return token;
    }
}
