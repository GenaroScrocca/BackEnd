public class Main {
    public static void main(String[]args){
        //Crear articulo
        Articulo articulo= new Articulo("ProductoX", 1500, 1250, "sano");

        //crear analista de calidad
        AnalistaDeCalidad analista= new AnalistaDeCalidad();

        //validar calidad del control
        analista.validarCalidadDelProducto(articulo);
    }
}
