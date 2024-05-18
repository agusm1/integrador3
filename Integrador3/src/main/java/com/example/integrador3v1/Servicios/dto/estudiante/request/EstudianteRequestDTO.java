package com.example.integrador3v1.Servicios.dto.estudiante.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties( ignoreUnknown = true )
public class EstudianteRequestDTO {

    @NotNull( message = "El nombre es un campo obligatorio.")
    private Long num_doc;
    @NotNull( message = "El nombre es un campo obligatorio.")
    @NotEmpty( message = "El nombre es un campo obligatorio.")
    private String nombre;
    @NotNull( message = "El nombre es un campo obligatorio.")
    @NotEmpty( message = "El nombre es un campo obligatorio.")
    private String apellido;
    @NotNull( message = "El nombre es un campo obligatorio.")
    private int edad;
    @NotNull( message = "El nombre es un campo obligatorio.")
    @NotEmpty( message = "El nombre es un campo obligatorio.")
    private String genero;
    @NotNull( message = "El nombre es un campo obligatorio.")
    @NotEmpty( message = "El nombre es un campo obligatorio.")
    private String ciudad;
    @NotNull( message = "El nombre es un campo obligatorio.")
    private Long num_Libreta;

}
