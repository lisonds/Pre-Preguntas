package com.prepreguntas.entity;

import javax.persistence.*;

@Entity
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;
    private String contenido;
    private String fechaCreacion;
    private String imagen;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_publicacion", nullable = false)
    private Publicacion publicacion;

    public Comentario() {

    }

    public Comentario(int idComentario, String contenido, String fechaCreacion, String imagen) {
        this.idComentario = idComentario;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.imagen = imagen;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
