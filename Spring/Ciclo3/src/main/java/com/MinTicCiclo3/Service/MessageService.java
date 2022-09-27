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
    private MessageRepository mensajeRepository;

    public List<Message> obtenerMensajeCompleta() {
        return mensajeRepository.obtenerMensajeCompleta();
    }

    public Optional<Message> obtenerMensajeId(Integer id) {
        return mensajeRepository.obtenerMensajeId(id);
    }

    public Message salvarMensaje(Message mensaje) {
        if (mensaje.getId() == null) {
            return mensajeRepository.salvarMensaje(mensaje);
        } else {

            Optional<Message> mensajeAuxiliar = mensajeRepository.obtenerMensajeId(mensaje.getId());
            if (mensajeAuxiliar.isEmpty()) {
                return mensajeRepository.salvarMensaje(mensaje);
            } else {
                return mensaje;
            }
        }

    }
    // JPQL

    public List<Message> obtenerMensajeCompletaJPQL() {
        return mensajeRepository.obtenerMensajeCompletaJPQL();
    }
}
