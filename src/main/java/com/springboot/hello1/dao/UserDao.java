package com.springboot.hello1.dao;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int deleteAll() {
        return this.jdbcTemplate.update("delete from users");
    }

    public int add() {
        return this.jdbcTemplate.update("insert into users");
    }

    public int deleteUser() {
        return this.jdbcTemplate.update("delete from users where id=?");
    }

}
