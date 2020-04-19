package com.phonak.scorecard.dao;


import com.phonak.scorecard.model.Score;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ScoreDao {
    int insertScore(Score score);
    int updateScore (String username,Score score, LocalDate date);
    List<Score> selectAllScore();
    List<Score> selectAllScoreByUsername(String username );
    Optional<Score> selectScore(String username);
    }

