package com.prepreguntas.service;

import com.prepreguntas.DAO.IPublicacionDao;
import com.prepreguntas.entity.Publicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

public class PublicacionService implements BaseServices<Publicacion> {

    @Autowired
    private IPublicacionDao publicacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Publicacion> findAll(){
        List<Publicacion> listPublicacion=this.publicacionDao.findAll();
        return listPublicacion;

    }

    @Override
    @Transactional(readOnly = true)
    public Publicacion findById(int id){
        Optional<Publicacion> opt=this.publicacionDao.findById(id);
        return opt.get();

    }

    @Override
    @Transactional(readOnly = true)
    public Publicacion saveOne(Publicacion entity){
        Publicacion publicacion=this.publicacionDao.save(entity);
        return publicacion;

    }

    @Override
    @Transactional(readOnly = true)
    public Publicacion updateOne(Publicacion entity, int id){
        Optional<Publicacion> opt = this.publicacionDao.findById(id);
        Publicacion publicacion = opt.get();
        publicacion=this.publicacionDao.save(entity);
        return publicacion;

    }

    @Override
    @Transactional
    public void deleteById(int id){
        this.publicacionDao.deleteById(id);

    }

    @Override
    public Optional<Publicacion> get(int id) {
        return publicacionDao.findById(id);
    }
}
