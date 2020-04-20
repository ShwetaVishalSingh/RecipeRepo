package com.recipe.se.recipes.domain.repository;

import com.recipe.se.recipes.infrastructure.user.LoginDetails;
import com.recipe.se.recipes.infrastructure.user.NewPassword;
import com.recipe.se.recipes.infrastructure.user.RegistrationPayload;
import com.recipe.se.recipes.infrastructure.user.RegistrationModel;

public interface UserRepository {

 RegistrationModel register(RegistrationPayload registrationPayload, String customerType);

 boolean login(LoginDetails payload);

boolean  changePassword(NewPassword payload);

 boolean checkIfUserAlreadyExist(String userName);
}
