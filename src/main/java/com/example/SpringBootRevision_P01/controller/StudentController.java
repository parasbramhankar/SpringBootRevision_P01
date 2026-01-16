package com.example.SpringBootRevision_P01.controller;

import com.example.SpringBootRevision_P01.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<StudentDTO>getStudentById(@PathVariable int id){

        for(StudentDTO s:studentList){
            if(s.getId()==id){
               return ResponseEntity.ok(s);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/add")
    public ResponseEntity<String>addStudent(@RequestBody StudentDTO studentDTO){

        studentList.add(studentDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body("Student added successfully");
    }


    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO>updateStudent(@PathVariable int id, @RequestBody StudentDTO studentDTO){

        for(StudentDTO s: studentList){
            if(s.getId()==id){
                s.setAge(studentDTO.getAge());
                s.setName(studentDTO.getName());
                s.setEmail(studentDTO.getEmail());

                return ResponseEntity.ok(s);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String>updateEmail(@PathVariable int id, @RequestBody String email){

        for(StudentDTO s:studentList){
            if(s.getId()==id){
                s.setEmail(email);

                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Email updated successfully");
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid id:Student not found");

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteStudent(@PathVariable int id){

        for(StudentDTO s:studentList){
            if(s.getId()==id){
                studentList.remove(s);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student deleted successfully");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid id:Student not found");
    }

}
