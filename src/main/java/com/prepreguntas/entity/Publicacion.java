package com.prepreguntas.entity;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "publicaciones")
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publicacion")
    private int idPublicacion;
    private String contenido;
    private String imagen;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_publicacion")
    private Date fechaPublicacion;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="fk_usuario", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "publicacion")
    private List<Comentario> comentario;

    public Publicacion(){

    }

	@PrePersist
	public void prePersist() {
		fechaPublicacion=new Date();
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

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

