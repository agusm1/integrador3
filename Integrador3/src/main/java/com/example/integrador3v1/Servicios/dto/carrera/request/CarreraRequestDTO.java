package com.example.integrador3v1.Servicios.dto.carrera.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties( ignoreUnknown = true )
public class CarreraRequestDTO {

    @NotNull( message = "El nombre es un campo obligatorio.")
    @NotEmpty( message = "El nombre es un campo obligatorio.")
    private String nombre;
    @NotNull( message = "La duracion es un campo obligatorio.")
    private int duracion;

}
