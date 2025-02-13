import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OdontologosDB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            //CONEXION A LA BASE DE DATOS
            Class.forName("org.h2.Driver");
            Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
            System.out.println("✅ Conexión exitosa a la base de datos");

            //CREAR TABLA SI NO EXISTE
            crearTablaOdontologos(con);

            //INSERTAR PRIMER ODONTOLOGO SI LA TABLA ESTA VACIA
            insertarPrimerOdontologo(con);

            //MENU
            boolean salir = false;
            while (!salir) {
                System.out.println("\nSeleccione una opción:");
                System.out.println("1. Insertar nuevo odontólogo");
                System.out.println("2. Ver todos los odontólogos");
                System.out.println("3. Editar odontólogo");
                System.out.println("4. Eliminar odontólogo");
                System.out.println("5. Filtrar odontólogos");
                System.out.println("6. Contar odontólogos");
                System.out.println("7. Eliminar tabla de odontólogos");
                System.out.println("8. Salir");

                int opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer de scanner

                switch (opcion) {
                    case 1:
                        //INSERTAR NUEVO ODONTOLOGO
                        System.out.print("Ingrese el apellido: ");
                        String apellido = scanner.nextLine();
                        System.out.print("Ingrese el nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese la matrícula: ");
                        String matricula = scanner.nextLine();

                        String insertSQL = "INSERT INTO Odontologos (apellido, nombre, matricula) VALUES (?, ?, ?)";
                        try (PreparedStatement stmt = con.prepareStatement(insertSQL)) {
                            stmt.setString(1, apellido);
                            stmt.setString(2, nombre);
                            stmt.setString(3, matricula);
                            stmt.executeUpdate();
                            System.out.println("✅ Odontólogo insertado correctamente");
                        }
                        break;

                    case 2:
                        //VER TODOS LOS ODONTOLOGOS
                        String selectSQL = "SELECT * FROM Odontologos";
                        try (PreparedStatement stmt = con.prepareStatement(selectSQL);
                             ResultSet rs = stmt.executeQuery()) {
                            while (rs.next()) {
                                System.out.println("ID: " + rs.getInt("id") +
                                        ", Apellido: " + rs.getString("apellido") +
                                        ", Nombre: " + rs.getString("nombre") +
                                        ", Matrícula: " + rs.getString("matricula"));
                            }
                        }
                        break;

                    case 3:
                        //EDITAR ODONTOLOGO
                        System.out.print("Ingrese la matrícula del odontólogo a editar: ");
                        String matriculaEditar = scanner.nextLine();
                        System.out.print("Ingrese la nueva matrícula: ");
                        String nuevaMatricula = scanner.nextLine();

                        String updateSQL = "UPDATE Odontologos SET matricula = ? WHERE matricula = ?";
                        try (PreparedStatement stmt = con.prepareStatement(updateSQL)) {
                            stmt.setString(1, nuevaMatricula);
                            stmt.setString(2, matriculaEditar);
                            int rowsUpdated = stmt.executeUpdate();
                            if (rowsUpdated > 0) {
                                System.out.println("✅ Matrícula actualizada correctamente");
                            } else {
                                System.out.println("❌ No se encontró el odontólogo con la matrícula proporcionada");
                            }
                        }
                        break;

                    case 4:
                        //ELIMINAR ODONTOLOGO
                        System.out.print("Ingrese la matrícula del odontólogo a eliminar: ");
                        String matriculaEliminar = scanner.nextLine();

                        String deleteSQL = "DELETE FROM Odontologos WHERE matricula = ?";
                        try (PreparedStatement stmt = con.prepareStatement(deleteSQL)) {
                            stmt.setString(1, matriculaEliminar);
                            int rowsDeleted = stmt.executeUpdate();
                            if (rowsDeleted > 0) {
                                System.out.println("✅ Odontólogo eliminado correctamente");
                            } else {
                                System.out.println("❌ No se encontró el odontólogo con la matrícula proporcionada");
                            }
                        }
                        break;

                    case 5:
                        //FILTRAR ODONTOLOGOS
                        System.out.print("Ingrese el apellido para filtrar: ");
                        String filtroApellido = scanner.nextLine();

                        String filterSQL = "SELECT * FROM Odontologos WHERE apellido LIKE ?";
                        try (PreparedStatement stmt = con.prepareStatement(filterSQL)) {
                            stmt.setString(1, "%" + filtroApellido + "%");
                            try (ResultSet rs = stmt.executeQuery()) {
                                while (rs.next()) {
                                    System.out.println("ID: " + rs.getInt("id") +
                                            ", Apellido: " + rs.getString("apellido") +
                                            ", Nombre: " + rs.getString("nombre") +
                                            ", Matrícula: " + rs.getString("matricula"));
                                }
                            }
                        }
                        break;

                    case 6:
                        //CONTAR ODONTOLOGOS
                        String countSQL = "SELECT COUNT(*) FROM Odontologos";
                        try (PreparedStatement stmt = con.prepareStatement(countSQL);
                             ResultSet rs = stmt.executeQuery()) {
                            if (rs.next()) {
                                System.out.println("Número total de odontólogos: " + rs.getInt(1));
                            }
                        }
                        break;

                    case 7:
                        //ELIMINAR TABLA ODONTOLOGOS
                        System.out.print("¿Está seguro de eliminar la tabla de odontólogos? (Sí/No): ");
                        String respuesta = scanner.nextLine().toLowerCase();
                        if (respuesta.equals("sí") || respuesta.equals("si")) {
                            String dropTableSQL = "DROP TABLE IF EXISTS Odontologos";
                            try (PreparedStatement stmt = con.prepareStatement(dropTableSQL)) {
                                stmt.executeUpdate();
                                System.out.println("✅ Tabla 'Odontologos' eliminada correctamente.");
                            } catch (SQLException e) {
                                System.out.println("❌ Error al eliminar la tabla: " + e.getMessage());
                            }
                        } else {
                            System.out.println("❌ No se eliminó la tabla.");
                        }
                        break;

                    case 8:
                        //SALIR
                        salir = true;
                        System.out.println("👋 Saliendo...");
                        break;

                    default:
                        System.out.println("❌ Opción no válida. Intente nuevamente.");
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
        }
    }

    // Método para crear la tabla si no existe
    private static void crearTablaOdontologos(Connection con) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Odontologos (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "apellido VARCHAR(100), " +
                "nombre VARCHAR(100), " +
                "matricula VARCHAR(50) UNIQUE)";
        try (PreparedStatement stmt = con.prepareStatement(createTableSQL)) {
            stmt.executeUpdate();
        }
    }

    // Método para insertar el primer odontólogo si la tabla está vacía
    private static void insertarPrimerOdontologo(Connection con) throws SQLException {
        String countSQL = "SELECT COUNT(*) FROM Odontologos";
        try (PreparedStatement stmt = con.prepareStatement(countSQL);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next() && rs.getInt(1) == 0) {
                String insertSQL = "INSERT INTO Odontologos (apellido, nombre, matricula) VALUES (?, ?, ?)";
                try (PreparedStatement insertStmt = con.prepareStatement(insertSQL)) {
                    insertStmt.setString(1, "Perez");
                    insertStmt.setString(2, "Juan");
                    insertStmt.setString(3, "12345");
                    insertStmt.executeUpdate();
                    System.out.println("✅ Primer odontólogo insertado");
                }
            }
        }
    }
}