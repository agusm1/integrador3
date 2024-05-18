package com.example.integrador3v1.Servicios;

import com.example.integrador3v1.Modelos.Estudiante;
import com.example.integrador3v1.Repositorios.CarreraEstudianteRepositorio;
import com.example.integrador3v1.Repositorios.EstudianteRepositorio;
import com.example.integrador3v1.Servicios.dto.estudiante.request.EstudianteRequestDTO;
import com.example.integrador3v1.Servicios.dto.estudiante.response.EstudianteResponseDTO;
import com.example.integrador3v1.Servicios.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("EstudianteServicio")
public class EstudianteServicio {

    @Autowired
    private EstudianteRepositorio repoEstudiante;

    @Autowired
    private CarreraEstudianteRepositorio carreraEstudianteRepo;

    @Transactional(readOnly = true)
    public EstudianteResponseDTO getEstudianteByNumLibreta(Long lib) throws Exception {
        return this.repoEstudiante.getEstudiantePorNumLibreta(lib)
                .map(EstudianteResponseDTO::new)
                .orElseThrow(() -> new NotFoundException("Estudiante", lib));
    }

    @Transactional
    public List<EstudianteResponseDTO> getEstudiantesByOrdenDelApellido() {
        return this.repoEstudiante.getEstudiantesPorOrdenDelApellido().stream().map(EstudianteResponseDTO::new).toList();
    }

    @Transactional
    public List<EstudianteResponseDTO> getEstudiantesByCarrera(Long id_carrera, String ciudad) throws Exception {
        return this.repoEstudiante.getEstudiantesByCarrera(id_carrera, ciudad).stream().map(EstudianteResponseDTO::new).toList();
    }

    @Transactional
    public List<EstudianteResponseDTO> getEstudiantePorGenero(String genero){
        return repoEstudiante.findByGenero(genero);
    }

    @Transactional
    public EstudianteResponseDTO save(EstudianteRequestDTO request) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(request.getNombre());
        estudiante.setApellido(request.getApellido());
        estudiante.setEdad(request.getEdad());
        estudiante.setCiudad(request.getCiudad());
        estudiante.setGenero(request.getGenero());
        estudiante.setNum_doc(request.getNum_doc());
        estudiante.setNum_Libreta(request.getNum_Libreta());
        repoEstudiante.save(estudiante);
        return new EstudianteResponseDTO(estudiante.getNum_doc(), estudiante.getNum_Libreta(), estudiante.getNombre(), estudiante.getApellido(), estudiante.getGenero(), estudiante.getEdad() ,estudiante.getCiudad());
    }


    @Transactional
    public EstudianteResponseDTO update(Long id, EstudianteRequestDTO entity) throws Exception {
        Estudiante estudiante = repoEstudiante.findById(id)
                .orElseThrow(() -> new NotFoundException("Estudiante", id));

        estudiante.setNombre(entity.getNombre());
        estudiante.setApellido(entity.getApellido());
        estudiante.setGenero(entity.getGenero());
        estudiante.setEdad(entity.getEdad());
        estudiante.setCiudad(entity.getCiudad());
        estudiante.setNum_Libreta(entity.getNum_Libreta());

        repoEstudiante.save(estudiante);
        return new EstudianteResponseDTO(estudiante);
    }

    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            // Eliminar las referencias en la tabla carrera_estudiante
            carreraEstudianteRepo.deleteByEstudianteNumDoc(id);
            // Luego, eliminar al estudiante
            repoEstudiante.deleteById(id);
            return true;
        } catch (Exception e) {
            // Manejar cualquier excepción y registrarla
            e.printStackTrace(); // Registra la excepción en la consola o en los logs
            return false;
        }
    }
}

