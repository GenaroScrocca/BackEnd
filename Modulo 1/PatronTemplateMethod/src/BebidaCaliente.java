public abstract class BebidaCaliente {
    //template method: el algoritmo general
    public final void prepararReceta(){
        hervirAgua();
        agregarIngredientes(); //paso personalidad (metodo abstracto)
        servir();
    }
    //Paso comun a todas las subclases
    private void hervirAgua(){
        System.out.println("Hiriviendo agua..");
    }
    //metodo abstracto que las subclases implementaran
    protected abstract void agregarIngredientes();

    //Paso comun a todas las subclases
    private void servir(){
        System.out.println("Sirviendo en la taza..");
    }
}
