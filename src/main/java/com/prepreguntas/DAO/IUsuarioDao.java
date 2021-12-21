package com.prepreguntas.DAO;

import java.util.List;

import com.prepreguntas.entity.Usuario;

public interface IUsuarioDao {
	public List<Usuario> findAll();
}
