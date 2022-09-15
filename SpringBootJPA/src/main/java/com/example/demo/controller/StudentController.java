package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/studentDetails")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("/saveStudent")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        service.saveStudent(student);
        return new ResponseEntity<String>("Student details with Sno " + student.getSno() + " has been saved",
                HttpStatus.OK);
    }

    @GetMapping("/studentList")
    public ResponseEntity<List<Student>> getAllStudentDetails() {
        List<Student> list = service.getAllStudents();
        return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
    }

    @GetMapping("/getStudentById/{sno}")
    public ResponseEntity<Student> getStudentById(@PathVariable("sno") Integer sno) {
        Student std = service.getStudentById(sno);
        return new ResponseEntity<Student>(std, HttpStatus.OK);
    }

    @PutMapping("/updateStudent/{sno}")
    public ResponseEntity<String> updateStudent(@PathVariable("sno") Integer sno, @RequestBody Student student) {
        Student stdFromDb = service.getStudentById(sno);
        stdFromDb.setStdName(student.getStdName());
        stdFromDb.setStdClass(student.getStdClass());
        stdFromDb.setSchoolName(student.getSchoolName());
        service.saveStudent(stdFromDb);
        return new ResponseEntity<String>("Student with sno " + sno + " has been updated", HttpStatus.OK);
    }

    @DeleteMapping("deleteStudent/{sno}")
    public ResponseEntity<String> deleteStudent(@PathVariable("sno") Integer sno) {
        service.deleteStudent(sno);
        return new ResponseEntity<String>("Student with sno " + sno + " has been deleted", HttpStatus.OK);
    }

}
