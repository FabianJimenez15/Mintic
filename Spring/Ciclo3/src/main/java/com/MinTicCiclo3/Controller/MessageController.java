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

import com.MinTicCiclo3.Model.Message;
import com.MinTicCiclo3.Service.MessageService;



@RestController
@RequestMapping("/api/mensaje")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/mensajeCompleta")
    public List<Message> obtenerMessageCompleta() {
        return messageService.obtenerMessageCompleta();
    }

    @GetMapping("/{id}")
    public Optional<Message> obtenerMessageId(@PathVariable("id") Integer identificador) {
        return messageService.obtenerMessageId(identificador);
    }

    @PostMapping("salvarMensaje")
    @ResponseStatus( HttpStatus.CREATED)
    public Message salvarMessage(@RequestBody Message message) {
        return messageService.salvarMessage(message);

    }

    // Consultas personalizadas
    @GetMapping("/mensajeCompleta/jpql")
    public List<Message> obtenerMessageCompletaJPQL() {
        return messageService.obtenerMessageCompletaJPQL();
    }
}
