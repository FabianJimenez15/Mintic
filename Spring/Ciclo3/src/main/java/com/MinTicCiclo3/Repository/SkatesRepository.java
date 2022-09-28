package com.MinTicCiclo3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MinTicCiclo3.Model.Skates;
import com.MinTicCiclo3.Repository.Crud.SkatesCrudRepository;

@Repository
public class SkatesRepository {
    @Autowired
    private SkatesCrudRepository skatesCrudRepository;

    public List<Skates> obtenerSkatesCompleta() {
        return (List<Skates>) skatesCrudRepository.findAll();
    }

    public Optional<Skates> obtenerSkatesId(Integer id) {
        return skatesCrudRepository.findById(id);
    }

    public Skates salvarSkates(Skates skates) {
        return skatesCrudRepository.save(skates);
    }

    // Uso JPQL Java Persitence Query Language

    public List<Skates> obtenerSkatesCompletaJPQL() {
        return skatesCrudRepository.obtenerSkatesCompletaJPQL();
    }

}
