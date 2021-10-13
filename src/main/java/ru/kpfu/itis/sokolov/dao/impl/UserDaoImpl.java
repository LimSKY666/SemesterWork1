package ru.kpfu.itis.sokolov.dao.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.sokolov.dao.Dao;
import ru.kpfu.itis.sokolov.helper.PostgresConnectionHelper;
import ru.kpfu.itis.sokolov.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements Dao<User> {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    private final Connection connection = PostgresConnectionHelper.getConnection();


    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sql);

            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
                users.add(user);
            }
            return users;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed execute getAll query.", throwables);
            return new ArrayList<>();
        }
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (first_name, last_name, login, password) VALUES (?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new user.", throwables);
        }
    }

    @Override
    public User get(String login) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM users where login = \'" + login + "\'";
            return executeQuery(statement, sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private User executeQuery(Statement statement, String sql) throws SQLException {
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            return new User(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("login"),
                    resultSet.getString("password")
            );
        }
        return null;
    }
}
