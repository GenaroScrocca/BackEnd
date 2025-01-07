import java.util.HashMap;
import java.util.Map;
public class ArbolFactory {
    private static final Map<String, Arbol> arboles= new HashMap<>();
    public static Arbol obtenerArbol(String tipo){
        if(!arboles.containsKey(tipo)){
            switch (tipo){
                case "Ornamental":
                    arboles.put(tipo, new Arbol(200,400,"verde",tipo));
                    break;
                case "Frutal":
                    arboles.put(tipo, new Arbol(500,300,"rojo", tipo));
                    break;
                case "Floral":
                    arboles.put(tipo, new Arbol(100,200,"celeste", tipo));
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de arbol no reconocido");
            }
        }
        return arboles.get(tipo);
    }
}
