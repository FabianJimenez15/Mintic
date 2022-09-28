package com.MinTicCiclo3.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.MinTicCiclo3.Model.Score;
import com.MinTicCiclo3.Service.ScoreService;

@RestController
@RequestMapping("/api/score")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class ScoreController {
    
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/scoreCompleta")
    public List<Score> obtenerScoreCompleta() {
        return scoreService.obtenerScoreCompleta();
    }

    @GetMapping("/{id}")
    public Optional<Score> obtenerScoreId(@PathVariable("id") Integer identificador) {
        return scoreService.obtenerScoreId(identificador);
    }

    @PostMapping("salvarscore")
    @ResponseStatus(HttpStatus.CREATED)
    public Score salvarScore(@RequestBody Score score) {
        return scoreService.salvarScore(score);

    }

    // Consultas personalizadas
    @GetMapping("/scorecompleta/jpql")
    public List<Score> obtenerScoreCompletaJPQL() {
        return scoreService.obtenerScoreCompletaJPQL();
    }

}
