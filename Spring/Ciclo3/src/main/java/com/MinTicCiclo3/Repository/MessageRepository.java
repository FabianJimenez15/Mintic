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
    private MessageCrudRepository messageCrudRepository;

    public List<Message> obtenerMessageCompleta() {
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> obtenerMessageId(Integer id) {
        return messageCrudRepository.findById(id);
    }

    public Message salvarMessage(Message message) {
        return messageCrudRepository.save(message);
    }

    // Uso JPQL Java Persitence Query Language

    public List<Message> obtenerMessageCompletaJPQL() {
        return messageCrudRepository.obtenerMessageCompletaJPQL();
    }
}
