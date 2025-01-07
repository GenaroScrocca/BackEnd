public class AnalistaDeCalidad {
    private ControlCalidad cadena;

    public AnalistaDeCalidad(){
        //Configuracion de la cadena de responsabilidad
        this.cadena= new ControlLote();
        ControlCalidad controlPeso= new ControlPeso();
        ControlCalidad controlEnvasado= new ControlEnvasado();

        cadena.setSiguienteControl(controlPeso);
        controlPeso.setSiguienteControl(controlEnvasado);
    }
    public void validarCalidadDelProducto(Articulo articulo){ //se inicia la cadena
        cadena.verificar(articulo);
    }
}
