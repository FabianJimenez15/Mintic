package com.MinTicCiclo3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MinTicCiclo3.Model.Client;
import com.MinTicCiclo3.Repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> obtenerClientCompleta() {
        return clientRepository.obtenerClientCompleta();
    }

    public Optional<Client> obtenerClientId(Integer id) {
        return clientRepository.obtenerClientId(id);
    }

    public Client salvarClient(Client client) {
        if (client.getId() == null) {
            return clientRepository.salvarClient(client);
        } else {
            Optional<Client> clientAuxiliar = clientRepository.obtenerClientId(client.getId());
            if (clientAuxiliar.isEmpty()) {
                return clientRepository.salvarClient(client);
            } else {
                return client;
            }

        }
    }
    // JPQL

    public List<Client> obtenerClientCompletaJPQL() {
        return clientRepository.obtenerClientCompletaJPQL();
    }

}
