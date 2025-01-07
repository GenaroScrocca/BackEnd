public class Animal {
    private String tipo; //caballo,perro,gato
    private String tamaño; //grande, mediano, chico
    private int peso;

    public Animal(String tipo, String tamaño, int peso){ //Constructor
        this.tipo= tipo;
        this.tamaño= tamaño;
        this.peso= peso;
    }
    //Getters y setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    public boolean esPesado(){
        return this.peso > 2000 && this.tamaño.equals("grande");

    }

}
