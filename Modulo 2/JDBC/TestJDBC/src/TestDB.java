import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB {

    public static void main(String[] args) {
        try {
            // Registrar el driver H2 (aunque a partir de H2 1.4.x no es necesario explícitamente)
            Class.forName("org.h2.Driver");

            // Establecer la conexión con la base de datos H2 en el archivo. Se conecta a la base de datos "my" ubicada en el directorio ./Database/.
            Connection con = DriverManager.getConnection("jdbc:h2:./Database/my", "root", "myPassword");

            // Crear un Statement para ejecutar las consultas
            Statement stmt = con.createStatement();

            // Código para crear una tabla llamada "figuras" si no existe
            String createSql = "DROP TABLE IF EXISTS FIGURAS; " +
                    "CREATE TABLE FIGURAS (ID INT PRIMARY KEY, FIGURA VARCHAR(255), COLOR VARCHAR(255));";
            stmt.execute(createSql); //La ejecución con stmt.execute(createSql); envía este SQL al motor de base de datos para ser ejecutado.

            // Insertar figuras en la tabla
            String insertSql = "INSERT INTO FIGURAS VALUES(1, 'Círculo', 'Rojo'); " +
                    "INSERT INTO FIGURAS VALUES(2, 'Círculo', 'Azul'); " +
                    "INSERT INTO FIGURAS VALUES(3, 'Cuadrado', 'Verde'); " +
                    "INSERT INTO FIGURAS VALUES(4, 'Cuadrado', 'Rojo'); " +
                    "INSERT INTO FIGURAS VALUES(5, 'Cuadrado', 'Amarillo');";
            stmt.execute(insertSql);

            // Realizar una consulta para ver las figuras de color Rojo
            String selectSql = "SELECT * FROM FIGURAS WHERE COLOR = 'Rojo';";
            ResultSet rs = stmt.executeQuery(selectSql);

            // Mostrar las figuras con color Rojo
            System.out.println("Figuras de color Rojo:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID") + ", Figura: " + rs.getString("FIGURA") + ", Color: " + rs.getString("COLOR"));
            }

            // Mostrar todas las figuras en la tabla
            System.out.println("\nTodas las figuras:");
            selectSql = "SELECT * FROM FIGURAS";
            rs = stmt.executeQuery(selectSql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID") + ", Figura: " + rs.getString("FIGURA") + ", Color: " + rs.getString("COLOR"));
            }

            // Cerrar la conexión
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}