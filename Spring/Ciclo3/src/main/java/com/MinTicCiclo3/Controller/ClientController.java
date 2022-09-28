package com.MinTicCiclo3.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.MinTicCiclo3.Model.Client;
import com.MinTicCiclo3.Service.ClientService;


@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    @GetMapping("/clientcompleta") // http://localhost:8080/api/cliente/clientecompleta
    public List<Client> obtenerClientCompleta() {
        return clientService.obtenerClientCompleta();
    }
        
    @GetMapping("/{id}")  // http://localhost:8080/api/cliente/id
    public Optional<Client> obtenerClientId(@PathVariable("id") Integer Identificador) {
        return clientService.obtenerClientId(Identificador);
    }
    
        
    @PostMapping("salvarclient") // http://localhost:8080/api/cliente/salvarcliente
    @ResponseStatus(HttpStatus.CREATED)
    public Client salvarClient(@RequestBody Client client) {
        return clientService.salvarClient(client);
    }

}
