package com.example.integrador3v1.Servicios.dto.estudiante.response;

import com.example.integrador3v1.Modelos.Estudiante;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EstudianteResponseDTO {
    private Long dni;
    private Long libretaUniversitaria;
    private String nombre;
    private String apellido;
    private String genero;
    private int edad;
    private String ciudad;

    public EstudianteResponseDTO(Long dni, Long libretaUniversitaria, String nombre, String apellido, String genero, int edad, String ciudad) {
        this.dni = dni;
        this.libretaUniversitaria = libretaUniversitaria;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public EstudianteResponseDTO(Estudiante e) {
        this.dni = e.getNum_doc();
        this.libretaUniversitaria = e.getNum_Libreta();
        this.nombre = e.getNombre();
        this.apellido = e.getApellido();
        this.genero = e.getGenero();
        this.edad = e.getEdad();
        this.ciudad = e.getCiudad();
    }
}
