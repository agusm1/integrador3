package com.example.integrador3v1.Servicios;

import com.example.integrador3v1.DTOS.EstudianteDTO;
import com.example.integrador3v1.Modelos.Estudiante;
import com.example.integrador3v1.Repositorios.EstudianteRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("EstudianteServicio")
public class EstudianteServicio {

    @Autowired
    private EstudianteRepositorio repoEstudiante;

    @Transactional
    public Estudiante getEstudianteByNumLibreta(Long lib) throws Exception {

        var resultado = repoEstudiante.getEstudiantePorNumLibreta(lib);
        try {
            return resultado;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<EstudianteDTO> getEstudiantesByOrdenDelApellido() throws Exception {
        var resultado = repoEstudiante.getEstudiantesPorOrdenDelApellido();
        try {
            return resultado.stream().map(estudiante -> new EstudianteDTO(estudiante.getNum_doc(), estudiante.getNum_Libreta(), estudiante.getNombre(), estudiante.getApellido(), estudiante.getGenero(), estudiante.getEdad(), estudiante.getCiudad())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<EstudianteDTO> getEstudiantesByCarrera(Long id_carrera, String ciudad) throws Exception {
        var resultados = repoEstudiante.getEstudiantesByCarrera(id_carrera, ciudad);
        try {
            return  resultados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<EstudianteDTO> getEstudiantePorGenero(String genero) throws Exception {

        var resultado = repoEstudiante.findByGenero(genero);
        try {
            return resultado.stream().map(estudiante -> new EstudianteDTO(estudiante.getNum_doc(), estudiante.getNum_Libreta(), estudiante.getNombre(), estudiante.getApellido(), estudiante.getGenero(), estudiante.getEdad(), estudiante.getCiudad())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Estudiante save(Estudiante entity) throws Exception {
        try{
            return repoEstudiante.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Estudiante update(Long id, Estudiante entity) throws Exception {
        try{
            Optional<Estudiante> entityOpcional = Optional.ofNullable(repoEstudiante.getEstudiantePorNumLibreta(id));
            Estudiante estudiante = entityOpcional.get();
            estudiante = repoEstudiante.save(entity);
            return estudiante;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if(repoEstudiante.existsById(id)){
                repoEstudiante.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

