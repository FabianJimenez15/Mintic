package com.MinTicCiclo3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MinTicCiclo3.Model.Categoria;
import com.MinTicCiclo3.Repository.Crud.CategoriaCrudRepository;

@Repository
public class CategoriaRepository {
    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;
    
    public List <Categoria> obtenerCategoriaCompleta(){
    
        return (List<Categoria>) categoriaCrudRepository.findAll();
    
    }
    public Optional<Categoria> obtenerCategoriaId(Integer id){
        return categoriaCrudRepository.findById(id);
    }
    
    public Categoria  salvarCategoria(Categoria categoria){
        return categoriaCrudRepository.save(categoria);        
    }
}
