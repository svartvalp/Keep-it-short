package ru.mirea.keepitshort.service;

import ru.mirea.keepitshort.entity.User;

public interface UserService {
    User register(User user);
    User getUserInfo(String login);
}
