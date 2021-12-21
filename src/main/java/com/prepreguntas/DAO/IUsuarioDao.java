package com.prepreguntas.DAO;

import java.util.List;

import com.prepreguntas.entity.Usuario;

public interface IUsuarioDao {
	/*IMPLEMENTAR PARA MOSTRAR*/
	public List<Usuario> findAll();
	
	
	/*IMPLEMENTAR PARA GUARDA*/
	
	public void Guardar(Usuario usuario);
	
	/*implementar para editar busqueda de uno solo por id*/
	public Usuario BuscarID(int id);
	
	/*IMPLEMENTAR ELIMINAR*/
	public void delete(int id);
}
