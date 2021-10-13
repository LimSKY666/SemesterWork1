package ru.kpfu.itis.sokolov.dto;

public class UserDTO {
    private String firstName;
    private String secondName;
    private String login;

    public UserDTO(String firstName, String secondName, String login) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
