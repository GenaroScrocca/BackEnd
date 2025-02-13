package com.implementaciondao;

import com.implementaciondao.daos.EstudianteDAOH2;
import com.implementaciondao.entidades.Estudiante;
import com.implementaciondao.servicios.EstudianteService;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante= new Estudiante(); //creamos objeto estudainte de la clase estudiante
        estudiante.setId(1L);
        estudiante.setNombre("Genaro");
        estudiante.setApellido("Scrocca");

        EstudianteService estudianteService= new EstudianteService();
        //setteamos DAO (estrategia de persistencia bd H2)
        estudianteService.setEstudainteIdao(new EstudianteDAOH2());

        estudianteService.guardarEstudiante(estudiante);
    }
}
