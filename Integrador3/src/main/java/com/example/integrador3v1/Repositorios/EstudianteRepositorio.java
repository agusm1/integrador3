package com.example.integrador3v1.Repositorios;
import com.example.integrador3v1.Modelos.Estudiante;
import com.example.integrador3v1.Servicios.dto.estudiante.response.EstudianteResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository("EstudianteRepositorio")
public interface EstudianteRepositorio  extends JpaRepository<Estudiante, Long> {

    @Query("SELECT e FROM Estudiante e WHERE e.num_Libreta=:lib")
    Optional<Estudiante> getEstudiantePorNumLibreta(Long lib);

    @Query("SELECT e FROM Estudiante e WHERE e.genero=:generoElegido")
    List<EstudianteResponseDTO> findByGenero(@Param("generoElegido") String generoElegido);

    @Query("SELECT e FROM Estudiante e ORDER BY e.apellido DESC")
    List<Estudiante> getEstudiantesPorOrdenDelApellido();

    @Query("SELECT e " +
            "FROM Estudiante  e " +
            "JOIN CarreraEstudiante ce ON ce.estudiante.num_doc = e.num_doc " +
            "JOIN Carrera c ON ce.carrera.id_carrera = c.id_carrera "  +
            "WHERE c.id_carrera = :id_carrera  AND e.ciudad = :ciudad ")
    List<Estudiante> getEstudiantesByCarrera(@Param("id_carrera") Long id_carrera, @Param("ciudad") String ciudad);
}
