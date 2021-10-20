package ru.kpfu.itis.sokolov.model.user;

import ru.kpfu.itis.sokolov.helper.PasswordHelper;

import java.sql.Timestamp;

public class User {

    private int id;
    private String username;
    private String password;
    private String email;
    private Timestamp registrationTime;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public User(String login, String password) {
        this.username = login;
        this.password = password;
    }

    public User(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getRegistrationTimestamp() {
        return registrationTime;
    }

    public void setRegistrationTime(Timestamp registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static User createNewUser(String username, String password){
        if (username == null || password == null){
            return null;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(PasswordHelper.encrypt(password));
        return user;
    }
}
