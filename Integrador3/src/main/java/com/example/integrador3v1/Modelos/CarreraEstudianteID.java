package com.example.integrador3v1.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class CarreraEstudianteID implements Serializable {
    @Column(name = "id_carrera")
    private Long id_carrera;
    @Column(name = "num_doc")
    private Long num_doc;
}
