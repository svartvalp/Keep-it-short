package ru.mirea.keepitshort.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.mirea.keepitshort.entity.User;

import java.util.Optional;

public interface UserDao extends MongoRepository<User, String> {
    Optional<User> findByLogin(String login);
}
