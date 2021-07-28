package com.example.practica.service;

import com.example.practica.model.SubjectModel;

import java.util.List;

public interface SubjectService {
    SubjectModel save(SubjectModel subjectModel);
    List<SubjectModel> getAll();
    SubjectModel getById(long id);
    SubjectModel update(SubjectModel subjectModel, long id);
    void delete(long id);
}
