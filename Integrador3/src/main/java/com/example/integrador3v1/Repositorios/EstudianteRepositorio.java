package com.example.integrador3v1.Repositorios;
import com.example.integrador3v1.DTOS.EstudianteDTO;
import com.example.integrador3v1.Modelos.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("EstudianteRepositorio")
public interface EstudianteRepositorio  extends JpaRepository<Estudiante, Long> {
    @Query("SELECT e FROM Estudiante e WHERE e.num_Libreta=:lib")
    public Estudiante getEstudiantePorNumLibreta(Long lib);

    @Query("SELECT e FROM Estudiante e WHERE e.genero=:generoElegido")
    public List<Estudiante> findByGenero(@Param("generoElegido") String generoElegido);

    @Query("SELECT e FROM Estudiante e ORDER BY e.apellido DESC")
    public List<Estudiante> getEstudiantesPorOrdenDelApellido();

    @Query("SELECT new com.example.integrador3v1.DTOS.EstudianteDTO(e.num_doc, e.num_Libreta, e.nombre, e.apellido, e.genero, e.edad, e.ciudad) " +
            "FROM Estudiante e " +
            "JOIN CarreraEstudiante ce ON e.num_doc = ce.id.num_doc " +
            "JOIN Carrera ca ON ca.idCarrera = ce.id.idCarrera " +
            "WHERE ca.idCarrera = :id_carrera AND e.ciudad = :ciudad")
    public List<EstudianteDTO> getEstudiantesByCarrera(@Param("id_carrera") Long id_carrera, @Param("ciudad") String ciudad);
}
