package com.prepreguntas.service;

import java.util.List;

public interface BaseServices<E>  {

    // CREAMOS LOS METODOS COMUNES QUE SE USAN EN CADA ENTIDAD, (CRUD)

    public List<E> findAll();     //Buscar o encontrar todos los registros.
    public E findById(int id);   //Encontrar por id.
    public E saveOne(E entity);   //Guardad o registrar un objeto Entidad.
    public E updateOne(E entity,int id); //Actualizar un registro.
    public void deleteById(int id);   //Eliminar un _Registro.

}
