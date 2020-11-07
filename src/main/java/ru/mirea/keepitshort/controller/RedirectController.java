package ru.mirea.keepitshort.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.mirea.keepitshort.entity.Url;
import ru.mirea.keepitshort.service.UrlService;

@RequiredArgsConstructor
@Controller
public class RedirectController {
    private final UrlService urlService;

    @GetMapping("/url/{id}")
    public String redirectToUrl(@PathVariable("id") String id) {
        Url url = urlService.findById(id);
        return "redirect:" + url.getUrlTo();
    }
}
