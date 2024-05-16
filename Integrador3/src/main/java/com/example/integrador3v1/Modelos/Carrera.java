package com.example.integrador3v1.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Carrera")
public class Carrera {
    @Getter
    @Setter
    @Id
    private Long idCarrera;
    @Getter @Setter
    @Column
    private String carrera;
    @Getter
    @Column
    private int duracion;
    @OneToMany(mappedBy = "carrera")
    private List<CarreraEstudiante> estudiantes;

    /**
     * Constructor por defecto.
     */
    public Carrera() {
    }
    /**
     * Constructor con parámetros para crear una nueva carrera.
     * @param idCarrera Identificador único de la carrera.
     * @param carrera   Nombre de la carrera.
     * @param duracion  Duración de la carrera en años.
     */
    public Carrera(Long idCarrera, String carrera, int duracion) {
        this.idCarrera = idCarrera;
        this.carrera = carrera;
        this.duracion = duracion;
        this.estudiantes = new ArrayList<>();
    }

    /**
     * Establece la duración de la carrera en años.
     * Si la duracion con la que se registro la carrera es 0 se puede setear la nueva duracion
     * @param duracion La duración de la carrera en años.
     */
    public void setDuracion(int duracion) {
        if(duracion>0){
            this.duracion = duracion;
        }
    }
    /**
     * Agrega un estudiante a la lista de estudiantes asociados a esta carrera.
     * @param ce La relación entre estudiante y carrera a agregar.
     */
    public void setEstudianteACarrera(CarreraEstudiante ce){
        this.estudiantes.add(ce);
    }
    @Override
    public String toString() {
        return "Carrera{ idCarrera=" + idCarrera + ", carrera='" + carrera + '\'' + ", duracion=" + duracion + '}';
    }
}

