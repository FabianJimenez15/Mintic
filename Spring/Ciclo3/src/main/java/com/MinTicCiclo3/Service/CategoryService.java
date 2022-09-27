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
    private CategoryRepository categoriaRepository;
    
    public List<Category> obtenerCategoriaCompleta(){
        return categoriaRepository.obtenerCategoriaCompleta();
    }
        public Optional<Category> obtenerCategoriaId(Integer id){
            return categoriaRepository.obtenerCategoriaId(id);
        }
        
        public Category salvarCategoria(Category categoria){
            if (categoria.getId()==null){
                return categoriaRepository.salvarCategoria(categoria);
            }
            else{
                Optional <Category> categoriaAuxiliar = categoriaRepository.obtenerCategoriaId(categoria.getId());
                if (categoriaAuxiliar.isEmpty()){
                    return categoriaRepository.salvarCategoria(categoria);
                }
                else{
                    return categoria;
                }
            }
    
        }
    
}
