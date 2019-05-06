package com.testZC.wework.contact;

import io.restassured.response.Response;

import java.util.HashMap;

/**
 * @author zc
 * @date 2019-05-06 16:34
 */

public class Member extends Contact{
    public Response create(HashMap<String,Object> map){
        reset();
        return requestSpecification
                .body(template("/data/cre_member.json",map))
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/user/create")
                .then().log().all().extract().response();
    }
}
