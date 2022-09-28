package com.MinTicCiclo3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MinTicCiclo3.Model.Score;
import com.MinTicCiclo3.Repository.Crud.ScoreCrudRepository;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> obtenerScoreCompleta() {
        return (List<Score>) scoreCrudRepository.findAll();
    }

    public Optional<Score> obtenerScoreId(Integer id) {
        return scoreCrudRepository.findById(id);
    }

    public Score salvarScore(Score score) {
        return scoreCrudRepository.save(score);
    }

    // Uso JPQL Java Persitence Query Language

    public List<Score> obtenerScoreCompletaJPQL() {
        return scoreCrudRepository.obtenerScoreCompletaJPQL();
    }
}
