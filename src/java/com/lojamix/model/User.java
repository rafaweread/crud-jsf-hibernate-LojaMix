package com.lojamix.model;
// Generated 07/03/2018 21:04:08 by Hibernate Tools 4.3.1


import java.util.Date;

public class User  implements java.io.Serializable {


     private Integer id;
     private String recordNo;
     private String name;
     private Integer age;
     private String sex;
     private Date dob;
     private String remark;

    public User() {
    }

    public User(String recordNo, String name, Integer age, String sex, Date dob, String remark) {
       this.recordNo = recordNo;
       this.name = name;
       this.age = age;
       this.sex = sex;
       this.dob = dob;
       this.remark = remark;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getRecordNo() {
        return this.recordNo;
    }
    
    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Date getDob() {
        return this.dob;
    }
    
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }




}


