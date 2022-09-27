package com.MinTicCiclo3.Service;

import com.MinTicCiclo3.Model.Client;
import com.MinTicCiclo3.Repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ClientService {
    
    @Autowired
    private ClientRepository  clienteRepository;
    
    public List<Client> obtenerClienteCompleta(){
        return clienteRepository.obtenerClienteCompleta();
    }
    
    public Optional <Client> obtenerClienteId(Integer id){
        return clienteRepository.obtenerClienteId(id);
    }
    
    public  Client salvarCliente(Client cliente){
        if (cliente.getId()== null){
           return clienteRepository.salvarCliente(cliente);
        }else{
         Optional<Client> clienteAuxiliar = clienteRepository.obtenerClienteId(cliente.getId());
            if(clienteAuxiliar.isEmpty()){
                return clienteRepository.salvarCliente(cliente);
        }else{
               return cliente; 
                }
    
    }
}
}