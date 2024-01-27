package com.example.sem3HomeTask.utils;

import com.example.sem3HomeTask.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Маппер сущности пользователя, для преобразования данных и БД в сущность.
 */
@Component
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        user.setName(rs.getString("name"));
        user.setAge(rs.getInt("age"));
        user.setEmail(rs.getString("email"));
        return user;
    }
}