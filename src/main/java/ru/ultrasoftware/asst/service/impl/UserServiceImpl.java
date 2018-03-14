package ru.ultrasoftware.asst.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ultrasoftware.asst.dao.UserDao;
import ru.ultrasoftware.asst.domain.User;
import ru.ultrasoftware.asst.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getUsers() {
        return userDao.getUsers();
    }

}
