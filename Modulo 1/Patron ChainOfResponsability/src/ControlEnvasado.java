public class ControlEnvasado extends ControlCalidad {
    @Override
    public void verificar(Articulo articulo){
        if(articulo.getEnvasado().equals("sano") || articulo.getEnvasado().equals("casi sano")){
            System.out.println("El articulo ha pasado todos los controles. ¡Aceptado!");
        }
    }
}
