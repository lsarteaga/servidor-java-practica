package com.example.practica.controller;

import com.example.practica.model.SubjectModel;
import com.example.practica.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/subjects")
public class SubjectController {
    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        super();
        this.subjectService = subjectService;
    }

    @PostMapping("/create")
    public ResponseEntity<SubjectModel> save(@Valid @RequestBody SubjectModel subjectModel) {
        return new ResponseEntity<>(subjectService.save(subjectModel), HttpStatus.CREATED);
    }

    @GetMapping
    public List<SubjectModel> getAll() {
        return subjectService.getAll();
    }

    @GetMapping("/{id}/find")
    public ResponseEntity<SubjectModel> getdById(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(subjectService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<SubjectModel> update(@RequestBody @Valid SubjectModel subjectModel,
                                               @PathVariable(name = "id") long id) {
        return new ResponseEntity<>(subjectService.update(subjectModel, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/update")
    public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
        subjectService.delete(id);
        return new ResponseEntity<>("Materia eliminada", HttpStatus.OK);
    }
}
