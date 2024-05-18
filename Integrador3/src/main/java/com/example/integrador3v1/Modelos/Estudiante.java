package com.example.integrador3v1.Modelos;

import com.example.integrador3v1.Servicios.dto.estudiante.request.EstudianteRequestDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "Estudiante")
@Data
@NoArgsConstructor
public class Estudiante {
    @Id
    @Column(name = "num_doc")
    private Long num_doc;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Edad")
    private int edad;
    @Column(name = "Genero")
    private String genero;
    @Column(name = "Ciudad")
    private String ciudad;
    @Column(name = "num_libreta")
    private Long num_Libreta;
    @OneToMany(mappedBy = "estudiante")
    private Set<CarreraEstudiante> estudiantes;

    public Estudiante (EstudianteRequestDTO request){
        this.num_doc = request.getNum_doc();
        this.nombre = request.getNombre();
        this.apellido = request.getApellido();
        this.edad = request.getEdad();
        this.genero = request.getGenero();
        this.ciudad = request.getCiudad();
        this.num_Libreta = request.getNum_Libreta();
    }
}

