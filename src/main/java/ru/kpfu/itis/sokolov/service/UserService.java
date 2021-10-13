package ru.kpfu.itis.sokolov.service;

import ru.kpfu.itis.sokolov.dto.UserDTO;
import ru.kpfu.itis.sokolov.model.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();
    UserDTO get(int id);
    void save(User user);
}
