package com.recipe.se.recipes.application;

import com.recipe.se.recipes.domain.user.UserRepository;
import com.recipe.se.recipes.infrastructure.user.LoginDetails;
import com.recipe.se.recipes.infrastructure.user.NewPassword;
import com.recipe.se.recipes.infrastructure.user.RegistrationPayload;


public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public void register(RegistrationPayload registrationPayload)
    {
         userRepository.register(registrationPayload);
    }

    public boolean login(LoginDetails payload)
    {
        return userRepository.login(payload);
    }

    public boolean  changePassword(NewPassword payload) {
         return userRepository.changePassword(payload);
    }
}
