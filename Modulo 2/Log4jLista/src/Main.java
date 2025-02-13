
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ListaPromedio listaPromedio = new ListaPromedio();

        try {
            // Lista con más de 5 elementos
            listaPromedio.procesarLista(Arrays.asList(1, 2, 3, 4, 5, 6));

            // Lista con más de 10 elementos
            listaPromedio.procesarLista(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));

            // Lista vacía (esto lanza una excepción)
            listaPromedio.procesarLista(Arrays.asList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}