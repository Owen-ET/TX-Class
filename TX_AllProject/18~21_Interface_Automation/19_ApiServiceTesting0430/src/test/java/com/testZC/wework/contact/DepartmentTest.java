package com.testZC.wework.contact;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    Department department;

    @BeforeEach
    void setUp() {
        if (department==null){
            department = new Department();
        }
    }

    @Test
    void list() {

        department.list("")
                .then().statusCode(200)
                .body("department.name[0]",equalTo("喵当家"));

        department.list("")
                .then().statusCode(200)
                .body("department.id[0]",equalTo(1));
    }

    @Test
    void create() {
        department.create("Owen02","18")
                .then().body("errcode",equalTo(60008));
        department.create("Owen03","18")
                .then().body("errcode",equalTo(60008));;
    }

    @Test
    void update() {
//        department.update("21","Owen2","18","0")
//                .then().log().all().body("errmsg",equalTo("updated"));
        String name = "Owen3";
        //去除创建的部门id
        department.create(name,"18");
        String id = String.valueOf(department.list("").path("department.find{ it.name=='"+name+"'}.id"));
        department.update(id,"Owen03","18").then().body("errcode",equalTo(0));
    }

    @Test
    void delete() {
        department.delete("22")
                .then().body("errcode",equalTo(60123));
    }
}