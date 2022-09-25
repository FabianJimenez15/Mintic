package com.MinTicCiclo3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MinTicCiclo3.Model.Mensaje;
import com.MinTicCiclo3.Repository.Crud.MensajeCrudRepository;


@Repository
public class MensajeRepository {
    

    @Autowired
    private MensajeCrudRepository mensajeCrudRepository;

    public List<Mensaje> obtenerMensajeCompleta() {
        return (List<Mensaje>) mensajeCrudRepository.findAll();
    }

    public Optional<Mensaje> obtenerMensajeId(Integer id) {
        return mensajeCrudRepository.findById(id);
    }

    public Mensaje salvarMensaje(Mensaje mensaje) {
        return mensajeCrudRepository.save(mensaje);
    }

    // Uso JPQL Java Persitence Query Language

    public List<Mensaje> obtenerMensajeCompletaJPQL() {
        return mensajeCrudRepository.obtenerMensajeCompletaJPQL();
    }

}
