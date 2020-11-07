package ru.mirea.keepitshort.service;

import ru.mirea.keepitshort.entity.Url;

import java.util.List;

public interface UrlService {
    Url createUrl(Url url);
    List<Url> getAllUrlForUserId(String userId);
    void deleteUrl(String id);
    Url findById(String id);
}
