package com.implementaciondao.daos;

import java.util.List;

public interface Idao <T>  { //Recibe como parametro el tipo

        //METODOS DE LA INTERFAZ
        public T guardar( T t); //El tipo puede ser estudiante, curso, etc. depende la identidad
        public void eliminar(Long id);
        public T buscar(Long id);
        public List<T> buscarTodos();


}
