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
import com.MinTicCiclo3.Model.Skates;
import com.MinTicCiclo3.Service.SkatesService;

@RestController
@RequestMapping("/api/Skate")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class SkatesController {
    
    @Autowired
    private SkatesService skatesService;

    @GetMapping("/all")
    public List<Skates> obtenerSkatesCompleta() {
        return skatesService.obtenerSkatesCompleta();
    }

    @GetMapping("/{id}")
    public Optional<Skates> obtenerSkatesId(@PathVariable("id") Integer identificador) {
        return skatesService.obtenerSkatesId(identificador);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Skates salvarSkates(@RequestBody Skates skates) {
        return skatesService.salvarSkates(skates);

    }

    // Consultas personalizadas
    @GetMapping("/skatescompleta/jpql")
    public List<Skates> obtenerSkatesCompletaJPQL() {
        return skatesService.obtenerSkatesCompletaJPQL();
    }


}
