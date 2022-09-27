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
@Table(name = "skates")
public class skates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer yearb;
    private String description;
    // private Integer Categoria_id;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties({ "skates" })
    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearb() {
        return yearb;
    }

    public void setYearb(Integer yearb) {
        this.yearb = yearb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    


    // public Integer getCategoria_id() {
    // return Categoria_id;
    // }
    // public void setCategoria_id(Integer categoria_id) {
    // Categoria_id = categoria_id;
    // }

}
