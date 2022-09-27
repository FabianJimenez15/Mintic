package com.MinTicCiclo3.Repository;

import com.MinTicCiclo3.Model.Client;
import com.MinTicCiclo3.Repository.Crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {
    
 @Autowired   
 private ClientCrudRepository clienteCrudRepository; 
    
   public List <Client> obtenerClienteCompleta(){
        return  (List<Client>) clienteCrudRepository.findAll();
   } 
    
   public Optional <Client> obtenerClienteId(Integer id){
         return clienteCrudRepository.findById(id);
   }
   
   public Client salvarCliente(Client cliente){
        return  clienteCrudRepository.save(cliente);
   }
   
}
