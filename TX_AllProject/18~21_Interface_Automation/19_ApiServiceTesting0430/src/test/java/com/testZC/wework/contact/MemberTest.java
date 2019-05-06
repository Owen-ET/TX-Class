package com.testZC.wework.contact;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    static Member menber;

    @BeforeAll
    static void setUp(){
        if (menber==null){
            menber = new Member();
        }
    }

    @Test
    void create() {
        HashMap<String,Object> map = new HashMap<String,Object>(){{
            put("userid","owen");
            put("name","欧文");
            put("alias","owenET");
            put("mobile","136"+menber.random.substring(0,8));
            put("department", Arrays.asList(18,26));
        }};
        menber.create(map)
                .then().log().all().body("errcode",equalTo(0));
    }
}