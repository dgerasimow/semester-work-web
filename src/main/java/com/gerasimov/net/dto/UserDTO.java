package com.gerasimov.net.dto;

public class UserDTO {
    private String firstName;
    private String secondName;
    private String login;
    private String password;

    public UserDTO(String firstName, String secondName, String login, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
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

    public String getPassword() {
        return password;
    }
}
