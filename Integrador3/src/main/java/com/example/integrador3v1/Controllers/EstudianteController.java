package com.example.integrador3v1.Controllers;
import com.example.integrador3v1.Modelos.Estudiante;
import com.example.integrador3v1.Servicios.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteServicio estudianteServicio;

    @GetMapping("/{num_lib}")
    public ResponseEntity<?> getEstudianteNumLibreta(@PathVariable Long num_lib){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteServicio.getEstudianteByNumLibreta(num_lib));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No se encuentra el objeto buscado.\"}");
        }
    }

    @GetMapping("buscar/{idCarrera}/{ciudad}")
    public ResponseEntity<?> getEstudiantesByCarrera(@PathVariable Long idCarrera, @PathVariable String ciudad){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteServicio.getEstudiantesByCarrera(idCarrera, ciudad));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/XApellido")
    public ResponseEntity<?> getEstudiantesByOrdenDelApellido(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteServicio.getEstudiantesByOrdenDelApellido());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<?> getEstudiantePorGenero(@PathVariable String genero){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteServicio.getEstudiantePorGenero(genero));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PostMapping("darDeAlta")
    public ResponseEntity<?> save(@RequestBody Estudiante entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteServicio.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo ingresar, revise los campos e intente nuevamente.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Estudiante entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteServicio.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo editar, revise los campos e intente nuevamente.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(estudianteServicio.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. no se pudo eliminar intente nuevamente.\"}");
        }
    }
}
