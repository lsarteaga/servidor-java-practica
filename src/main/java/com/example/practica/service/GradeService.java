package com.example.practica.service;

import com.example.practica.model.GradeModel;

import java.util.ArrayList;

public interface GradeService {
    GradeModel save(GradeModel gradeModel);
    GradeModel update(GradeModel gradeModel, long id);
    void delete(long id);
    ArrayList<GradeModel> getGradeByStudentId(long id);
}
