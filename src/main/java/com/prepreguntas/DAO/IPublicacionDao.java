package com.prepreguntas.DAO;

import com.prepreguntas.entity.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPublicacionDao extends JpaRepository<Publicacion, Integer>{

}
