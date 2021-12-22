package com.prepreguntas.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.prepreguntas.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Integer> {
	/*esto es para buscar el correo en el usuario 
	 en base de datos  SELECT * FROM USUARIO WHERE CORREO=VARIABLE*/
	
	List<Usuario> findByCorreo(String correo); 
	
}
