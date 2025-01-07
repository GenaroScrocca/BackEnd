import java.util.ArrayList;
import java.util.List;
public class Bosque {
    private final List<ArbolPlantado> arbolesPlantados= new ArrayList<>();
    public void plantarArbol(int x,int y, String tipo){
        Arbol arbol= ArbolFactory.obtenerArbol(tipo);
        arbolesPlantados.add(new ArbolPlantado(arbol,x,y));
    }
    public void mostrar(){
        for(ArbolPlantado arbolPlantado : arbolesPlantados){
            arbolPlantado.mostrar();
        }
    }
    private static class ArbolPlantado {
        private final Arbol arbol;
        private final int x;
        private final int y;

        public ArbolPlantado(Arbol arbol, int x, int y) {
            this.arbol = arbol;
            this.x = x;
            this.y = y;
        }

        public void mostrar() {
            arbol.mostrar(x, y);
        }
    }
}
