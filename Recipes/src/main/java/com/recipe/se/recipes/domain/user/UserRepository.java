package com.recipe.se.recipes.domain.user;

import com.recipe.se.recipes.infrastructure.user.LoginDetails;
import com.recipe.se.recipes.infrastructure.user.NewPassword;
import com.recipe.se.recipes.infrastructure.user.RegistrationPayload;

public interface UserRepository {

 void register(RegistrationPayload registrationPayload);

 boolean login(LoginDetails payload);

boolean  changePassword(NewPassword payload);
}
