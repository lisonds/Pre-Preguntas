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
    public List<Publicacion> findAll() throws Exception {
        try {
            List<Publicacion> listPublicacion=this.publicacionDao.findAll();
            return listPublicacion;

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Publicacion findById(int id) throws Exception {
        try {
            Optional<Publicacion> opt=this.publicacionDao.findById(id);
            return opt.get();

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Publicacion saveOne(Publicacion entity) throws Exception {
        try {
            Publicacion publicacion=this.publicacionDao.save(entity);
            return publicacion;

        } catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional(readOnly = true)
    public Publicacion updateOne(Publicacion entity, int id) throws Exception {
        try {
            Optional<Publicacion> opt = this.publicacionDao.findById(id);
            Publicacion publicacion = opt.get();
            publicacion=this.publicacionDao.save(entity);
            return publicacion;

        } catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    @Transactional
    public void deleteById(int id) throws Exception {
        try {
            this.publicacionDao.deleteById(id);

        } catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }
}
