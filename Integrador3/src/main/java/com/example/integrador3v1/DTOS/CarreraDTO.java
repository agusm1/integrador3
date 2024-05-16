package com.example.integrador3v1.DTOS;

import lombok.Getter;

@Getter
public class CarreraDTO {
    private Long idCarrera;
    private String nombre;
    private int duracion;
    private Long cantInscriptos;
    /**
     * @brief Constructor de CarreraDTO.
     * @param idCarrera El ID de la carrera.
     * @param nombre El nombre de la carrera.
     * @param duracion La duración de la carrera en años.
     */
    public CarreraDTO(Long idCarrera, String nombre, int duracion) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.duracion = duracion;
        this.cantInscriptos = 0L;
    }
    public CarreraDTO(Long idCarrera, String carrera, int duracion, Long cantInscriptos) {
        this.idCarrera = idCarrera;
        this.nombre = carrera;
        this.duracion = duracion;
        this.cantInscriptos = cantInscriptos;
    }

    @Override
    public String toString() {
        return "CarreraDTO{" +  "idCarrera= " + idCarrera + ", nombre= '" + nombre + '\'' + ", duracion= " + duracion + '}';
    }
}
