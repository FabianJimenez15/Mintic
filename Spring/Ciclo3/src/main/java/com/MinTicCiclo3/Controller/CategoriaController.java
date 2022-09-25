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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.MinTicCiclo3.Model.Categoria;
import com.MinTicCiclo3.Service.CategoriaService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin(origins="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping("/categoriaCompleta")
    public List<Categoria> obtenerCategoriaCompleta(){
        return categoriaService.obtenerCategoriaCompleta();
    }

    @GetMapping("/identificador/{id}")
    public Optional<Categoria> obtenerCategoriaId(@PathVariable("id") Integer identificador){
        return categoriaService.obtenerCategoriaId(identificador);
    }

    @PostMapping("/salvarCategoria")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria salvarCategoria(@RequestBody Categoria categoria){
        return categoriaService.salvarCategoria(categoria);

    }
}