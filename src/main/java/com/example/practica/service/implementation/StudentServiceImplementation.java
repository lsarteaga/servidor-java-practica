package com.example.practica.service.implementation;

import com.example.practica.exception.ResourceNotFoundException;
import com.example.practica.model.StudentModel;
import com.example.practica.repository.StudentRepository;
import com.example.practica.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentModel save(StudentModel studentModel) {
        return studentRepository.save(studentModel);
    }

    @Override
    public List<StudentModel> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public StudentModel getById(long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("alumno no encontrado"));
    }

    @Override
    public StudentModel update(StudentModel studentModel, long id) {
        StudentModel alumno = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("alumno no encontrado")
        );
        alumno.setName(studentModel.getName());
        alumno.setCi(studentModel.getCi());
        studentRepository.save(alumno);
        return alumno;
    }

    @Override
    public void delete(long id) {
        studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("alumno no encontrado"));
        studentRepository.deleteById(id);
    }
}
