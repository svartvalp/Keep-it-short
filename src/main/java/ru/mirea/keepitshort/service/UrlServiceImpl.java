package ru.mirea.keepitshort.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.mirea.keepitshort.dao.UrlDao;
import ru.mirea.keepitshort.entity.Url;
import ru.mirea.keepitshort.exception.EntityNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {
    private final UrlDao urlDao;

    @Value("${server.host.url}")
    private String hostUrl;

    @Override
    public Url createUrl(Url url) {
        url = urlDao.save(url);
        url.setUrlFrom(hostUrl + "/url/" + url.getId());
        return urlDao.save(url);
    }

    @Override
    public List<Url> getAllUrlForUserId(String userId) {
        return urlDao.findAllByUserId(userId);
    }

    @Override
    public void deleteUrl(String id) {
        urlDao.deleteById(id);
    }

    @Override
    public Url findById(String id) {
        return urlDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Url"));
    }
}
