package com.recipe.se.recipes.infrastructure.rest;


import com.recipe.se.recipes.application.UserService;
import com.recipe.se.recipes.infrastructure.user.*;
import org.apache.commons.lang3.StringUtils;
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
    public ResponseEntity<RegistrationModel> register(@Valid @RequestBody RegistrationPayload registrationPayload) {

        boolean userExist = userService.checkIfUserAlreadyExist(registrationPayload.getUserName());
        if (userExist) {
            return ResponseEntity.badRequest().body(new RegistrationModel("User you trying to add already existing in our record. Please try with other user name or login with same user"));
        }
        if (registrationPayload.getPassword().equals(registrationPayload.getConfirmPassword())) {
            RegistrationModel response = userService.register(registrationPayload);
            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.badRequest().body(new RegistrationModel("Password and Confirm password does not match to each other."));

        }
    }

    @PostMapping(value = "login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDetails payload) {
        LoginResponse response = userService.login(payload);
        if (!StringUtils.isEmpty(response.getError())) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
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


