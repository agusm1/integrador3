package com.example.integrador3v1.Repositorios;
import com.example.integrador3v1.Modelos.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository("CarreraRepositorio")
public interface CarreraRepositorio extends JpaRepository<Carrera, Long> {

    @Query("SELECT c FROM Carrera c WHERE c.id_carrera=:id_carrera")
    Optional<Carrera> getCarreraByID(Long id_carrera);

    @Query("SELECT c.carrera, COUNT(ce.id.id_carrera) AS cant_inscriptos FROM Carrera c JOIN CarreraEstudiante  ce ON (ce.id.id_carrera = c.id_carrera) GROUP BY c.id_carrera, c.carrera, c.duracion ORDER BY cant_inscriptos DESC")
    List<Object[]> getCarrerasConInscriptos();


    @Query("SELECT c.carrera, ce.fecha_inscripcion, COUNT(ce.id.num_doc), COUNT(ce.fecha_graduacion) " +
            "FROM Carrera AS c " +
            "JOIN CarreraEstudiante AS ce " +
            "ON (c.id_carrera = ce.id.id_carrera) "+
            "GROUP BY c.carrera,ce.fecha_inscripcion "+
            "ORDER BY c.carrera,ce.fecha_inscripcion, ce.fecha_graduacion ASC")
    List<Object[]> getReporteCarreras();

}
