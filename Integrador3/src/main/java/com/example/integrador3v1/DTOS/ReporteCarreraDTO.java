package com.example.integrador3v1.DTOS;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class ReporteCarreraDTO implements Serializable {
    private String nombre;
    private int anio;
    private Long inscriptos;
    private Long egresados;

    public ReporteCarreraDTO(String nombre, int anio, Long inscriptos, Long egresados) {
        this.nombre = nombre;
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.egresados = egresados;
    }
}
