package com.example.practica.service.implementation;

import com.example.practica.exception.ResourceNotFoundException;
import com.example.practica.model.SubjectModel;
import com.example.practica.repository.SubjectRepository;
import com.example.practica.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImplementation implements SubjectService {

    private SubjectRepository subjectRepository;

    public SubjectServiceImplementation(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public SubjectModel save(SubjectModel subjectModel) {
        return subjectRepository.save(subjectModel);
    }

    @Override
    public List<SubjectModel> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public SubjectModel getById(long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Materia no encontrada"));
    }

    @Override
    public SubjectModel update(SubjectModel subjectModel, long id) {
        SubjectModel subject = subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Materia no encontrada"));
        subject.setName(subjectModel.getName());
        subject.setNrc(subjectModel.getNrc());
        subjectRepository.save(subject);
        return subject;
    }

    @Override
    public void delete(long id) {
        subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Materia no encontrada"));
        subjectRepository.deleteById(id);
    }
}
