package com.phonak.scorecard.dao;

import com.phonak.scorecard.model.User;
import com.phonak.scorecard.security.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public class UserDataAccesService implements UserDao {
    private final JdbcTemplate jdbcTemplate;
    private final PasswordConfig passwordConfig;

    @Autowired
    public UserDataAccesService(JdbcTemplate jdbcTemplate, PasswordConfig passwordConfig) {
        this.jdbcTemplate = jdbcTemplate;
        this.passwordConfig = passwordConfig;
    }

    @Override
    public int insertUser(User user) {
String sqlUser="INSERT INTO users (username,password,first_name, last_name, enabled) VALUES(?,?,?,?,true)";
   jdbcTemplate.update(sqlUser, user.getUsername(), passwordConfig.passwordEncoder().encode(user.getPassword()),user.getFirstName(),user.getLastName());
       String sqlAuthorities ="insert into authorities (username,authority) VALUES (?,'ROLE_EMPLOYEE')";
       jdbcTemplate.update(sqlAuthorities,user.getUsername());
       return 1;
    }

    @Override
    public List<User> selectAllUser() {
        return null;
    }
}
