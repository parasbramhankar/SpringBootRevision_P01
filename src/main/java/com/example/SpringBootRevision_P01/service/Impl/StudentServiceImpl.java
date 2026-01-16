package com.example.SpringBootRevision_P01.service.Impl;



import com.example.SpringBootRevision_P01.dto.StudentDTO;
import com.example.SpringBootRevision_P01.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private List<StudentDTO> studentList = new ArrayList<>();

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentList;
    }

    @Override
    public StudentDTO getStudentById(int id) {
        for (StudentDTO s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void addStudent(StudentDTO studentDTO) {
        studentList.add(studentDTO);
    }

    @Override
    public StudentDTO updateStudent(int id, StudentDTO studentDTO) {
        for (StudentDTO s : studentList) {
            if (s.getId() == id) {
                s.setName(studentDTO.getName());
                s.setEmail(studentDTO.getEmail());
                s.setAge(studentDTO.getAge());
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean updateEmail(int id, String email) {
        for (StudentDTO s : studentList) {
            if (s.getId() == id) {
                s.setEmail(email);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteStudent(int id) {
        for (StudentDTO s : studentList) {
            if (s.getId() == id) {
                studentList.remove(s);
                return true;
            }
        }
        return false;
    }
}

