package com.MinTicCiclo3.Repository;

import com.MinTicCiclo3.Model.Cliente;
import com.MinTicCiclo3.Repository.Crud.ClienteCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository {
    
 @Autowired   
 private ClienteCrudRepository clienteCrudRepository; 
    
   public List <Cliente> obtenerClienteCompleta(){
        return  (List<Cliente>) clienteCrudRepository.findAll();
   } 
    
   public Optional <Cliente> obtenerClienteId(Integer id){
         return clienteCrudRepository.findById(id);
   }
   
   public Cliente salvarCliente(Cliente cliente){
        return  clienteCrudRepository.save(cliente);
   }
   
}
