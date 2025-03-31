package ru.Akctucb.springmvc.SpringMvcTest2.dao;

import ru.Akctucb.springmvc.SpringMvcTest2.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUserById(Long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
}
