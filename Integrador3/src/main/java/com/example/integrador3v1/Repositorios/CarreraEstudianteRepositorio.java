package com.example.integrador3v1.Repositorios;

import com.example.integrador3v1.Modelos.CarreraEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CarreraEstudianteRepositorio")
public interface CarreraEstudianteRepositorio extends JpaRepository<CarreraEstudiante, Long> {

}
