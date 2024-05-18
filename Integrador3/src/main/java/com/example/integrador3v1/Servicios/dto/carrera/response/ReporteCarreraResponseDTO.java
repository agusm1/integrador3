package com.example.integrador3v1.Servicios.dto.carrera.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteCarreraResponseDTO {

    private String nombre;
    private Long fecha_inscripcion;
    private Integer cant_inscriptos;
    private Integer cant_egresados;

}
