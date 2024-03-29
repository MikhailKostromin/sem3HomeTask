package com.example.sem3HomeTask.repository;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.utils.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

/**
 * Репозитооий для работы с БД.
 */
@Component
public class UserRepository {
    /**
     * Объект подключения к БД
     */
    private final JdbcTemplate jdbc;

    private final UserMapper userMapper;

    public UserRepository(JdbcTemplate jdbc, UserMapper userMapper) {
        this.jdbc = jdbc;
        this.userMapper = userMapper;
    }

    /**
     * Получение списка пользователей.
     * @return список пользователей.
     */
    public List<User> getUsers() {
        String sql = "select * from \"user\"";
        return jdbc.query(sql, userMapper);
    }

    /**
     * Добавление пользователя в БД.
     * @param user объект пользвателя.
     */
    public void addUsers(User user) {
        String sql = "insert into \"user\" (name, age, email) values (?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }

}
