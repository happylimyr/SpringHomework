package com.epam.spring.boot.SpringHomework4Web.service;

import com.epam.spring.boot.SpringHomework4Web.dto.UserDto;

public interface UserService {
    UserDto getUser(String login);

    void deleteUser(String login);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(String login, UserDto userDto);
}
