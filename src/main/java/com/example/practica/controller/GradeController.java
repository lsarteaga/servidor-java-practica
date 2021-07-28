package com.example.practica.controller;

import com.example.practica.model.GradeModel;
import com.example.practica.service.GradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/grades")
@CrossOrigin(origins = "*")
public class GradeController {
    private GradeService gradeService;

    public GradeController(GradeService gradeService) {
        super();
        this.gradeService = gradeService;
    }

    @PostMapping("/create")
    public ResponseEntity<GradeModel> save(@Valid @RequestBody GradeModel gradeModel) {
        return new ResponseEntity<>(gradeService.save(gradeModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<GradeModel> update(@Valid @RequestBody GradeModel gradeModel, long id) {
        return new ResponseEntity<>(gradeService.update(gradeModel, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
        gradeService.delete(id);
        return new ResponseEntity<>("Notas eliminadas", HttpStatus.OK);
    }

    @GetMapping("/{id}/student")
    public ArrayList<GradeModel> findByStudentId(@PathVariable(name = "id") long id) {
        return gradeService.getGradeByStudentId(id);
    }
}
