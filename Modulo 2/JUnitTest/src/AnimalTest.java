import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    public void siElAnimalEsPesado(){
        Animal caballo= new Animal("caballo", "grande", 2001);
        Animal perro= new Animal("perro", "mediano", 20);

        boolean esPesado= caballo.esPesado(); //preguntamos si el cabllo es pesado.
        boolean esPesado1= perro.esPesado(); // preguntamos si el perro es pesado

        assertEquals(true, caballo.esPesado());
        assertFalse(esPesado1);
    }
}