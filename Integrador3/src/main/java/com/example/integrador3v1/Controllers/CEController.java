package com.example.integrador3v1.Controllers;

import com.example.integrador3v1.Modelos.CarreraEstudiante;
import com.example.integrador3v1.Repositorios.CarreraEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/carreraEstudiantes")
public class CEController {

    @Autowired
    private CarreraEstudianteRepositorio ceRepo;
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody CarreraEstudiante entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(ceRepo.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo ingresar, revise los campos e intente nuevamente.\"}");
        }
    }
}
