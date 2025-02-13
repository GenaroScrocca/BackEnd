import org.apache.log4j.Logger; //importamos clase Logger de la biblioteca Log4j

public class Tigre {
    private static final Logger logger= Logger.getLogger(Tigre.class);
    //static ahce que el logger sea unico y compartido para todas las instancias de la clase. De esta forma no se necesita crear un logger para cada objeto
    //final que la referencia al logger no pueda cambiar una vez inicializada.
    private String nombre;
    private int edad;

    //METODO CONSTRUCTOR
    public Tigre(String nombre, int edad){
        if(edad<0){
            logger.error("La edad no puede ser negativa para el tigre" + nombre);
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        this.nombre= nombre;
        this.edad= edad;
        logger.info("Tigre creado con nombre: " + nombre+ " y edad: " + edad );
    }
    //METODO CORRER
    public void correr() {
        logger.info("El Tigre " + nombre + " está corriendo");
    }

   //METODO void esMayor
    public void esMayorA10() throws Exception {
        if (edad < 0) {
            logger.error("La edad no puede ser negativa para el tigre: " + nombre);
            throw new Exception("La edad no puede ser negativa");
        }
        if (edad > 10) {
            logger.info("El Tigre " + nombre + " tiene más de 10 años");
        }
    }


}
