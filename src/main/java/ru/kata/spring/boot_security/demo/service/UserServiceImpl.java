package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDAO;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }

    @Transactional
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Transactional
    public User findById(Long id) {
        return userDAO.findById(id).get();
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Transactional
    public User update(User user) {
        return userDAO.save(user);
    }

    @Transactional
    public User findByName(String name) {
        return userDAO.findByUsername(name);
    }
}
