package ru.mirea.keepitshort.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.mirea.keepitshort.entity.Url;

import java.util.List;

public interface UrlDao extends MongoRepository<Url, String> {
    List<Url> findAllByUserId(String userId);
}
