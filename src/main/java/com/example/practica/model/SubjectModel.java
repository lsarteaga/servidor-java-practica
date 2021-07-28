package com.example.practica.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "materias")
@Data
@NoArgsConstructor
public class SubjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    @NotNull
    @Column(name = "nombre")
    private String name;

    @NotNull
    @Column(name = "nrc")
    private String nrc;

}
