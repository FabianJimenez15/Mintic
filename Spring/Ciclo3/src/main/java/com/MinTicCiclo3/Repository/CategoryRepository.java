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
    private CategoryCrudRepository categoryCrudRepository;
    
    public List <Category> obtenerCategoryCompleta(){
    
        return (List<Category>) categoryCrudRepository.findAll();
    
    }
    public Optional<Category> obtenerCategoryId(Integer id){
        return categoryCrudRepository.findById(id);
    }
    
    public Category  salvarCategory(Category category){
        return categoryCrudRepository.save(category);        
    }
// Uso JPQL Java Persitence Query Language

public List<Category> obtenerCategoryCompletaJPQL() {
    return categoryCrudRepository.obtenerCategoryCompletaJPQL();
}
}
