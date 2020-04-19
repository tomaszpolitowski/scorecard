package com.phonak.scorecard.service;

import com.phonak.scorecard.dao.ScoreDao;
import com.phonak.scorecard.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    private final ScoreDao scoreDao;

@Autowired
    public ScoreService(ScoreDao scoreDao) {
        this.scoreDao = scoreDao;
    }


    public List<Score> selectAllScore(){return scoreDao.selectAllScore();}
    public Optional<Score> selectScore(String username){return scoreDao.selectScore(username);}
    public int insertScore (Score score){return scoreDao.insertScore(score);}
    public  int updateScore (String username, Score score, LocalDate date){return scoreDao.updateScore(username,score, date);}
    public List<Score> getAllScoreByUsername(String username){return scoreDao.selectAllScoreByUsername(username);}


}
