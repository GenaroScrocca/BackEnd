package com.implementaciondao.entidades;

public class Estudiante {

    //ATRIBUTOS
    private String nombre;
    private String apellido;
    private Long id; //conviene que sea un Long en vez de un INT porque capaz un programa grande tiene una re banda de ids. El long es como INT pero te permite numeros ams grandes

    //GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
