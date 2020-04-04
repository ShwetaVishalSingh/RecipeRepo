package com.recipe.se.recipes.infrastructure.rest;


import com.recipe.se.recipes.service.UserService;
import com.recipe.se.recipes.infrastructure.user.RegistrationPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user/")
@Validated
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "register")
    public ResponseEntity register (@Valid @RequestBody RegistrationPayload registrationPayload) {
        {
            userService.register(registrationPayload);
            return ResponseEntity.ok().body("User has been registered");
        }


    }

}
