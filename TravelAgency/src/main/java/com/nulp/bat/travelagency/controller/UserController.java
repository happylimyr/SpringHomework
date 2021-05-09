package com.nulp.bat.travelagency.controller;

import com.nulp.bat.travelagency.api.UserApi;
import com.nulp.bat.travelagency.controller.assembler.PersonalDataAssembler;
import com.nulp.bat.travelagency.controller.assembler.UserAssembler;
import com.nulp.bat.travelagency.controller.model.UserModel;
import com.nulp.bat.travelagency.dto.PersonalDataDto;
import com.nulp.bat.travelagency.dto.UserDto;
import com.nulp.bat.travelagency.service.PersonalDataService;
import com.nulp.bat.travelagency.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;
    private final UserAssembler userAssembler;
    @Override
    public UserModel getUser(String login) {
        log.info("getUser: login {}", login);
        UserDto user = userService.getUser(login);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel createUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserModel updateUser(String login, UserDto userDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteUser(String email) {
        return null;
    }
}
