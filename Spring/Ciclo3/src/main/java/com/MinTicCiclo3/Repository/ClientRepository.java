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
     private ClientCrudRepository clientCrudRepository;
 
     public List<Client> obtenerClientCompleta() {
         return (List<Client>) clientCrudRepository.findAll();
     }
 
     public Optional<Client> obtenerClientId(Integer id) {
         return clientCrudRepository.findById(id);
     }
 
     public Client salvarClient(Client client) {
         return clientCrudRepository.save(client);
     }
 
   
 

}
