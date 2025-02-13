    import org.apache.log4j.Logger;

    public class Main {
        private static final Logger logger = Logger.getLogger(Main.class);

        public static void main(String[] args) {
            try {
                Leon simba = new Leon("Simba", 12, true);
                simba.correr();
                simba.esMayorA10();

                Leon bom = new Leon("Bom", -5, false); // Esto lanzará una excepción
                bom.correr();
                bom.esMayorA10();
            } catch (Exception e) {
                logger.error("Error al procesar el león: " + e.getMessage());
            }

            try {
                Tigre shereKhan = new Tigre("Shere Khan", 15);
                shereKhan.correr();
                shereKhan.esMayorA10();

                Tigre rajah = new Tigre("Rajah", 8);
                rajah.correr();
                rajah.esMayorA10();
            } catch (Exception e) {
                logger.error("Error al procesar el tigre: " + e.getMessage());
            }
        }
    }