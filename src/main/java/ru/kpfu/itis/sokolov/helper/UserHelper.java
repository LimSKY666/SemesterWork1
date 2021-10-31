package ru.kpfu.itis.sokolov.helper;

import ru.kpfu.itis.sokolov.model.User;

public class UserHelper {

    public static User createNewUser(String username, String password){
        if (username == null || password == null) {
            return null;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(PasswordHelper.encrypt(password));
        return user;
    }
}
