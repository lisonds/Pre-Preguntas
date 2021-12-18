package com.prepreguntas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prepreguntas.entity.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
