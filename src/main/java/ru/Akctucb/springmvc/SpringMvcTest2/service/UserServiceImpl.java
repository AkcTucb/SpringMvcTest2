package ru.Akctucb.springmvc.SpringMvcTest2.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Akctucb.springmvc.SpringMvcTest2.dao.UserDao;
import ru.Akctucb.springmvc.SpringMvcTest2.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void update(User userFromForm) {
        User existingUser = userDao.getUserById(userFromForm.getId());
        if (existingUser != null) {
            existingUser.setName(userFromForm.getName());
            existingUser.setEmail(userFromForm.getEmail());
            userDao.updateUser(existingUser);
        }
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        User user = userDao.getUserById(id);
        if (user != null) {
            userDao.deleteUser(id);
        }
    }
}

