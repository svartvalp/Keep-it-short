package ru.mirea.keepitshort.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.keepitshort.entity.User;
import ru.mirea.keepitshort.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public User createUser( @RequestBody @Valid User user) {
        return  userService.register(user);
    }

    @GetMapping("/user/info")
    public User getUserInfo(Principal principal) {
        return userService.getUserInfo(principal.getName());
    }

}
