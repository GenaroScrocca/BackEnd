package com.implementaciondao.servicios;

import com.implementaciondao.daos.Idao;
import com.implementaciondao.entidades.Estudiante;
import java.util.List;


public class EstudianteService {

    //ATRIBUTO O PROPIEDAD DE TIPO DAO
    private Idao<Estudiante> estudianteIdao;

    //GETTERS & SETTERS
    public Idao<Estudiante> getEstudainteIdao() {
        return estudianteIdao;
    }
    public void setEstudainteIdao(Idao<Estudiante> estudainteIdao) { //con este setters setteamos el mecanismo de persistencia (que base de datos usas H2, mysql,etc)
        this.estudianteIdao = estudainteIdao;
    }

    //CON ESTOS METODOS DEL ELIMINAR BUSCAR GUARDAR ETC, delegamos aca la responsabilidad de guardar al DAO

    //METODO PARA GUARDAR Y RETONAR ESTUDIANTE
    public Estudiante guardarEstudiante(Estudiante e){
        return estudianteIdao.guardar(e);
    }

    //METODO PARA ELIMINAR ESTUDIANTE
    public void eliminarEstudiante(Long id){
        estudianteIdao.eliminar(id);
    }

    //METODO PARA BUSCAR ESTUDIANTE
    public Estudiante buscarEstudiante(Long id){
        return getEstudainteIdao().buscar(id);
    }

    //METODO PARA BUSCAR TODOS LOS ESTUDIANTES
    public List<Estudiante> buscarTodos(){
        return estudianteIdao.buscarTodos();
    }

}
