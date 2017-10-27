package com.dalu.ims.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "user")
public class User implements Serializable{

    private static final long serialVersionUID = 5175214997025819894L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private String sex;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
