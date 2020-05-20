package com.recipe.se.recipes.domain.repository;

import com.recipe.se.recipes.domain.exception.UserNotFoundException;
import com.recipe.se.recipes.infrastructure.user.*;

public interface UserRepository {

 RegistrationModel register(RegistrationPayload registrationPayload);

 LoginResponse login(LoginDetails payload);

boolean  changePassword(ChangePassword payload);

 boolean checkIfUserAlreadyExist(String userName);

 UserModel fetchUserBy(String id);

 void updateUser(String userId, UserDetails userDetails)throws UserNotFoundException;
}
