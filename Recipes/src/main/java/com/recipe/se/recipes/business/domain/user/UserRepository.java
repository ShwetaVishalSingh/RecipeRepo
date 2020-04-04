package com.recipe.se.recipes.business.domain.user;

import com.recipe.se.recipes.infrastructure.user.RegistrationPayload;

public interface UserRepository {

    void register(RegistrationPayload registrationPayload);



}
