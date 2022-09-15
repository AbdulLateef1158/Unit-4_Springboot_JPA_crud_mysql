package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repos.StudentRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) repository.findAll();
    }

    @Override
    public Student getStudentById(Integer sno) {
        return repository.findById(sno).get();
    }

    @Override
    public void deleteStudent(Integer sno) {
        repository.deleteById(sno);
    }
}
