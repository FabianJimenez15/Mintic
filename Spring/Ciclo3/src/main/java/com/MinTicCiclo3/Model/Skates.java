package com.MinTicCiclo3.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "skates")
public class Skates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private Integer yearb; // error con variable year
    private String description;
    private String name;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties({ "skates" })
    private Category category;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "skates")
    @JsonIgnoreProperties({ "skates", "client" })
    private List<Message> message;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "skates")
    @JsonIgnoreProperties({ "skates", "message" })
    private List<Reservation> reservation;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }
/*
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;*/
    }
    

    

    // df


