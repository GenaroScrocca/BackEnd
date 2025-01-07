public class ServicioDescargaReal implements ServicioDescarga{
    @Override
    public void descargar(String cancion, Usuario usuario){
        System.out.println("Descargando la cancion: " + cancion + " para el usuario: " + usuario.getId()) ;

    }
}
