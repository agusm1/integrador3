package com.example.integrador3v1.Modelos;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Carrera")
@Data
public class Carrera {
    @Id
    private Long id_carrera;

    @Column
    private String carrera;

    @Column
    private int duracion;

    @OneToMany(mappedBy = "carrera")
    private List<CarreraEstudiante> estudiantes;

    public Carrera() {
    }

}

