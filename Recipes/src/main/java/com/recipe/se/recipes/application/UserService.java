package com.recipe.se.recipes.application;

import com.recipe.se.recipes.domain.repository.UserRepository;
import com.recipe.se.recipes.infrastructure.user.*;


public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public RegistrationModel register(RegistrationPayload registrationPayload)
    {
        return userRepository.register(registrationPayload);
    }

    public LoginResponse login(LoginDetails payload)
    {
        return userRepository.login(payload);
    }

    public boolean  changePassword(NewPassword payload) {
         return userRepository.changePassword(payload);
    }

    public boolean checkIfUserAlreadyExist(String userName) {

        return userRepository.checkIfUserAlreadyExist(userName);
    }

    public UserModel getUser(String id) {
      return userRepository.fetchUserBy(id);
    }
}
