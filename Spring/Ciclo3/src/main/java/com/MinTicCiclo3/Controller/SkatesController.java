package com.MinTicCiclo3.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.MinTicCiclo3.Model.skates;
import com.MinTicCiclo3.Service.SkatesService;

@RestController
@RequestMapping("/api/patineta")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class SkatesController {

    @Autowired
    private SkatesService patinetaService;

    @GetMapping("/patinetaCompleta")
    public List<skates> obtenerPatinetaCompleta() {
        return patinetaService.obtenerPatinetaCompleta();
    }

    @GetMapping("/{id}")
    public Optional<skates> obtenerPatinetaId(@PathVariable("id") Integer identificador) {
        return patinetaService.obtenerPatinetaId(identificador);
    }

    @PostMapping("salvarPatineta")
    @ResponseStatus(HttpStatus.CREATED)
    public skates salvarPatineta(@RequestBody skates patineta) {
        return patinetaService.salvarPatineta(patineta);

    }

    // Consultas personalizadas
    @GetMapping("/patinetacompleta/jpql")
    public List<skates> obtenerPatinetaCompletaJPQL() {
        return patinetaService.obtenerPatinetaCompletaJPQL();
    }

}
