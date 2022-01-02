package com.prepreguntas.DAO;

import com.prepreguntas.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoDao extends JpaRepository<Producto,Integer> {

}
