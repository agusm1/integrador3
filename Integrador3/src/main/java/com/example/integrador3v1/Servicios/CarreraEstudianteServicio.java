package com.example.integrador3v1.Servicios;

import com.example.integrador3v1.Modelos.CarreraEstudiante;
import com.example.integrador3v1.Repositorios.CarreraEstudianteRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CarreraEstudianteServicio")
public class CarreraEstudianteServicio {
    @Autowired
    private CarreraEstudianteRepositorio ceRepo;

    @Transactional
    public CarreraEstudiante save(CarreraEstudiante entity) throws Exception {
        try{
            return (CarreraEstudiante) ceRepo.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
