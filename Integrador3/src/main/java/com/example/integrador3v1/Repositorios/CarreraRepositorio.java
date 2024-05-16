package com.example.integrador3v1.Repositorios;
import com.example.integrador3v1.DTOS.CarreraConInscriptosDTO;
import com.example.integrador3v1.DTOS.ReporteCarreraDTO;
import com.example.integrador3v1.Modelos.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("CarreraRepositorio")
public interface CarreraRepositorio extends JpaRepository<Carrera, Long> {
    @Query("SELECT c FROM Carrera c WHERE c.idCarrera=:id_carrera")
    public Carrera getCarreraByID(Long id_carrera);

    @Query("SELECT c.idCarrera,c.carrera,c.duracion, COUNT(c.duracion) AS cant_inscriptos " + "FROM Carrera AS c " + "JOIN CarreraEstudiante AS ce " + "WHERE (c.idCarrera=ce.id.idCarrera) " + "GROUP BY (c.idCarrera) " + "ORDER BY cant_inscriptos DESC")
    List<CarreraConInscriptosDTO> getCarrerasConInscriptos();

    @Query("SELECT c.carrera, ce.fecha_inscripcion," +
            "COUNT(ce.id.num_doc) , COUNT(ce.fecha_graduacion) " +
            "FROM Carrera AS c " +
            "JOIN CarreraEstudiante AS ce " +
            "WHERE (c.idCarrera = ce.id.idCarrera) "+
            "GROUP BY c.carrera,ce.fecha_inscripcion "+
            "ORDER BY c.carrera,ce.fecha_inscripcion,ce.fecha_graduacion ASC ")
    List<ReporteCarreraDTO> getReporteCarreras();

}
