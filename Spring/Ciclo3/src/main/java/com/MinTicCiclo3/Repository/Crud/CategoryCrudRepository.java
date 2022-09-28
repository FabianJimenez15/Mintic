package com.MinTicCiclo3.Repository.Crud;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.MinTicCiclo3.Model.Category;

public interface CategoryCrudRepository extends CrudRepository<Category, Integer>{
    
 // En SQL select * from tabla_Category as xxx where nombre ="xxxxx"
        // pap es el as de la tabla name es el nombre del atributo en la entidad.
        // nombreCategory pasa el valor a la variable n
        // SELECT a FROM Autor a ORDER BY a.nombre, a.apellidos
        @Query("select todo from Category todo")
        public List<Category> obtenerCategoryCompletaJPQL();

}
