package com.MinTicCiclo3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MinTicCiclo3.Model.Message;
import com.MinTicCiclo3.Repository.Crud.MessageCrudRepository;


@Repository
public class MessageRepository {
    

    @Autowired
    private MessageCrudRepository mensajeCrudRepository;

    public List<Message> obtenerMensajeCompleta() {
        return (List<Message>) mensajeCrudRepository.findAll();
    }

    public Optional<Message> obtenerMensajeId(Integer id) {
        return mensajeCrudRepository.findById(id);
    }

    public Message salvarMensaje(Message mensaje) {
        return mensajeCrudRepository.save(mensaje);
    }

    // Uso JPQL Java Persitence Query Language

    public List<Message> obtenerMensajeCompletaJPQL() {
        return mensajeCrudRepository.obtenerMensajeCompletaJPQL();
    }

}
