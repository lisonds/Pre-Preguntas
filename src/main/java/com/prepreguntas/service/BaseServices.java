package com.prepreguntas.service;

import java.util.List;

public interface BaseServices<E>  {

    // CREAMOS LOS METODOS COMUNES QUE SE USAN EN CADA ENTIDAD, (CRUD)

    public List<E> findAll() throws Exception;     //Buscar o encontrar todos los registros.
    public E findById(int id) throws Exception;   //Encontrar por id.
    public E saveOne(E entity) throws Exception;   //Guardad o registrar un objeto Entidad.
    public E updateOne(E entity,int id) throws Exception; //Actualizar un registro.
    public void deleteById(int id) throws Exception;   //Eliminar un _Registro.

}
