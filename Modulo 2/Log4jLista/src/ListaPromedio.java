
import org.apache.log4j.Logger;

import java.util.List;

public class ListaPromedio {
    private static final Logger logger = Logger.getLogger(ListaPromedio.class);

    public void procesarLista(List<Integer> listaEnteros) throws Exception {
        if (listaEnteros.isEmpty()) {
            logger.error("La lista no tiene elementos");
            throw new Exception("La lista está vacía.");
        }

        // Log de longitud
        if (listaEnteros.size() > 5) {
            logger.info("La longitud de la lista es mayor a 5");
        }
        if (listaEnteros.size() > 10) {
            logger.info("La longitud de la lista es mayor a 10");
        }

        // Calcular promedio
        double promedio = listaEnteros.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        logger.info("El promedio es: " + promedio);

        // Calcular máximo y mínimo
        int max = listaEnteros.stream().mapToInt(Integer::intValue).max().orElse(Integer.MIN_VALUE);
        int min = listaEnteros.stream().mapToInt(Integer::intValue).min().orElse(Integer.MAX_VALUE);

        logger.info("El valor máximo es: " + max);
        logger.info("El valor mínimo es: " + min);
    }
}