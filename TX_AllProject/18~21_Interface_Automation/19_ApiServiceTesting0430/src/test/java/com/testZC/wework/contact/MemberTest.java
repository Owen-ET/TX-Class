package com.testZC.wework.contact;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import static org.hamcrest.Matchers.equalTo;

class MemberTest {

    static Member menber;

    @BeforeAll
    static void setUp(){
        if (menber==null){
            menber = new Member();
        }
    }

    //  数据驱动文档地址：https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests
    //  数据驱动改造
    @ParameterizedTest
    @ValueSource(strings = {"ceshi1","ceshi2"})
    void create(final String name) {
        String random = String.valueOf(System.currentTimeMillis()).substring(5,13);
        HashMap<String,Object> map = new HashMap<String,Object>(){{
            put("userid", name+menber.newRandom(2));
            put("name",name+menber.newRandom(3));
            put("mobile","136"+random);
            put("department", Arrays.asList(18,26));
            put("email","");
        }};
        menber.create(map)
                .then().log().all().body("errcode",equalTo(0));
    }

    @Test
    public void test() throws InterruptedException {
        String random1 = String.valueOf(System.currentTimeMillis());
        System.out.println("的旧:"+random1);
        Thread.sleep(1);
        String random2 = String.valueOf(System.currentTimeMillis());
        System.out.println("新的:"+random2);
    }
}