package com.example.practica.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Table(name = "notas")
@Entity
@Data
@NoArgsConstructor
public class GradeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    @Min(value = 0, message = "Las nota no puede ser menor a 0")
    @Max(value = 20, message = "Las notas no pueden ser mayores a 20")
    @NotNull
    @Column(name = "nota_1")
    private float firstGrade;

    @Min(value = 0, message = "Las nota no puede ser menor a 0")
    @Max(value = 20, message = "Las notas no pueden ser mayores a 20")
    @NotNull
    @Column(name = "nota_2")
    private float secondGrade;

    @Min(value = 0, message = "Las nota no puede ser menor a 0")
    @Max(value = 20, message = "Las notas no pueden ser mayores a 20")
    @NotNull
    @Column(name = "nota_3")
    private float thirdGrade;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private StudentModel student;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private SubjectModel subject;

}
