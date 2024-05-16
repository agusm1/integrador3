package com.example.integrador3v1.Controllers;

import com.example.integrador3v1.Modelos.Carrera;
import com.example.integrador3v1.Servicios.CarreraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrera")
public class CarreraController {
    @Autowired
    private CarreraServicio serCarrera;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Carrera entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(serCarrera.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo ingresar, revise los campos e intente nuevamente.\"}");
        }
    }
    @GetMapping("/{idCarrera}")
    public ResponseEntity<?> getCarrerasPorId(Long id) throws Exception {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(serCarrera.getCarreraByID(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{Error. No se encuentra la carrera buscada}");
        }
    }

    @GetMapping("/inscriptos")
    public ResponseEntity<?> getCarrerasConInscriptos() throws Exception {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(serCarrera.getCarrerasConInscriptos());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{Error. No se encuentra la lista de inscriptos de la carrera}");
        }
    }
    @GetMapping("/CarrerasPorAño")
    public ResponseEntity<?> getReporteCarreras() throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(serCarrera.getReporteCarreras());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{Error. No se pudo generar el reporte de las carreras por año cronologico}");

        }
    }
}
