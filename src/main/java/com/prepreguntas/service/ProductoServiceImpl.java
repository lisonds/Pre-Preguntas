package com.prepreguntas.service;

import com.prepreguntas.DAO.IProductoDao;
import com.prepreguntas.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements BaseServices<Producto>{

    @Autowired
    private IProductoDao productoDao;

    @Override
    public List<Producto> findAll() {
        List<Producto> productos = productoDao.findAll();
        return productos;
    }

    @Override
    public Producto findById(int id) {
        Optional<Producto> optionalProducto = productoDao.findById(id);
        return optionalProducto.get();
    }

    @Override
    public Producto saveOne(Producto product) {
        Producto producto = productoDao.save(product);
        return producto;
    }

    @Override
    public Producto updateOne(Producto product, int id) {
        Optional<Producto> optProducto = productoDao.findById(id);
        Producto producto = optProducto.get();
        producto = productoDao.save(product);
        return producto;
    }

    @Override
    public void deleteById(int id) {
        productoDao.deleteById(id);
    }
}
