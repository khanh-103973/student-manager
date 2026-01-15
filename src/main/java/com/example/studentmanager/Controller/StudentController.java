package com.example.studentmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanager.model.Student;
import com.example.studentmanager.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin // cho phép frontend gọi
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }
    //1. API thêm sinh viên
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }
    
    //2. API xóa sinh viên
    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
        return "Student with ID " + id + " has been deleted.";
    }
    
    //3. Tìm kiếm sinh viên theo tên
    @GetMapping("/search")
    public List<Student> searchByName(@RequestParam String name) {
        return service.findByName(name);
    }

    //4. API lấy sinh viên theo ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return service.getStudentById(id);
    }

    // 6. API cập nhật sinh viên (Sửa lại để nhận JSON body và cập nhật đủ các trường)
    @PostMapping("/update/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student studentDetails) {
        Student existingStudent = service.getStudentById(id);
        if (existingStudent != null) {
            existingStudent.setName(studentDetails.getName());
            existingStudent.setEmail(studentDetails.getEmail());
            existingStudent.setAge(studentDetails.getAge()); // Cập nhật thêm tuổi
            return service.addStudent(existingStudent);
        }
        return null;
    }
    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable int id) {
        return "Sinh viên có mã: " + id;
    }

}