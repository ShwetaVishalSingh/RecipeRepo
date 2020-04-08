package com.recipe.se.recipes.infrastructure.rest;


import com.recipe.se.recipes.application.UserService;
import com.recipe.se.recipes.infrastructure.user.LoginDetails;
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

    @PostMapping(value = "login")
     public ResponseEntity login(@RequestBody LoginDetails payload)
    {
        boolean isSuccessfulLogin = userService.login(payload);
        if(isSuccessfulLogin){

            return ResponseEntity.ok().body("Successful login");
        }else {
            return ResponseEntity.badRequest().body("User name or Password is invalid");
        }
    }

}
