package com.epam.spring.boot.SpringHomework4Web.controller;

import com.epam.spring.boot.SpringHomework4Web.dto.UserDto;
import com.epam.spring.boot.SpringHomework4Web.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{login}")
    public UserDto getUser(@PathVariable String login) {
        log.info("Get user with login: {}", login);
        return userService.getUser(login);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        log.info("Create user with login: {}", userDto);
        return userService.createUser(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{login}")
    public UserDto updateUser(@PathVariable String login, @RequestBody UserDto userDto) {
        log.info("Update user with login: {}", userDto);
        return userService.updateUser(login, userDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{login}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String login) {
        log.info("Delete user with login: {}", login);
        userService.deleteUser(login);
    }


}
