package com.recipe.se.recipes.domain.repository;

import com.recipe.se.recipes.domain.user.User;
import com.recipe.se.recipes.infrastructure.user.LoginDetails;
import com.recipe.se.recipes.infrastructure.user.NewPassword;
import com.recipe.se.recipes.infrastructure.user.RegistrationPayload;
import com.recipe.se.recipes.infrastructure.user.RegistrationModel;

import java.util.Optional;
import java.util.UUID;

public class UserDbRepository implements UserRepository {

    private final CrudUserRepository crudUserRepository;

    public UserDbRepository(CrudUserRepository crudUserRepository) {
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    public RegistrationModel register(RegistrationPayload payload, String customerType) {

        User user = createUserFromPayload(payload,customerType);
        crudUserRepository.save(user);

        User result = crudUserRepository.findById(payload.getUserName()).get();
        return new RegistrationModel(result.getUserId(),result.getFirstName(),result.getLastName(),result.getUserName(),result.getPhoneNumber());

    }

    @Override
    public boolean login(LoginDetails payload) {
        Optional<User> userById = crudUserRepository.findById(payload.getUserName());
        if(userById.isPresent())
        {
            User user = userById.get();
            return user.getUserName().equals(payload.getUserName()) && user.getPassword().equals(payload.getPassword());
        }
        return false;
    }

    @Override
    public boolean changePassword(NewPassword payload) {
        Optional<User> userById = crudUserRepository.findById(payload.getUserName());
        if (userById.isPresent()) {
            User user = userById.get();
            if (user.getPassword().equals(payload.getOldPassword()))
            {
                user.setPassword(payload.getNewPassword());
                crudUserRepository.save(user);
                return true;
            }


        }

        return false;
    }


    private User createUserFromPayload(RegistrationPayload payload, String customerType) {
        return new User(UUID.randomUUID().toString(), payload.getUserName(), payload.getPassword(),
                payload.getFirstName(),payload.getLastName(),payload.getPhoneNumber(), customerType);
    }
}

