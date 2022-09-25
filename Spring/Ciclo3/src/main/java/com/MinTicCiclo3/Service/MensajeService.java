package com.MinTicCiclo3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MinTicCiclo3.Model.Mensaje;
import com.MinTicCiclo3.Repository.MensajeRepository;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    public List<Mensaje> obtenerMensajeCompleta() {
        return mensajeRepository.obtenerMensajeCompleta();
    }

    public Optional<Mensaje> obtenerMensajeId(Integer id) {
        return mensajeRepository.obtenerMensajeId(id);
    }

    public Mensaje salvarMensaje(Mensaje mensaje) {
        if (mensaje.getId() == null) {
            return mensajeRepository.salvarMensaje(mensaje);
        } else {

            Optional<Mensaje> mensajeAuxiliar = mensajeRepository.obtenerMensajeId(mensaje.getId());
            if (mensajeAuxiliar.isEmpty()) {
                return mensajeRepository.salvarMensaje(mensaje);
            } else {
                return mensaje;
            }
        }

    }
    // JPQL

    public List<Mensaje> obtenerMensajeCompletaJPQL() {
        return mensajeRepository.obtenerMensajeCompletaJPQL();
    }
}
