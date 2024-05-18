package com.example.integrador3v1.Modelos;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "CarreraEstudiante")
@Data
@EqualsAndHashCode
public class CarreraEstudiante implements Serializable {
    @EmbeddedId
    private CarreraEstudianteID id;
    @Column
    private long id_ce;
    @ManyToOne
//    @MapsId("id_carrera")
    @JoinColumn( name = "id_carrera", insertable=false, updatable=false)
    private Carrera carrera;

    @ManyToOne
//    @MapsId("id_estudiante")
    @JoinColumn( name = "num_doc", insertable=false, updatable=false)
    private Estudiante estudiante;

    @Column
    private int fecha_inscripcion;
    @Column
    private int fecha_graduacion;
    @Column
    private int antiguedad;

    public CarreraEstudiante() {}


    @Override
    public String toString() {
        return "CarreraEstudiante [carrera=" + carrera.getCarrera() + ", Dni del alumno=" + estudiante.getNum_doc() + ", Año de inscripción=" + fecha_inscripcion + ", Año de graduación=" + fecha_graduacion + "]";
    }
}

