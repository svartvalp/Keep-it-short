package ru.mirea.keepitshort.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.mirea.keepitshort.entity.Url;
import ru.mirea.keepitshort.service.UrlService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/url")
@RequiredArgsConstructor
public class UrlController {
    private final UrlService urlService;

    @PostMapping("")
    public Url createUrl( @RequestBody @Valid Url url) {
        System.out.println(urlService);
        return urlService.createUrl(url);
    }

    @GetMapping("/user/{userId}")
    public List<Url> getAllUrlByUserId(@PathVariable("userId") String userId){
        return urlService.getAllUrlForUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteUrl(@PathVariable("id") String id){
        urlService.deleteUrl(id);
    }

}
