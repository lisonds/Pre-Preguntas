package com.prepreguntas.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import java.util.List;


@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    private String nombre;
    @NotEmpty
    @Email
    private String correo;
    @NotEmpty
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<Publicacion> publicacion;

    public Usuario(){

    }

    public Usuario(int id, String nombre, String correo, String password, List<Publicacion> publicacion) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.publicacion = publicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Publicacion> getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(List<Publicacion> publicacion) {
        this.publicacion = publicacion;
    }
}


