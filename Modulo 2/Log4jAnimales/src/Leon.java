import org.apache.log4j.Logger;

public class Leon {
    private static final Logger logger= Logger.getLogger(Leon.class); //Este logger es una instancia de la clase Logger proporcionada por la biblioteca Log4j, que se utiliza para registrar mensajes en los niveles de log que elijas
    private String nombre;
    private int edad;
    private boolean esAlfa;

   //CONSTRUCTOR
    public Leon(String nombre, int edad, boolean esAlfa) {
        if(edad<0){
            logger.error("La edad no puede ser negativa para el leon: " + nombre);
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        this.nombre = nombre;
        this.edad = edad;
        this.esAlfa = esAlfa;
        logger.info("El leon " + nombre + ", Edad: " + edad + ", Es alfa: "+ esAlfa);
    }

    //METODO CORRER
    public void correr(){
        logger.info("El leon: "+nombre+ " esta corriendo");
    }

    public void esMayorA10() throws Exception{
        if (edad<0){
            logger.error("La edad no puede ser negativa para el leon: "+ nombre);
            throw new Exception("La edad no puede ser negativa");
        }
        if (edad >10 && esAlfa){
            logger.info("El leon " +nombre+ " tiene mas de 10 años y es alfa");
        }
    }
}
