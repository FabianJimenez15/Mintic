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

import com.MinTicCiclo3.Model.Mensaje;
import com.MinTicCiclo3.Service.MensajeService;



@RestController
@RequestMapping("/api/mensaje")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class MensajeController {
    
    @Autowired
    private MensajeService mensajeService;

    @GetMapping("/mensajeCompleta")
    public List<Mensaje> obtenerMensajeCompleta() {
        return mensajeService.obtenerMensajeCompleta();
    }

    @GetMapping("/{id}")
    public Optional<Mensaje> obtenerMensajeId(@PathVariable("id") Integer identificador) {
        return mensajeService.obtenerMensajeId(identificador);
    }

    @PostMapping("salvarMensaje")
    @ResponseStatus( HttpStatus.CREATED)
    public Mensaje salvarMensaje(@RequestBody Mensaje mensaje) {
        return mensajeService.salvarMensaje(mensaje);

    }

    // Consultas personalizadas
    @GetMapping("/mensajeCompleta/jpql")
    public List<Mensaje> obtenerMensajeCompletaJPQL() {
        return mensajeService.obtenerMensajeCompletaJPQL();
    }

}
