package com.MinTicCiclo3.Repository.Crud;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.MinTicCiclo3.Model.Patineta;

public interface PatinetaCrudRepository extends CrudRepository<Patineta, Integer> {

    // En SQL select * from tabla_patineta as xxx where nombre ="xxxxx"
    // pap es el as de la tabla name es el nombre del atributo en la entidad.
    // nombrePatinetaa pasa el valor a la variable n
    // SELECT a FROM Autor a ORDER BY a.nombre, a.apellidos
    @Query("select todo from Patineta todo")
    public List<Patineta> obtenerPatinetaCompletaJPQL();
}
