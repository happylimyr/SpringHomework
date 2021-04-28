package com.epam.spring.boot.SpringHomework4Web.repository;

import com.epam.spring.boot.SpringHomework4Web.model.User;

public interface UserRepository {

    User getUser(String login);

    User createUser(User user);

    User updateUser(String login, User user);

    void deleteUser(String login);
}
