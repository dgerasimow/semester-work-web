package com.gerasimov.net.service.impl;

import com.gerasimov.net.dao.impl.UserDaoImpl;
import com.gerasimov.net.dto.UserDTO;
import com.gerasimov.net.helper.PasswordHelper;
import com.gerasimov.net.model.User;
import com.gerasimov.net.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final UserDaoImpl dao = new UserDaoImpl();
    @Override
    public UserDTO get(int id) {
        User user = dao.get(id);
        return new UserDTO(user.getFirstName(), user.getSecondName(), user.getLogin(), user.getPassword());
    }

    @Override
    public UserDTO get(String login) {
        User user = dao.get(login);
        if (user != null) {
            return new UserDTO(user.getFirstName(), user.getSecondName(), user.getLogin(), user.getPassword());
        } else {
            return null;
        }
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = dao.getAll();
        return users.stream()
                .map(u -> new UserDTO(u.getFirstName(),u.getSecondName(),u.getLogin(),u.getPassword()))
                .collect(Collectors.toList());
    }

    @Override
    public void save(UserDTO user) {
        dao.save(new User(
                user.getFirstName(),
                user.getSecondName(),
                user.getLogin(),
                PasswordHelper.encrypt(user.getPassword())
        ));
    }
}
