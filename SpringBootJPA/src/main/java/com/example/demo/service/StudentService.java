package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {

    public Student saveStudent(Student student);

    public List<Student> getAllStudents();

    public Student getStudentById(Integer sno);

    public void deleteStudent(Integer sno);

}
