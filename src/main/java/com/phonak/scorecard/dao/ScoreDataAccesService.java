package com.phonak.scorecard.dao;

import com.phonak.scorecard.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ScoreDataAccesService implements ScoreDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ScoreDataAccesService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertScore(Score score) {
        String sql = "INSERT INTO scores (username, total_time_worked,indle_time,date, slimtip_repairs, c_shell_repairs, itc_remakes,ite_repairs,bte_ric_repairs, ite_devices_in,bte_devices_in, ite_orders_in,accessories,bte_creating_repairs_raports, ite_creating_repairs_raports,orders_scan,devices_out,\"reset\", housing_replacement  ) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) " +
                "ON CONFLICT(username, date) DO UPDATE SET " +
                "total_time_worked= EXCLUDED.total_time_worked, indle_time=EXCLUDED.indle_time, slimtip_repairs = EXCLUDED.slimtip_repairs, c_shell_repairs=EXCLUDED.c_shell_repairs, itc_remakes = EXCLUDED.itc_remakes,ite_repairs= EXCLUDED.ite_repairs,bte_ric_repairs=EXCLUDED.bte_ric_repairs, ite_devices_in=EXCLUDED.ite_devices_in,bte_devices_in = EXCLUDED.bte_devices_in, ite_orders_in=EXCLUDED.ite_orders_in,accessories=EXCLUDED.accessories,bte_creating_repairs_raports=EXCLUDED.bte_creating_repairs_raports, ite_creating_repairs_raports=EXCLUDED.ite_creating_repairs_raports,orders_scan=EXCLUDED.orders_scan,devices_out=EXCLUDED.devices_out,\"reset\"=EXCLUDED.reset, housing_replacement = EXCLUDED.housing_replacement  ;";
        jdbcTemplate.update(sql, score.getUsername(), score.getTotalTimeWorked(), score.getIndleTime(), score.getDate(), score.getSlimtipRepairs(), score.getcShellRepairs(), score.getItcRemakes(), score.getIteRepairs(), score.getBteRicRepairs(), score.getIteDevicesIn(), score.getBteDevicesIn(), score.getIteOrdersIn(), score.getAccessories(), score.getBteCreatingRepairsRaports(), score.getIteCreatingRepairsRaports(), score.getOrdersScan(), score.getDevicesOut(), score.getReset(), score.getHousingReplacement());
        return 1;
    }


    @Override
    public List<Score> selectAllScore() {
        String sql = "Select * FROM scores;";
        List<Score> query = jdbcTemplate.query(sql, (resultSet, i) -> {

            String username = resultSet.getString("username");
            Integer indleTime = resultSet.getInt("indle_time");
            LocalDate date = resultSet.getDate("date").toLocalDate();
            Integer totalTimeWorked = resultSet.getInt("total_time_worked");
            Integer slimTipRepairs = resultSet.getInt("slimtip_repairs");
            Integer cShellRepairs = resultSet.getInt("c_shell_repairs");
            Integer itcRemakes = resultSet.getInt("itc_remakes");
            Integer iteRepairs = resultSet.getInt("ite_repairs");
            Integer bteRicRepairs = resultSet.getInt("bte_ric_repairs");
            Integer iteDevicesIn = resultSet.getInt("ite_devices_in");
            Integer bteDevicesIn = resultSet.getInt("bte_devices_in");
            Integer iteOrdersIn = resultSet.getInt("ite_orders_in");
            Integer accessories = resultSet.getInt("accessories");
            Integer bteCreatingRepairsRaports = resultSet.getInt("bte_creating_repairs_raports");
            Integer iteCreatingRepairsRaports = resultSet.getInt("ite_creating_repairs_raports");
            Integer ordersScan = resultSet.getInt("orders_scan");
            Integer devicesOut = resultSet.getInt("devices_out");
            Integer reset = resultSet.getInt("reset");
            Integer housingReplacement = resultSet.getInt("housing_replacement");
            return new Score(username, indleTime, date, totalTimeWorked, slimTipRepairs, cShellRepairs, itcRemakes, iteRepairs, bteRicRepairs, iteDevicesIn, bteDevicesIn, iteOrdersIn, accessories, bteCreatingRepairsRaports, iteCreatingRepairsRaports, ordersScan, devicesOut, reset, housingReplacement);
        });
        if (!(query.size() > 0)) query.add(new Score());
        return query;

    }

    @Override
    public List<Score> selectAllScoreByUsername(String username) {
        List<Score> scores = selectAllScore();
        List<Score> result = scores.stream().filter(x -> x.getUsername().equals(username)).collect(Collectors.toList());
        return result;
    }


    public Optional<Score> selectScore(String username) {
        String sql = "Select * WHERE username=? AND";
        Score score = jdbcTemplate.queryForObject(sql, new Object[]{username}, (resultSet, i) ->
        {

            Integer totalTimeWorked = resultSet.getInt("total_time_worked");
            Integer indleTime = resultSet.getInt("indle_time");
            LocalDate date = resultSet.getDate("date").toLocalDate();
            return new Score();
            //return new Score(username, totalTimeWorked, indleTime, date);
        });
        return Optional.ofNullable(score);
    }

    @Override
    public int updateScore(String username, Score score, LocalDate date) {
        Optional<Score> scoreMaybe = selectScore(username);
        if (!scoreMaybe.isPresent()) return 0;
        String sql = "UPDATE scores SET total_time_worked=?, indle_time=? where username =? AND date = now()";
        jdbcTemplate.update(sql,
                score.getTotalTimeWorked(),
                score.getIndleTime(),
                username);
        return 1;
    }


}
