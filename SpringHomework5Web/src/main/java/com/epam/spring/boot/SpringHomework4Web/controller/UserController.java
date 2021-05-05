package com.epam.spring.boot.SpringHomework4Web.controller;

import com.epam.spring.boot.SpringHomework4Web.controller.assembler.UserAssembler;
import com.epam.spring.boot.SpringHomework4Web.controller.model.UserModel;
import com.epam.spring.boot.SpringHomework4Web.dto.UserDto;
import com.epam.spring.boot.SpringHomework4Web.model.User;
import com.epam.spring.boot.SpringHomework4Web.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1//users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserAssembler userAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{login}")
    public UserModel getUser(@PathVariable String login) {
        log.info("Get user with login: {}", login);
        UserDto user = userService.getUser(login);
        return userAssembler.toModel(user);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserModel createUser(@Valid @RequestBody UserDto userDto) {
        log.info("Create user with login: {}", userDto);
        UserDto user = userService.createUser(userDto);
        return userAssembler.toModel(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{login}")
    public UserModel updateUser(@PathVariable String login, @RequestBody UserDto userDto) {
        log.info("Update user with login: {}", userDto);
        UserDto user = userService.updateUser(login, userDto);
        return userAssembler.toModel(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{login}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable String login) {
        log.info("Delete user with login: {}", login);
        userService.deleteUser(login);
        return ResponseEntity.noContent().build();
    }


}
