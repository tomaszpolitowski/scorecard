package com.phonak.scorecard.dao;

import com.phonak.scorecard.model.Time;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public class TimeDataAccesService implements TimeDao {
    private final JdbcTemplate jdbcTemplate;

    public TimeDataAccesService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertTime(Time time) {
        String sql = "INSERT INTO times (total_time_worked,indle_time,date ) VALUES (?,?,?) ";
        jdbcTemplate.update(sql,time.getTotalTimeWorked(),time.getIndleTime(),time.getDate());
        return 1;
    }

    @Override
    public Optional<Time> selectTime(LocalDate date) {
        return Optional.empty();
    }
}
