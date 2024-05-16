package com.example.integrador3v1.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "CarreraEstudiante")
public class CarreraEstudiante implements Serializable {
    @Getter
    @Setter
    @EmbeddedId
    private CarreraEstudianteID id;
    @Getter @Setter
    private long id_ce;
    @Getter @Setter
    @Column
    private int fecha_inscripcion;
    @Getter
    @Column
    private int fecha_graduacion;
    @Getter @Setter
    @Column
    private int antiguedad;
    @ManyToOne
    @JoinColumn(name = "carrera-fk")
    private Carrera carrera;
    @ManyToOne
    @JoinColumn(name = "estudiante-fk")
    private Estudiante estudiante;

    public CarreraEstudiante() {
        super();
    }

    /**
     * Constructor con parámetros para crear una nueva relación sin fecha de graduación.
     *
     * @param fecha_inscripcion Año de inscripción en la carrera.
     * @param antiguedad        Antigüedad del estudiante en la carrera.
     */
    public CarreraEstudiante(Long id_ce, Carrera c, Estudiante e, int fecha_inscripcion, int antiguedad) {
        this.id = new CarreraEstudianteID(c.getIdCarrera(), e.getNum_doc());
        this.id_ce = id_ce;
        this.fecha_inscripcion = fecha_inscripcion;
        this.fecha_graduacion = 0;
        this.antiguedad = antiguedad;
        this.carrera = c;
        this.estudiante = e;
    }

    /**
     * Constructor con parámetros para crear una nueva relación con fecha de graduación.
     *
     * @param fecha_inscripcion Año de inscripción en la carrera.
     * @param graduacion        Año de graduación de la carrera.
     * @param antiguedad        Antigüedad del estudiante en la carrera.
     */
    public CarreraEstudiante(Carrera c, Estudiante e, int fecha_inscripcion, int graduacion, int antiguedad) {
        this.id = new CarreraEstudianteID(c.getIdCarrera(), e.getNum_doc());
        this.fecha_inscripcion = fecha_inscripcion;
        this.fecha_graduacion = graduacion;
        this.antiguedad = antiguedad;
        this.carrera = c;
        this.estudiante = e;
    }

    /**
     * Establece el año de graduación de la carrera.
     * Si no cuenta con fecha de graduacion se valida que la fecha de graduación
     * sea posterior a la fecha de inscripción
     *
     * @param fecha_graduacion El año de graduación de la carrera.
     */
    public void setFecha_graduacion(int fecha_graduacion) {
        if (this.fecha_graduacion == 0) {
            if (this.fecha_inscripcion < fecha_graduacion) {
                this.fecha_graduacion = fecha_graduacion;
            }
        }
    }

    @Override
    public String toString() {
        return "CarreraEstudiante [carrera=" + carrera.getCarrera() + ", Dni del alumno=" + estudiante.getNum_doc() + ", Año de inscripción=" + fecha_inscripcion + ", Año de graduación=" + fecha_graduacion + "]";
    }
}

