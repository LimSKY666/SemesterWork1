package ru.kpfu.itis.sokolov.dao;

import ru.kpfu.itis.sokolov.model.User;

import java.sql.SQLException;

public interface UserDAO {
    boolean saveUser(String username, String password);
    User getUserByID(int id);
    User getUserByName(String username) throws SQLException;
    boolean userIsExist(String username, String password);
    boolean changeUsernameById(int id, String username) throws SQLException;
    boolean changeEmailById(int id, String email) throws SQLException;
}