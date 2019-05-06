package com.testZC.wework;


import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * @author zc
 * @date 2019-05-06 11:21
 */

public class Restful {
    HashMap<String,Object> query = new HashMap<String, Object>();
    public RequestSpecification requestSpecification=given();
    public Response send(){
        requestSpecification=given().log().all();
        query.entrySet().forEach(entry->{
            requestSpecification.queryParam(entry.getKey(),entry.getValue());
        });
        return requestSpecification.when().request("get","baidu.com");
    }

    //  json模板技术方法
    public static String template(String path,HashMap<String,Object> map){
        DocumentContext documentContext = JsonPath.parse(Restful.class
                .getResourceAsStream(path));
        map.entrySet().forEach(entry->{
            documentContext.set(entry.getKey(),entry.getValue());
        });
        return documentContext.jsonString();
    }
}
