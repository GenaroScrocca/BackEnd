import javax.naming.ldap.Control;

public abstract class ControlCalidad {
    protected ControlCalidad siguienteControl; //atributo que mantiene referencia al siguiente eslabon de la cadena
    // protected --> significa que solo las clases que hereden a esta pueden modificar al atributo

    public void setSiguienteControl(ControlCalidad siguienteControl){ //Configura el siguiente control de la cadena. Establece quien  sera el proximo en recibir la solicitud
        this.siguienteControl= siguienteControl;
    }
   //el parametro representa el siguiente objeto en la cadena de responsabilidad.

    public abstract void verificar (Articulo articulo); //este metodo abstracto sera usado por las subclases para verificar el articulo segun su criterio especifico (lote,peso,envasado,etc).
}
