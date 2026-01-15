package com.example.studentmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    
    // 1. Dùng Integer để chấp nhận giá trị null từ JSON
    private Integer age; 
    private String email;

    public Student() {
    }

    // 2. Sửa tham số age trong Constructor thành Integer
    public Student(Integer id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Integer getId() { 
        return id; 
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() { 
        return name; 
    }
    
    public void setName(String name) {
        this.name = name;
    }

    // 3. CHỈ GIỮ LẠI MỘT CẶP get/set cho age với kiểu Integer
    public Integer getAge() { 
        return age; 
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}