package com.example.practica.controller;

import com.example.practica.model.StudentModel;
import com.example.practica.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<StudentModel> save(@Valid @RequestBody StudentModel studentModel) {
        return new ResponseEntity<>(studentService.save(studentModel), HttpStatus.CREATED);
    }

    @GetMapping
    public List<StudentModel> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}/find")
    public ResponseEntity<StudentModel> getById(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(studentService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<StudentModel> update(@Valid @RequestBody StudentModel studentModel,
                                               @PathVariable(name = "id") long id) {
        return new ResponseEntity<>(studentService.update(studentModel, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> delete(@PathVariable(name = "id") long id) {
        studentService.delete(id);
        return new ResponseEntity<>("Alumno eliminado", HttpStatus.OK);
    }
}
