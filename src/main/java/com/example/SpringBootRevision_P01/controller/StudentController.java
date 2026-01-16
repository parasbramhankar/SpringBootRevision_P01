package com.example.SpringBootRevision_P01.controller;


import com.example.SpringBootRevision_P01.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/student")
public class StudentController{

    List<StudentDTO>studentList=new ArrayList<>();

    @GetMapping("/getAllStudent")
    public ResponseEntity<List<StudentDTO>>getAllStudent(){
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO>getStudentById(@RequestBody int id){

        StudentDTO student=new StudentDTO();
        boolean check=false;

        for(StudentDTO s:studentList){
            if(s.getId()==id){
                check=true;
                student.setId(s.getId());
                student.setAge(s.getAge());
                student.setName(s.getName());
                student.setEmail(s.getEmail());
                break;
            }
        }
        if(!check){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(student);
    }

}
