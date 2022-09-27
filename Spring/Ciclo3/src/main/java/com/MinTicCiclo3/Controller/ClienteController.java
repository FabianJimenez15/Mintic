package com.MinTicCiclo3.Controller;

import com.MinTicCiclo3.Model.Cliente;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.MinTicCiclo3.Service.ClienteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientecompleta") // http://localhost:8080/api/cliente/clientecompleta
    public List<Cliente> obtenerClienteCompleta() {
        return clienteService.obtenerClienteCompleta();
    }
        
    @GetMapping("/{id}")  // http://localhost:8080/api/cliente/id
    public Optional<Cliente> obtenerClienteId(@PathVariable("id") Integer Identificador) {
        return clienteService.obtenerClienteId(Identificador);
    }
    
        
    @PostMapping("salvarcliente") // http://localhost:8080/api/cliente/salvarcliente
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvarCliente(@RequestBody Cliente cliente) {
        return clienteService.salvarCliente(cliente);
    }

}
