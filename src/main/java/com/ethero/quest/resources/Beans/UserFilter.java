package com.ethero.quest.resources.Beans;

import javax.ws.rs.QueryParam;

public class UserFilter {
    private @QueryParam("age") int age;

    private @QueryParam("name") String name;
    private @QueryParam("gender") String gender;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
