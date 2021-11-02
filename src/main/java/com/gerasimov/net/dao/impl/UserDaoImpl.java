package com.gerasimov.net.dao.impl;

import com.gerasimov.net.dao.Dao;
import com.gerasimov.net.helper.PostgresConnectionHelper;
import com.gerasimov.net.model.User;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;

public class UserDaoImpl implements Dao<User> {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
    private final Connection connection = PostgresConnectionHelper.getConnection();
    @Override
    public User get(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new User(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("second_name"),
                    resultSet.getString("login"),
                    resultSet.getString("password"));

        } catch (SQLException throwables) {
            LOGGER.warn("Failed to get by ID",throwables);
        }
        return null;
    }

    public User get(String login) {
        String sql = "SELECT * FROM users WHERE login = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return new User(resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getString("login"),
                        resultSet.getString("password"));
            }

        } catch (SQLException throwables) {
            LOGGER.warn("Failed to get user by login", throwables);
        }
        return null;
    }


    @Override
    public List<User> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sql);
            List<User> users = new ArrayList();
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getString("login"),
                        resultSet.getString("password")));
            }
            return users;
        } catch (SQLException throwables) {
            LOGGER.warn("Error to execute getAll query", throwables);
            return new ArrayList<>();
        }
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (first_name, second_name, login, password) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getSecondName());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed saving new user.",throwables);
        }


    }
}
