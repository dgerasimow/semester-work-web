package com.gerasimov.net.service;

import com.gerasimov.net.dto.UserDTO;
import com.gerasimov.net.model.User;

import java.util.List;

public interface UserService {
    UserDTO get(int id);
    UserDTO get(String login);

    List<UserDTO> getAll();

    void save(UserDTO user);
}
