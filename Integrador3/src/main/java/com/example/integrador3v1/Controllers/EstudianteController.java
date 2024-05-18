package com.example.integrador3v1.Controllers;
import com.example.integrador3v1.Servicios.EstudianteServicio;
import com.example.integrador3v1.Servicios.dto.estudiante.request.EstudianteRequestDTO;
import com.example.integrador3v1.Servicios.dto.estudiante.response.EstudianteResponseDTO;
import jakarta.validation.Valid;
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
    public ResponseEntity<?> save(@RequestBody @Valid EstudianteRequestDTO request){
        EstudianteResponseDTO result = this.estudianteServicio.save(request);
        return ResponseEntity.accepted().body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EstudianteRequestDTO entity){
        EstudianteResponseDTO result = this.estudianteServicio.save(entity);
        return ResponseEntity.accepted().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            boolean result = estudianteServicio.delete(id);
            if (result) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Estudiante no encontrado.\"}");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. no se pudo eliminar intente nuevamente.\"}");
        }
    }
}
