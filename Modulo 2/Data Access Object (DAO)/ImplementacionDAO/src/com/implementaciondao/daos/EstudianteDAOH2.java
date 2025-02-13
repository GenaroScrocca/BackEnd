package com.implementaciondao.daos;

import com.implementaciondao.entidades.Estudiante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EstudianteDAOH2 implements Idao<Estudiante>{

    //CONEXION A LA BASE DE DATOS H2
    public final static String DB_JDBC_DRIVER= "org.h2.Driver";
    private final static String DB_URL= "jdbc:h2:tcp://localhost/~/test";
    private final static String DB_USER= "sa";
    private final static String DB_PASSWORD= "";


    //METODOS DE LA INTERFAZ

    //METODO GUARDAR
    @Override
    public Estudiante guardar(Estudiante estudiante) {
        Connection connection= null;
        PreparedStatement preparedStatement= null;

        try {
            //Primero necesitamos levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

           //Luego crear una sentencia INSERT
            preparedStatement= connection.prepareStatement("INSERT INTO estudiantes VALUES(?,?,?)");
           preparedStatement.setLong(1,estudiante.getId());
           preparedStatement.setString(2,estudiante.getNombre());
           preparedStatement.setString(3, estudiante.getApellido());

           //Luego ejecutar la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return estudiante;
    }

    //METODO ELIMINAR
    @Override
    public void eliminar(Long id) {
        Connection connection= null;
        PreparedStatement preparedStatement= null;

        try {
            //Primero necesitamos levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Luego crear una sentencia DELETE
            preparedStatement= connection.prepareStatement("DELETE FROM estudiantes WHERE id=?");
            preparedStatement.setLong(1,id);

            //Luego ejecutar la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Estudiante buscar(Long id) {
        Connection connection= null;
        PreparedStatement preparedStatement= null;
        Estudiante estudiante= null;

        try {
            //Primero necesitamos levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Luego crear una sentencia SELECT
            preparedStatement= connection.prepareStatement("SELECT * FROM estudiantes where id=?");
            preparedStatement.setLong(1,id);

            //Luego ejecutar la sentencia
            ResultSet result= preparedStatement.executeQuery();
            preparedStatement.close();

            //Aca tenemos que evaluar los resultados tambien recorriendolos
            while(result.next()){
                Long idEstudiante= result.getLong("id");
                String nombre= result.getString("nombre");
                String apellido= result.getString("apellido");
                estudiante= new Estudiante();
                estudiante.setId(idEstudiante);
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);
            }
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return estudiante;
    }

    @Override
    public List<Estudiante> buscarTodos() {
        Connection connection= null;
        PreparedStatement preparedStatement= null;
        List<Estudiante> estudiantes= new ArrayList();

        try {
            //Primero necesitamos levantar el driver y conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Luego crear una sentencia SELECT
            preparedStatement= connection.prepareStatement("SELECT * FROM estudiantes");

            //Luego ejecutar la sentencia
            ResultSet result= preparedStatement.executeQuery();
            preparedStatement.close();

            //Aca tenemos que evaluar los resultados tambien recorriendolos
            while(result.next()){
                Long idEstudiante= result.getLong("id");
                String nombre= result.getString("nombre");
                String apellido= result.getString("apellido");
                Estudiante estudiante= new Estudiante();
                estudiante= new Estudiante();
                estudiante.setId(idEstudiante);
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);
                estudiantes.add(estudiante);
            }
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return estudiantes;
    }

}
