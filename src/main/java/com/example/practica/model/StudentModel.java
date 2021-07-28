package com.example.practica.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Table(name = "alumnos")
@Entity
@NoArgsConstructor
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    @NotNull
    @Size(min = 3, max = 45, message = "El nombre debe estar entre 3 y 45 caracteres")
    @Column(name = "nombre")
    private String name;

    @NotNull
    @Size(min = 10, max = 10, message = "La cedula debe contener 10 numeros")
    private String ci;

}
