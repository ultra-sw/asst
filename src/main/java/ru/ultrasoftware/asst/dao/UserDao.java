package ru.ultrasoftware.asst.dao;

import ru.ultrasoftware.asst.domain.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
}
