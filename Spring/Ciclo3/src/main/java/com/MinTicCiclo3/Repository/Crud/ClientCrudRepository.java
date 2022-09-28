package com.MinTicCiclo3.Repository.Crud;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.MinTicCiclo3.Model.Client;

public interface ClientCrudRepository extends CrudRepository <Client, Integer> {
     // En SQL select * from tabla_Client as xxx where nombre ="xxxxx"
        // pap es el as de la tabla name es el nombre del atributo en la entidad.
        // nombreClient pasa el valor a la variable n
        // SELECT a FROM Autor a ORDER BY a.nombre, a.apellidos
        @Query("select todo from Client todo")
        public List<Client> obtenerClientCompletaJPQL();
}
