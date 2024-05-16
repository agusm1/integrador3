package com.example.integrador3v1.Utils;
import com.example.integrador3v1.Modelos.Carrera;
import com.example.integrador3v1.Modelos.CarreraEstudiante;
import com.example.integrador3v1.Modelos.CarreraEstudianteID;
import com.example.integrador3v1.Modelos.Estudiante;
import com.example.integrador3v1.Repositorios.CarreraEstudianteRepositorio;
import com.example.integrador3v1.Repositorios.CarreraRepositorio;
import com.example.integrador3v1.Repositorios.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class CargaDeDatos {

    private final CarreraEstudianteRepositorio repoCE;
    private final CarreraRepositorio repoCarrera;
    private final EstudianteRepositorio repoEstudiante;

    @Autowired
    public CargaDeDatos(CarreraEstudianteRepositorio ceRepo, CarreraRepositorio carreraRepo, EstudianteRepositorio estudianteRepo) {
        this.repoCE = ceRepo;
        this.repoCarrera = carreraRepo;
        this.repoEstudiante = estudianteRepo;
    }

    public void cargarDatosEstudiantes() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/com/example/integrador3v1/CSV/estudiantes.csv");
        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Estudiante estudiante = new Estudiante();
                estudiante.setNum_doc(Long.valueOf(csvRecord.get("DNI")));
                estudiante.setNombre(csvRecord.get("nombre"));
                estudiante.setApellido(csvRecord.get("apellido"));
                estudiante.setGenero(csvRecord.get("genero"));
                estudiante.setEdad(Integer.parseInt(csvRecord.get("edad")));
                estudiante.setCiudad(csvRecord.get("ciudad"));
                estudiante.setNum_Libreta(Long.valueOf(csvRecord.get("LU")));
                System.out.println(estudiante);
                repoEstudiante.save(estudiante);
            }
        }
    }

    public void cargarDatosCE() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/com/example/integrador3v1/CSV/estudianteCarrera.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                CarreraEstudianteID id = new CarreraEstudianteID(
                        Long.valueOf(csvRecord.get("id_carrera")),
                        Long.valueOf(csvRecord.get("id_estudiante")));

                CarreraEstudiante ce = new CarreraEstudiante();
                ce.setId(id);
                ce.setId_ce(Long.valueOf(csvRecord.get("id")));
                ce.setFecha_inscripcion(Integer.valueOf(csvRecord.get("inscripcion")));
                ce.setFecha_graduacion(Integer.valueOf(csvRecord.get("graduacion")));
                ce.setAntiguedad(Integer.parseInt(csvRecord.get("antiguedad")));

                repoCE.save(ce);

            }
        }
    }

    public void cargarDatosCarrera() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/com/example/integrador3v1/CSV/carreras.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Carrera carrera = new Carrera();
                carrera.setIdCarrera(Long.valueOf(csvRecord.get("id_carrera")));
                carrera.setCarrera(csvRecord.get("carrera"));
                carrera.setDuracion(Integer.parseInt(csvRecord.get("duracion")));
                repoCarrera.save(carrera);
            }
        }
    }


}
