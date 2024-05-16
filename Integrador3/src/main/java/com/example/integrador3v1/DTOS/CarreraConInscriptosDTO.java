package com.example.integrador3v1.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarreraConInscriptosDTO {
    private Long id_carrera;
    private String nombre;
    private int duracion;
    private int cantInscriptos;

    public CarreraConInscriptosDTO(Long id_carrera, String nombre, int duracion, int cantInscriptos) {
        this.id_carrera = id_carrera;
        this.nombre = nombre;
        this.duracion = duracion;
        this.cantInscriptos = cantInscriptos;
    }
}
