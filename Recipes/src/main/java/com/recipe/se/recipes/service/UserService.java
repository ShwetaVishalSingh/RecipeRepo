package com.recipe.se.recipes.service;

import com.recipe.se.recipes.business.domain.user.UserRepository;
import com.recipe.se.recipes.infrastructure.user.RegistrationPayload;


public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(RegistrationPayload registrationPayload) {
        userRepository.register(registrationPayload);
    }
}
