package com.MinTicCiclo3.Repository.Crud;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.MinTicCiclo3.Model.Message;
public interface MessageCrudRepository extends CrudRepository<Message, Integer>{
    
    // En SQL select * from tabla_Mensaje as xxx where nombre ="xxxxx"
    // pap es el as de la tabla name es el nombre del atributo en la entidad.
    // nombreMensaje pasa el valor a la variable n
    // SELECT a FROM Autor a ORDER BY a.nombre, a.apellidos
    @Query("select todo from Message todo")
    public List<Message> obtenerMessageCompletaJPQL();

}

