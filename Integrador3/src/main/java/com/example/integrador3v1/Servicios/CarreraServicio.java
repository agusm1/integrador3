package com.example.integrador3v1.Servicios;

import com.example.integrador3v1.DTOS.CarreraConInscriptosDTO;
import com.example.integrador3v1.DTOS.ReporteCarreraDTO;
import com.example.integrador3v1.Modelos.Carrera;
import com.example.integrador3v1.Repositorios.CarreraRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CarreraServicio")
public class CarreraServicio {
    @Autowired
    private CarreraRepositorio carreraRepo;

    @Transactional
    public Carrera getCarreraByID(Long id) throws Exception{

        var resultado = carreraRepo.getCarreraByID(id);
        try{
            return resultado;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public Carrera save(Carrera entity) throws Exception {
        try{
            return (Carrera)  carreraRepo.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<CarreraConInscriptosDTO> getCarrerasConInscriptos()throws Exception{
        List<CarreraConInscriptosDTO> resultados = carreraRepo.getCarrerasConInscriptos();
        try{
            return resultados;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<ReporteCarreraDTO> getReporteCarreras() throws Exception {
        List<ReporteCarreraDTO> resultados = carreraRepo.getReporteCarreras();
        try{
            return resultados;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
