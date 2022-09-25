/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MinTicCiclo3.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Dan
 */
@Entity
@Table(name="cliente")
public class Cliente {
           @Id
           @GeneratedValue(strategy = GenerationType.IDENTITY)
           private Integer id;
           private String nombre;
           private  String email;
           private Integer edad;
           
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public Integer getEdad() {
            return edad;
        }
        public void setEdad(Integer edad) {
            this.edad = edad;
        }

   
    
}
