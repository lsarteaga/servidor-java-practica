package com.example.practica.service.implementation;

import com.example.practica.exception.ResourceNotFoundException;
import com.example.practica.model.GradeModel;
import com.example.practica.repository.GradeRepository;
import com.example.practica.service.GradeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GradeServiceImplementation implements GradeService {
    private GradeRepository gradeRepository;

    public GradeServiceImplementation(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }
    @Override
    public GradeModel save(GradeModel gradeModel) {
        return gradeRepository.save(gradeModel);
    }

    @Override
    public GradeModel update(GradeModel gradeModel, long id) {
        GradeModel grade = gradeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));
        grade.setFirstGrade(gradeModel.getFirstGrade());
        grade.setSecondGrade(gradeModel.getSecondGrade());
        grade.setThirdGrade(gradeModel.getThirdGrade());
        return gradeRepository.save(grade);
    }

    @Override
    public void delete(long id) {
        gradeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));
        gradeRepository.deleteById(id);
    }

    @Override
    public ArrayList<GradeModel> getGradeByStudentId(long id) {
        return gradeRepository.findGradeModelByStudentId(id);
    }
}
