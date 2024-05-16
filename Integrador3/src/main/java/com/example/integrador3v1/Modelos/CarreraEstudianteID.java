package com.example.integrador3v1.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CarreraEstudianteID {
    @Column
    private Long idCarrera;
    @Column
    private Long num_doc;
}
