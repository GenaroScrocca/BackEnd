import java.sql.Connection; //extraemos clases del paquete java.sql
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//psvm te tira la main de una

public class InsertarPacientes {
    public static void main(String[] args) {
        try {
            // 📌 Registrar el driver de H2 (opcional en versiones nuevas)
            Class.forName("org.h2.Driver");

            // 📌 Conexión con la misma configuración que te funcionó antes
            Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
            System.out.println("✅ Conexión exitosa a la base de datos");

            // 📌 Insertar un paciente en la tabla Pacientes
            String query = "INSERT INTO Pacientes (nombre, apellido, domicilio, dni, fecha_alta, usuario, password) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, "Juan");
                pstmt.setString(2, "Pérez");
                pstmt.setString(3, "Av. Siempre Viva 123");
                pstmt.setString(4, "12345678");
                pstmt.setString(5, "2024-07-07");  // Formato YYYY-MM-DD
                pstmt.setString(6, "juanp");
                pstmt.setString(7, "segura123");

                int filasAfectadas = pstmt.executeUpdate();
                System.out.println("✅ Se insertó el paciente correctamente. Filas afectadas: " + filasAfectadas);
            }

            con.close(); // 📌 Cerrar conexión

        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error: No se encontró el driver de H2");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Error en la base de datos");
            e.printStackTrace();
        }
    }
}
