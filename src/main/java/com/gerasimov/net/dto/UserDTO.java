package com.gerasimov.net.dto;

public class UserDTO {
    private int id;
    private String firstName;
    private String secondName;
    private String login;
    private String password;

    public UserDTO(int id, String firstName, String secondName, String login, String password) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
    }

    public UserDTO(String firstName, String secondName, String login, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
    }

    public int getId() { return id; }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() { return password; }
}
