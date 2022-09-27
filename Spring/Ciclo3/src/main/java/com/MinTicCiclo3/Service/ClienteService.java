package com.MinTicCiclo3.Service;

import com.MinTicCiclo3.Model.Cliente;
import com.MinTicCiclo3.Repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository  clienteRepository;
    
    public List<Cliente> obtenerClienteCompleta(){
        return clienteRepository.obtenerClienteCompleta();
    }
    
    public Optional <Cliente> obtenerClienteId(Integer id){
        return clienteRepository.obtenerClienteId(id);
    }
    
    public  Cliente salvarCliente(Cliente cliente){
        if (cliente.getId()== null){
           return clienteRepository.salvarCliente(cliente);
        }else{
         Optional<Cliente> clienteAuxiliar = clienteRepository.obtenerClienteId(cliente.getId());
            if(clienteAuxiliar.isEmpty()){
                return clienteRepository.salvarCliente(cliente);
        }else{
               return cliente; 
                }
    
    }
}
}