package com.MinTicCiclo3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MinTicCiclo3.Model.Categoria;
import com.MinTicCiclo3.Repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public List<Categoria> obtenerCategoriaCompleta(){
        return categoriaRepository.obtenerCategoriaCompleta();
    }
        public Optional<Categoria> obtenerCategoriaId(Integer id){
            return categoriaRepository.obtenerCategoriaId(id);
        }
        
        public Categoria salvarCategoria(Categoria categoria){
            if (categoria.getId()==null){
                return categoriaRepository.salvarCategoria(categoria);
            }
            else{
                Optional <Categoria> categoriaAuxiliar = categoriaRepository.obtenerCategoriaId(categoria.getId());
                if (categoriaAuxiliar.isEmpty()){
                    return categoriaRepository.salvarCategoria(categoria);
                }
                else{
                    return categoria;
                }
            }
    
        }
    
}
