package com.example.integrador3v1.Servicios;
import com.example.integrador3v1.Modelos.Carrera;
import com.example.integrador3v1.Modelos.Estudiante;
import com.example.integrador3v1.Repositorios.CarreraRepositorio;
import com.example.integrador3v1.Servicios.dto.carrera.request.CarreraRequestDTO;
import com.example.integrador3v1.Servicios.dto.carrera.response.CarreraConInscriptosResponseDTO;
import com.example.integrador3v1.Servicios.dto.carrera.response.CarreraResponseDTO;
import com.example.integrador3v1.Servicios.dto.estudiante.request.EstudianteRequestDTO;
import com.example.integrador3v1.Servicios.dto.estudiante.response.EstudianteResponseDTO;
import com.example.integrador3v1.Servicios.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("CarreraServicio")
public class CarreraServicio {
    @Autowired
    public CarreraRepositorio carreraRepo;

    @Transactional
    public CarreraResponseDTO getCarreraByID(Long id) throws Exception{
        return this.carreraRepo.getCarreraByID(id)
                .map(CarreraResponseDTO::new)
                .orElseThrow(() -> new NotFoundException("Carrera", id));
    }
    @Transactional
    public CarreraResponseDTO save(CarreraRequestDTO request) {
        Carrera c = new Carrera();
        c.setCarrera(request.getNombre());
        c.setDuracion(request.getDuracion());
        carreraRepo.save(c);
        return new CarreraResponseDTO(c.getCarrera(), c.getDuracion());
    }


    @Transactional
    public List<CarreraConInscriptosResponseDTO> getCarrerasConInscriptos(){
        List<Object[]> objetos = this.carreraRepo.getCarrerasConInscriptos();
        List<CarreraConInscriptosResponseDTO> resultadoDTO = new ArrayList<>();
        for (Object [] objeto : objetos){
            CarreraConInscriptosResponseDTO cciResponse = new CarreraConInscriptosResponseDTO();
            cciResponse.setNombre(objeto[0].toString());
            cciResponse.setCantInscriptos((Long) objeto[1]);
            resultadoDTO.add(cciResponse);
        }
        return resultadoDTO;
    }
    @Transactional
    public List<Object[]> getReporteCarreras() {
        return carreraRepo.getReporteCarreras();
    }
}
