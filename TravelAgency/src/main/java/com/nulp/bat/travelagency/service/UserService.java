package com.nulp.bat.travelagency.service;


import com.nulp.bat.travelagency.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUser(String login);

    List<UserDto> getAllUser();

    UserDto createUser(UserDto userDto);

    UserDto updateUser(String login, UserDto userDto);

    void deleteUser(String login);

    void deleteById(Long idUser);



}
