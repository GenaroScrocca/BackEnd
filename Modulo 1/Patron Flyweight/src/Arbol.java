public class Arbol {
    private final int alto; //final --> la variable no puede ser modificada despues de instanciada
    private final int ancho;
    private final String color;
    private final String tipo;

    public Arbol(int alto, int ancho, String color, String tipo) {
        this.alto = alto;
        this.ancho = ancho;
        this.color = color;
        this.tipo = tipo;
    }

    public void mostrar(int x,int y){
        System.out.println("Arbol[tipo=" + tipo+ ", color= " + color + "] en posicion (" + x + ", " + y + ")");
    }
}
