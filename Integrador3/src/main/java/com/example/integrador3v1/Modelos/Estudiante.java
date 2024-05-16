package com.example.integrador3v1.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Estudiante")
@Getter @Setter
@NoArgsConstructor
public class Estudiante {
    @Id
    @Column(name = "num_doc")
    private Long num_doc;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Edad")
    private int edad;
    @Column(name = "Genero")
    private String genero;
    @Column(name = "Ciudad")
    private String ciudad;
    @Column(name = "num_libreta")
    private Long num_Libreta;
    @OneToMany(mappedBy = "estudiante")
    private List<CarreraEstudiante> carreras;
    /**
     * Constructor con parámetros.
     *
     * @param num_doc     Número de documento del estudiante.
     * @param num_Libreta Número de libreta universitaria del estudiante.
     * @param nombres     Nombre/s del estudiante.
     * @param apellido    Apellido del estudiante.
     * @param edad        Edad del estudiante.
     * @param genero      Género del estudiante.
     * @param ciudad      Ciudad de residencia del estudiante.
     */
    public Estudiante(Long num_doc, Long num_Libreta, String nombres, String apellido, int edad, String genero, String ciudad) {
        this.num_doc = num_doc;
        this.nombre = nombres;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudad = ciudad;
        this.num_Libreta = num_Libreta;
        this.carreras = new ArrayList<CarreraEstudiante>();
    }

    /**
     * Agrega una carrera a la lista de carreras del estudiante.
     * @param carrera Carrera a agregar.
     */
    public void setCarrera(CarreraEstudiante carrera) {this.carreras.add(carrera);}

    @Override
    public String toString() {
        return "Estudiante{" + "num_doc=" + num_doc + ", num_Libreta=" + num_Libreta + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", edad=" + edad + ", genero='" + genero + '\'' + ", ciudad='" + ciudad + '\'' + '}';
    }
}

