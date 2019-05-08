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
    // 随机数
    String random = String.valueOf(System.currentTimeMillis());
    public Contact(){
        reset();
    }


    public void reset(){
        requestSpecification=given().log().all().queryParam("access_token", Wework.getToken())
                .contentType(ContentType.JSON);
//                .expect().log().all().statusCode(200);
        //  加解密
        requestSpecification.filter((req,res,ctx)->{
            //todo:对请求响应做封装
            req.queryParam("");
            return ctx.next(req,res);
        });
    }

    public String newRandom(int x){
        return random.substring(random.length()-x);
    }
}
