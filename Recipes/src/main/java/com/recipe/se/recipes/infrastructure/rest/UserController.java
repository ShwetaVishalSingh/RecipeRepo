package com.recipe.se.recipes.infrastructure.rest;


import com.recipe.se.recipes.application.UserService;
import com.recipe.se.recipes.domain.exception.UserNotFoundException;
import com.recipe.se.recipes.infrastructure.user.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ChangePasswordResponse> changePassword(@RequestBody ChangePassword payload) {

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

    @GetMapping(value = "{id}")
    public ResponseEntity<UserModel> getUser(@PathVariable String id){

        UserModel userModel = userService.getUser(id);
        return ResponseEntity.ok().body(userModel);

    }

    @PostMapping(value = "{userId}")
    public ResponseEntity<UserUpdateModel> updateUser(@PathVariable String userId, @RequestBody UserDetails userDetails) {
        if (StringUtils.isEmpty(userId) || null == userDetails) {
            return ResponseEntity.badRequest().body(new UserUpdateModel("","Something went wrong"));
        }
        try {
            userService.updateUser(userId, userDetails);
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body( new UserUpdateModel("user is not available so we can not update it",""));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body( new UserUpdateModel("Something went wrong while updating the user","") );
        }
        return ResponseEntity.ok().body(new UserUpdateModel("User has been updated",""));
    }
}


