package com.example.SpringBootRevision_P01.service;

import com.example.SpringBootRevision_P01.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(int id);

    void addStudent(StudentDTO studentDTO);

    StudentDTO updateStudent(int id, StudentDTO studentDTO);

    boolean updateEmail(int id, String email);

    boolean deleteStudent(int id);
}
