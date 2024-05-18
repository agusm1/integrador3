package com.example.integrador3v1.Servicios.dto.carrera.response;
import com.example.integrador3v1.Modelos.Carrera;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CarreraResponseDTO {

    private String nombre;
    private int duracion;

    public CarreraResponseDTO(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public CarreraResponseDTO(Carrera c) {
        this.nombre = c.getCarrera();
        this.duracion = c.getDuracion();
    }
}
