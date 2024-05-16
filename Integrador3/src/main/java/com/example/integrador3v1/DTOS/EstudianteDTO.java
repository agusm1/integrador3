package com.example.integrador3v1.DTOS;

import lombok.Getter;

@Getter
public class EstudianteDTO {
    private Long dni;
    private Long libretaUniversitaria;
    private String nombre;
    private String apellido;
    private String genero;
    private int edad;
    private String ciudad;

    public EstudianteDTO(Long dni, Long libretaUniversitaria, String nombre, String apellido, String genero, int edad, String ciudad) {
        this.dni = dni;
        this.libretaUniversitaria = libretaUniversitaria;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
        this.ciudad = ciudad;
    }
}
