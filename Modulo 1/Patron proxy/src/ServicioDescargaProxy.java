public class ServicioDescargaProxy implements ServicioDescarga{
    private ServicioDescargaReal servicioReal;

    public ServicioDescargaProxy(){
        this.servicioReal= new ServicioDescargaReal();
    }
    @Override
    public void descargar(String cancion, Usuario usuario){
        if(usuario.getTipo() == TipoUsuario.PREMIUM){
            servicioReal.descargar(cancion,usuario);
        }else{
            System.out.print("Acceso denegado. La descarga esta disponible solo para usuario premium");
        }
    }
}
