package com.example.practica.repository;

import com.example.practica.model.GradeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;


public interface GradeRepository extends JpaRepository<GradeModel, Long> {
    public abstract ArrayList<GradeModel> findGradeModelByStudentId(long id);
}
