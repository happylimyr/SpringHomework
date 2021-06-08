package com.nulp.bat.travelagency.controller;

import com.nulp.bat.travelagency.api.UserApi;
import com.nulp.bat.travelagency.controller.assembler.PersonalDataAssembler;
import com.nulp.bat.travelagency.controller.assembler.UserAssembler;
import com.nulp.bat.travelagency.controller.model.TourModel;
import com.nulp.bat.travelagency.controller.model.UserModel;
import com.nulp.bat.travelagency.dto.PersonalDataDto;
import com.nulp.bat.travelagency.dto.RoleDto;
import com.nulp.bat.travelagency.dto.TourDto;
import com.nulp.bat.travelagency.dto.UserDto;
import com.nulp.bat.travelagency.model.User;
import com.nulp.bat.travelagency.service.PersonalDataService;
import com.nulp.bat.travelagency.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController implements UserApi {

    private final UserService userService;
    private final UserAssembler userAssembler;

    @Override
    public UserModel getUser(String login) {
        log.info("getUser: login {}", login);
        UserDto user = userService.getUser(login);
        return userAssembler.toModel(user);
    }

    public List<UserModel> getAllUser() {
        List<UserDto> user = userService.getAllUser();
        return userAssembler.userModelList(user);
    }

    @Override
    public UserModel createUser(UserDto userDto) {
        log.info("createUser: login {}", userDto.getLoginUser());
        UserDto user = userService.createUser(userDto);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel updateUser(String login, UserDto userDto) {
        log.info("updateUser: user name {}", login);
        UserDto users = userService.updateUser(login, userDto);
        return userAssembler.toModel(users);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String login) {
        log.info("deleteUser: login {}", login);
        userService.deleteUser(login);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteById(Long idUser) {
        userService.deleteById(idUser);
        return ResponseEntity.noContent().build();
    }
}
