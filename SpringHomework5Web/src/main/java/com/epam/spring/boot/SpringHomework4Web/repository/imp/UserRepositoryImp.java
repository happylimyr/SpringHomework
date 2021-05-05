package com.epam.spring.boot.SpringHomework4Web.repository.imp;

import com.epam.spring.boot.SpringHomework4Web.exception.UserNotFoundException;
import com.epam.spring.boot.SpringHomework4Web.model.User;
import com.epam.spring.boot.SpringHomework4Web.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImp implements UserRepository {
    private final List<User> userList = new ArrayList<>();

    @Override
    public User getUser(String login) {
        return userList.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }
@Override
    public User createUser(User user) {
        userList.add(user);
        return user;
    }
@Override
    public User updateUser(String login, User user) {
        boolean isDelited = userList.removeIf(usr -> usr.getLogin().equals(login));
        if (isDelited) {
            userList.add(user);
        } else {
            throw new UserNotFoundException("User doesn't exist");
        }
        return user;
    }
@Override
    public void deleteUser(String login) {
        userList.removeIf(user -> user.getLogin().equals(login));

}
}
