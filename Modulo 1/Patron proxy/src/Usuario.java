public class Usuario {
    private String id;
    private TipoUsuario tipo;

    public Usuario(String id, TipoUsuario tipo){
        this.id= id;
        this.tipo= tipo;
    }

    public String getId() {
        return id;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }
}
