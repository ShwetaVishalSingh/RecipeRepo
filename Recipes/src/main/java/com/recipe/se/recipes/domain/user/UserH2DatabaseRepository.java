package com.recipe.se.recipes.domain.user;

import com.recipe.se.recipes.infrastructure.user.RegistrationPayload;
import com.recipe.se.recipes.infrastructure.user.h2.DatabaseUserRepository;
import com.recipe.se.recipes.infrastructure.user.h2.UserDatabase;

import java.util.UUID;

public class UserH2DatabaseRepository implements UserRepository {

    private final DatabaseUserRepository databaseRepository;

    public UserH2DatabaseRepository(DatabaseUserRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    @Override
    public void register(RegistrationPayload payload) {

        UserDatabase user = createUserFromPayload(payload);

        databaseRepository.save(user);
    }

    private UserDatabase createUserFromPayload(RegistrationPayload payload) {
        return new UserDatabase(UUID.randomUUID().toString(), payload.getUserName(), payload.getPassword(),
                payload.getFirstName(),payload.getLastName(),payload.getPhoneNumber());
    }
}

