package com.recipe.se.recipes.application;

import com.recipe.se.recipes.domain.repository.UserRepository;
import com.recipe.se.recipes.infrastructure.user.LoginDetails;
import com.recipe.se.recipes.infrastructure.user.NewPassword;
import com.recipe.se.recipes.infrastructure.user.RegistrationPayload;
import com.recipe.se.recipes.infrastructure.user.RegistrationModel;


public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public RegistrationModel register(RegistrationPayload registrationPayload, String customerType)
    {
        return userRepository.register(registrationPayload, customerType);
    }

    public boolean login(LoginDetails payload)
    {
        return userRepository.login(payload);
    }

    public boolean  changePassword(NewPassword payload) {
         return userRepository.changePassword(payload);
    }

    public boolean checkIfUserAlreadyExist(String userName) {

        return userRepository.checkIfUserAlreadyExist(userName);
    }
}
