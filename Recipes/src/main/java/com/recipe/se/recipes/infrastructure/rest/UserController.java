package com.recipe.se.recipes.infrastructure.rest;


import com.recipe.se.recipes.application.UserService;
import com.recipe.se.recipes.infrastructure.user.*;
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

    @PostMapping(value = "register", consumes = "application/json", produces = " application/json")
    public ResponseEntity<RegistrationResponse> register (@Valid @RequestBody RegistrationPayload registrationPayload) {

          userService.register(registrationPayload);
           {
            RegistrationResponse response = new RegistrationResponse(registrationPayload.getFirstName(), " Hello "+registrationPayload.getFirstName() + "!, You are Registered Successfully");
            return ResponseEntity.ok().body(response);
           }

    }

    @PostMapping(value = "login", consumes = "application/json", produces = "application/json")
     public ResponseEntity<LoginResponse> login(@RequestBody LoginDetails payload)
    {
        boolean isSuccessfulLogin = userService.login(payload);
        if(isSuccessfulLogin){

            LoginResponse response = new LoginResponse(payload.getUserName(), "Welcome! " +payload.getUserName(), "");
            return ResponseEntity.ok().body(response);
        }else {
            return ResponseEntity.badRequest().body(new LoginResponse("","User name or password is not valid! Please enter valid credentials","User name or password is not valid! Please enter valid credentials"));
        }
    }

    @PostMapping(value = "changePassword")
    public ResponseEntity<ChangePasswordResponse> changePassword(@RequestBody NewPassword payload) {

        if (payload.getNewPassword().equals(payload.getConfirmPassword())) {
            boolean isSucessfulChange = userService.changePassword(payload);
            if (isSucessfulChange) {
                ChangePasswordResponse response = new ChangePasswordResponse("Password has been successfully changed");
                return ResponseEntity.ok().body(response);
            } else {
                return ResponseEntity.badRequest().body(new ChangePasswordResponse("old password didnt match with password "));
            }
        }
        return ResponseEntity.badRequest().body(new ChangePasswordResponse("enter valid password"));
    }
}
