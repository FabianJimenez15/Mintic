package com.MinTicCiclo3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MinTicCiclo3.Model.Score;
import com.MinTicCiclo3.Repository.ScoreRepository;

@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> obtenerScoreCompleta() {
        return scoreRepository.obtenerScoreCompleta();
    }

    public Optional<Score> obtenerScoreId(Integer id) {
        return scoreRepository.obtenerScoreId(id);
    }

    public Score salvarScore(Score score) {
        if (score.getId() == null) {
            return scoreRepository.salvarScore(score);
        } else {

            Optional<Score> scoreAuxiliar = scoreRepository.obtenerScoreId(score.getId());
            if (scoreAuxiliar.isEmpty()) {
                return scoreRepository.salvarScore(score);
            } else {
                return score;
            }
        }

    }
    // JPQL

    public List<Score> obtenerScoreCompletaJPQL() {
        return scoreRepository.obtenerScoreCompletaJPQL();
    }

}
