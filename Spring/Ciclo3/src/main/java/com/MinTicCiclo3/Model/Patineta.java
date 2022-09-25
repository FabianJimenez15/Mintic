package com.MinTicCiclo3.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "patineta")
public class Patineta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Nombre;
    private Integer Año;
    private String Descripcion;
    // private Integer Categoria_id;

    @ManyToOne
    @JoinColumn(name = "categoriaId")
    @JsonIgnoreProperties({ "patineta" })
    private Categoria categoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Integer getAño() {
        return Año;
    }

    public void setAño(Integer año) {
        Año = año;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // public Integer getCategoria_id() {
    // return Categoria_id;
    // }
    // public void setCategoria_id(Integer categoria_id) {
    // Categoria_id = categoria_id;
    // }

}
