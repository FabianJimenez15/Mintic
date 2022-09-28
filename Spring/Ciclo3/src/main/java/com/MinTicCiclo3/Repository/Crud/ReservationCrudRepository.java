package com.MinTicCiclo3.Repository.Crud;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.MinTicCiclo3.Model.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
// En SQL select * from tabla_Reservation as xxx where nombre ="xxxxx"
    // pap es el as de la tabla name es el nombre del atributo en la entidad.
    // nombreReservation pasa el valor a la variable n
    // SELECT a FROM Autor a ORDER BY a.nombre, a.apellidos
    @Query("select todo from Reservation todo")
    public List<Reservation> obtenerReservationCompletaJPQL();

}
