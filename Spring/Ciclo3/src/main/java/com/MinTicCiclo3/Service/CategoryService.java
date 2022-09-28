package com.MinTicCiclo3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MinTicCiclo3.Model.Category;
import com.MinTicCiclo3.Repository.CategoryRepository;
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> obtenerCategoryCompleta(){
        return categoryRepository.obtenerCategoryCompleta();
    }
        public Optional<Category> obtenerCategoryId(Integer id){
            return categoryRepository.obtenerCategoryId(id);
        }
        
        public Category salvarCategory(Category category){
            if (category.getId()==null){
                return categoryRepository.salvarCategory(category);
            }
            else{
                Optional <Category> categoryAuxiliar = categoryRepository.obtenerCategoryId(category.getId());
                if (categoryAuxiliar.isEmpty()){
                    return categoryRepository.salvarCategory(category);
                }
                else{
                    return category;
                }
            }
    
        }
}
