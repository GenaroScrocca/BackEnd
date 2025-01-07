public class Main {
    public static void main(String[]args){
        //Crear usuarios
        Usuario usuarioFree= new Usuario("User123", TipoUsuario.FREE);
        Usuario usuarioPremium= new Usuario("User456", TipoUsuario.PREMIUM);

        //Crear proxy del servicio de descarga
        ServicioDescarga servicioDescarga= new ServicioDescargaProxy();

        //Probar descargas
        System.out.println("Intento de descarga por usuario FREE: ");
        servicioDescarga.descargar("Cancion 1", usuarioFree);

        System.out.println("\nIntento de descarga por usuario PREMIUM: ");
        servicioDescarga.descargar("Cancion 2", usuarioPremium);
    }
}
