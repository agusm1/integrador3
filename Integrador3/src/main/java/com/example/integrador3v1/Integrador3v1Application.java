package com.example.integrador3v1;

import com.example.integrador3v1.Utils.CargaDeDatos;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Integrador3v1Application {

	@Autowired
	private CargaDeDatos cargaDeDatos;

	public static void main(String[] args) {
		SpringApplication.run(Integrador3v1Application.class, args);
	}
	@PostConstruct
	public void init() throws IOException {
		this.cargaDeDatos.cargarDatosEstudiantes();
		this.cargaDeDatos.cargarDatosCarrera();
		this.cargaDeDatos.cargarDatosCE();
	}

}
