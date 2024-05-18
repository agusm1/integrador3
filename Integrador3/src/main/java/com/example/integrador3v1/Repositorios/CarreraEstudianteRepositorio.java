package com.example.integrador3v1.Repositorios;

import com.example.integrador3v1.Modelos.CarreraEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository("CarreraEstudianteRepositorio")
public interface CarreraEstudianteRepositorio extends JpaRepository<CarreraEstudiante, Long> {

    @Modifying
    @Query("DELETE FROM CarreraEstudiante ce WHERE ce.estudiante.num_doc = :numDoc")
    void deleteByEstudianteNumDoc(Long numDoc);
}
