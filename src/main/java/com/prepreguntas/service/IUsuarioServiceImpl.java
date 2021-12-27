package com.prepreguntas.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prepreguntas.DAO.IUsuarioDao;
import com.prepreguntas.entity.Usuario;

@Service
public class IUsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDao.findAll();
	}
	
	@Override
	@Transactional
	public void Guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioDao.save(usuario);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public Usuario findOne(int id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id).orElse(null);
	}
	
	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		usuarioDao.deleteById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Usuario> busrcarEmail(String correo) {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDao.findByCorreo(correo);
	}

	

	
	

}
