package com.MinTicCiclo3.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="categoria")
public class Categoria {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id;
    private String Nombre;
    private String Descripcion;

    @OneToMany(mappedBy = "categoria") 
    @JsonIgnoreProperties({"categoria"}) 
    private List<Patineta> patineta;

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
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
    public List<Patineta> getPatineta() {
        return patineta;
    }
    public void setPatineta(List<Patineta> patineta) {
        this.patineta = patineta;
    }

    
}
