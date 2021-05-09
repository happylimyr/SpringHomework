package com.nulp.bat.travelagency.service.impl;

import com.nulp.bat.travelagency.dto.PersonalDataDto;
import com.nulp.bat.travelagency.dto.UserDto;
import com.nulp.bat.travelagency.exeption.NotFoundException;
import com.nulp.bat.travelagency.model.PersonalData;
import com.nulp.bat.travelagency.model.User;
import com.nulp.bat.travelagency.repository.UserRepository;
import com.nulp.bat.travelagency.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String login) {
        log.info("getting user from database by login {}", login);
        User user = userRepository.findByloginUser(login)
                .orElseThrow(NotFoundException::new);
        return mapUserToUserDto(user);
    }

    private UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .loginUser(user.getLoginUser())
                .passwordUser(user.getPasswordUser())
                .personalData(user.getPersonalData())
                .role(user.getRole().getRole())
                .activeStatus(user.getActiveStatus())
                .build();
    }

    @Override
    public UserDto createPersonalData(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto updatePersonalData(String login, UserDto userDto) {
        return null;
    }

    @Override
    public void deletePersonalData(String login) {

    }
}
