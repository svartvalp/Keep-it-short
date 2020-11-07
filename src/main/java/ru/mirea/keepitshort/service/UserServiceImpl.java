package ru.mirea.keepitshort.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mirea.keepitshort.dao.UserDao;
import ru.mirea.keepitshort.entity.User;
import ru.mirea.keepitshort.exception.EntityAlreadyExistsException;
import ru.mirea.keepitshort.exception.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;


    @Override
    public User register(User user) {
        if(userDao.findByLogin(user.getLogin()).isPresent()) {
            throw new EntityAlreadyExistsException("User");
        }
        return userDao.save(user);
    }

    @Override
    public User getUserInfo(String login) {
        return userDao.findByLogin(login).orElseThrow(() -> new EntityNotFoundException("User"));
    }
}
