package com.recipe.se.recipes.domain.repository;

import com.recipe.se.recipes.infrastructure.user.*;

public interface UserRepository {

 RegistrationModel register(RegistrationPayload registrationPayload);

 LoginResponse login(LoginDetails payload);

boolean  changePassword(NewPassword payload);

 boolean checkIfUserAlreadyExist(String userName);
}
