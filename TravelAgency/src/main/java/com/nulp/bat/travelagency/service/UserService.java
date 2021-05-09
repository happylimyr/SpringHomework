package com.nulp.bat.travelagency.service;


import com.nulp.bat.travelagency.dto.UserDto;

public interface UserService {
    UserDto getUser(String login);

    UserDto createPersonalData(UserDto userDto);

    UserDto updatePersonalData(String login, UserDto userDto);

    void deletePersonalData(String login);
}
