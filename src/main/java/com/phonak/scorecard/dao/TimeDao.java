package com.phonak.scorecard.dao;

import com.phonak.scorecard.model.Time;

import java.time.LocalDate;
import java.util.Optional;

public interface TimeDao {
    int insertTime(Time time);
    Optional<Time> selectTime(LocalDate date);
}
