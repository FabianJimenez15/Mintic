package com.MinTicCiclo3.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Dan
 */
@Entity
@Table(name="client")
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private Integer password;
    private String name;
    private Integer age;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    @JsonIgnoreProperties("client")
    public List<Message> message;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    @JsonIgnoreProperties("client")
    public List<Reservation> reservation;

    
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getPassword() {
        return password;
    }
    public void setPassword(Integer password) {
        this.password = password;
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
    
    

    

}
