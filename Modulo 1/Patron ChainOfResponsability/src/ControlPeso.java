public class ControlPeso extends ControlCalidad{
    @Override
    public void verificar(Articulo articulo){
        if(articulo.getPeso() >= 1200 && articulo.getPeso() <= 1300){
            if(siguienteControl != null){
                siguienteControl.verificar(articulo);
            }
        }else{
            System.out.println("El peso es invalido. Articulo rechazado.");
        }
    }
}
