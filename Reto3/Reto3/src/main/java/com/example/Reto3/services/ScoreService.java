package com.example.Reto3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto3.entities.Score;
import com.example.Reto3.repository.ScoreRepository;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score>getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score s){
        if(s.getId()==null){
            return scoreRepository.save(s);
        }else{
            Optional<Score> e = scoreRepository.getScore(s.getId());
            if(e.isPresent()){
                return s;
            }else{
                return scoreRepository.save(s);
            }
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Score> e = scoreRepository.getScore(id);
        if(e.isPresent()){
            scoreRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
}
