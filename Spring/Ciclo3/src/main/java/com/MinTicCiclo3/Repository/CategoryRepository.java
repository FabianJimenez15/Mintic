package com.MinTicCiclo3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MinTicCiclo3.Model.Category;
import com.MinTicCiclo3.Repository.Crud.CategoryCrudRepository;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoriaCrudRepository;
    
    public List <Category> obtenerCategoriaCompleta(){
    
        return (List<Category>) categoriaCrudRepository.findAll();
    
    }
    public Optional<Category> obtenerCategoriaId(Integer id){
        return categoriaCrudRepository.findById(id);
    }
    
    public Category  salvarCategoria(Category categoria){
        return categoriaCrudRepository.save(categoria);        
    }
}
