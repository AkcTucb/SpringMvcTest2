package ru.Akctucb.springmvc.SpringMvcTest2.service;

import ru.Akctucb.springmvc.SpringMvcTest2.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(Long id);
    void addUser(User user);
    void update(User user);
    void deleteUser(Long id);
}
