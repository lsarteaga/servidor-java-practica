package com.example.practica.service;

import com.example.practica.model.StudentModel;

import java.util.List;

public interface StudentService {
    StudentModel save(StudentModel studentModel);
    List<StudentModel> getAll();
    StudentModel getById(long id);
    StudentModel update(StudentModel studentModel, long id);
    void delete(long id);
}
