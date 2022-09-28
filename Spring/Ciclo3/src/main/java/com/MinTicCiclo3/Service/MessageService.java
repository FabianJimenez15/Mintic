package com.MinTicCiclo3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MinTicCiclo3.Model.Message;
import com.MinTicCiclo3.Repository.MessageRepository;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> obtenerMessageCompleta() {
        return messageRepository.obtenerMessageCompleta();
    }

    public Optional<Message> obtenerMessageId(Integer id) {
        return messageRepository.obtenerMessageId(id);
    }

    public Message salvarMessage(Message message) {
        if (message.getId() == null) {
            return messageRepository.salvarMessage(message);
        } else {

            Optional<Message> messageAuxiliar = messageRepository.obtenerMessageId(message.getId());
            if (messageAuxiliar.isEmpty()) {
                return messageRepository.salvarMessage(message);
            } else {
                return message;
            }
        }

    }
    // JPQL

    public List<Message> obtenerMessageCompletaJPQL() {
        return messageRepository.obtenerMessageCompletaJPQL();
    }
}
