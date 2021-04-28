package com.epam.spring.boot.SpringHomework4Web.service.imp;

import com.epam.spring.boot.SpringHomework4Web.dto.UserDto;
import com.epam.spring.boot.SpringHomework4Web.model.User;
import com.epam.spring.boot.SpringHomework4Web.repository.UserRepository;
import com.epam.spring.boot.SpringHomework4Web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String login) {
        User user = userRepository.getUser(login);
        return mapUserToDto(user);
    }

    @Override
    public void deleteUser(String login) {
        userRepository.deleteUser(login);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapUserDtoToUser(userDto);
        user = userRepository.createUser(user);
        return mapUserToDto(user);
    }

    @Override
    public UserDto updateUser(String login, UserDto userDto) {
        User user = mapUserDtoToUser(userDto);
        user = userRepository.updateUser(login, user);
        return mapUserToDto(user);
    }


    private UserDto mapUserToDto(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .build();
    }

    private User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .build();
    }


}
