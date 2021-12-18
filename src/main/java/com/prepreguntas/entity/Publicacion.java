package com.prepreguntas.entity;

import javax.persistence.*;

@Entity
@Table(name = "publicaciones")
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPublicacion;
    private String contenido;
    private String imagen;
    private String fechaPublicacion;

    public Publicacion(){

    }

    public Publicacion(int idPublicacion, String contenido, String imagen, String fechaPublicacion) {
        this.idPublicacion = idPublicacion;
        this.contenido = contenido;
        this.imagen = imagen;
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

}

