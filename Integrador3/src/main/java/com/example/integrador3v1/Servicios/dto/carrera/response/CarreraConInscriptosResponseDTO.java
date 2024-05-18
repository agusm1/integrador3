package com.example.integrador3v1.Servicios.dto.carrera.response;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class CarreraConInscriptosResponseDTO {
    private String nombre;
    private Long cantInscriptos;


    public CarreraConInscriptosResponseDTO(CarreraConInscriptosResponseDTO cciResponseDTO) {
        this.nombre = cciResponseDTO.getNombre();
        this.cantInscriptos = cciResponseDTO.getCantInscriptos();
    }
}
