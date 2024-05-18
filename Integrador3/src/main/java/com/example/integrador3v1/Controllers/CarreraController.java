package com.example.integrador3v1.Controllers;

import com.example.integrador3v1.Servicios.CarreraServicio;
import com.example.integrador3v1.Servicios.dto.carrera.response.CarreraConInscriptosResponseDTO;
import com.example.integrador3v1.Servicios.dto.carrera.response.CarreraResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carreras")
public class CarreraController {
    @Autowired
    private CarreraServicio serCarrera;

    @GetMapping("/{idCarrera}")
    public CarreraResponseDTO getCarrerasPorId(@PathVariable("idCarrera") Long id) throws Exception {
        return serCarrera.getCarreraByID(id);
    }

    @GetMapping("/inscriptos")
    public List<CarreraConInscriptosResponseDTO> getCarrerasConInscriptos(){
        return serCarrera.getCarrerasConInscriptos();
    }

    @GetMapping("/CarrerasPorAnio")
    public List<Object[]> getReporteCarreras() throws Exception{
        return serCarrera.getReporteCarreras();
    }
}
