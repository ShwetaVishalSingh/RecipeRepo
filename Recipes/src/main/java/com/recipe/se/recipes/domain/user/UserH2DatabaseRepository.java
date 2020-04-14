package com.recipe.se.recipes.domain.user;

import com.recipe.se.recipes.infrastructure.user.LoginDetails;
import com.recipe.se.recipes.infrastructure.user.NewPassword;
import com.recipe.se.recipes.infrastructure.user.RegistrationPayload;
import com.recipe.se.recipes.infrastructure.user.RegistrationModel;
import com.recipe.se.recipes.infrastructure.user.h2.DatabaseUserRepository;
import com.recipe.se.recipes.infrastructure.user.h2.UserDatabase;

import java.util.Optional;
import java.util.UUID;

public class UserH2DatabaseRepository implements UserRepository {

    private final DatabaseUserRepository databaseRepository;

    public UserH2DatabaseRepository(DatabaseUserRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    @Override
    public RegistrationModel register(RegistrationPayload payload, String customerType) {

        UserDatabase user = createUserFromPayload(payload,customerType);
         databaseRepository.save(user);

        UserDatabase result = databaseRepository.findById(payload.getUserName()).get();
        return new RegistrationModel(result.getUserId(),result.getFirstName(),result.getLastName(),result.getUserName(),result.getPhoneNumber());

    }

    @Override
    public boolean login(LoginDetails payload) {
        Optional<UserDatabase> userById = databaseRepository.findById(payload.getUserName());
        if(userById.isPresent())
        {
            UserDatabase user = userById.get();
            return user.getUserName().equals(payload.getUserName()) && user.getPassword().equals(payload.getPassword());
        }
        return false;
    }

    @Override
    public boolean changePassword(NewPassword payload) {
        Optional<UserDatabase> userById = databaseRepository.findById(payload.getUserName());
        if (userById.isPresent()) {
            UserDatabase user = userById.get();
            if (user.getPassword().equals(payload.getOldPassword()))
            {
                user.setPassword(payload.getNewPassword());
                databaseRepository.save(user);
                return true;
            }


        }

        return false;
    }


    private UserDatabase createUserFromPayload(RegistrationPayload payload, String customerType) {
        return new UserDatabase(UUID.randomUUID().toString(), payload.getUserName(), payload.getPassword(),
                payload.getFirstName(),payload.getLastName(),payload.getPhoneNumber(), customerType);
    }
}

