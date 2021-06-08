package com.nulp.bat.travelagency.service.impl;

import com.nulp.bat.travelagency.dto.PersonalDataDto;
import com.nulp.bat.travelagency.dto.UserDto;
import com.nulp.bat.travelagency.exeption.NotFoundException;
import com.nulp.bat.travelagency.model.PersonalData;
import com.nulp.bat.travelagency.model.User;
import com.nulp.bat.travelagency.repository.RoleRepository;
import com.nulp.bat.travelagency.repository.UserRepository;
import com.nulp.bat.travelagency.service.RoleService;
import com.nulp.bat.travelagency.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDto getUser(String login) {
        log.info("getting user from database by login {}", login);
        User user = userRepository.findByloginUser(login)
                .orElseThrow(NotFoundException::new);
        return mapUserToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        return userRepository.findAll().stream().map(this::mapUserToUserDto).collect(Collectors.toList());

    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("creating User in database: {}", userDto);
        User user = mapUserDtoToUser(userDto);
        user.setPasswordUser(bCryptPasswordEncoder.encode(user.getPasswordUser()));// asdasdsadasdasdasdasdasdasdasdasdsad
        user = userRepository.save(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String login, UserDto userDto) {
        log.info("updating User in database: {}", userDto);
        User user = mapUserDtoToUser(userDto);
        User userFromDB = userRepository.findByloginUser(login)
                .orElseThrow(NotFoundException::new);
        userRepository.delete(userFromDB);
        user.setPasswordUser(bCryptPasswordEncoder.encode(user.getPasswordUser()));//5646546546546456
        user = userRepository.save(user);
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(String login) {
        log.info("deleting user in database by login {}", login);
        User user = userRepository.findByloginUser(login)
                .orElseThrow(NotFoundException::new);
        userRepository.delete(user);
    }

    @Override
    public void deleteById(Long idUser) {
        User user = userRepository.findById(idUser)
                .orElseThrow(NotFoundException::new);
        userRepository.delete(user);
    }

    private User mapUserDtoToUser(UserDto userDto) {
        roleRepository.findByRole(userDto.getRole().getRole());
        return User.builder()
                .loginUser(userDto.getLoginUser())
                .passwordUser(userDto.getPasswordUser())
                .personalData(userDto.getPersonalData())
                .role(roleRepository.findByRole(userDto.getRole().getRole()).get())
                .activeStatus(userDto.getActiveStatus())
                .build();
    }

    private UserDto mapUserToUserDto(User user) {
        roleRepository.findByRole(user.getRole().getRole());
        return UserDto.builder()
                .loginUser(user.getLoginUser())
                .passwordUser(user.getPasswordUser())
                .personalData(user.getPersonalData())
                .role(user.getRole())
//                .role(roleRepository.findByRole(user.getRole().getRole()).get())
                .activeStatus(user.getActiveStatus())
                .build();
    }
}
