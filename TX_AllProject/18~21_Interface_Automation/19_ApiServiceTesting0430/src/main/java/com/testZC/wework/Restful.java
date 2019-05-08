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

    //  har模板引擎封装方法
    public Response templateFromHar(String path,String pattern,HashMap<String,Object>map){
        //todo:支持从har自动生成接口定义并发送
        //  从har中读取请求，进行更新
        DocumentContext documentContext = JsonPath.parse(Restful.class
                .getResourceAsStream(path));
        map.entrySet().forEach(entry->{
            documentContext.set(entry.getKey(),entry.getValue());
        });

        String  methed = documentContext.read("method");
        String  url = documentContext.read("url");
        return requestSpecification.when().request(methed,url);
    }

    //  swagger模板引擎封装方法
    public Response templateFromSwagger(String path,String pattern,HashMap<String,Object>map){
        //todo:支持从swagger自动生成接口定义并发送
        //  从swagger中读取请求，进行更新
        DocumentContext documentContext = JsonPath.parse(Restful.class
                .getResourceAsStream(path));
        map.entrySet().forEach(entry->{
            documentContext.set(entry.getKey(),entry.getValue());
        });

        String  methed = documentContext.read("method");
        String  url = documentContext.read("url");

        return requestSpecification.when().request(methed,url);
    }

    //  yaml模板引擎封装方法
    public Response templateFromYaml(HashMap<String,Object>map){
        //todo:根据yaml自动生成接口定义并发送
        return null;
    }

    //todo:支持wsdl soap

    public Response api(String path,HashMap<String,Object>map){
        //todo:动态调用
        return null;
    }
}
