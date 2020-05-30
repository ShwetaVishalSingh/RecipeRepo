package com.recipe.se.recipes.domain.repository;

import com.recipe.se.recipes.domain.exception.UserNotFoundException;
import com.recipe.se.recipes.domain.user.User;
import com.recipe.se.recipes.infrastructure.user.*;

import java.util.Optional;
import java.util.UUID;

public class UserDbRepository implements UserRepository {

    private final CrudUserRepository crudUserRepository;

    public UserDbRepository(CrudUserRepository crudUserRepository) {
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    public RegistrationModel register(RegistrationPayload payload) {

            User user = createUserFromPayload(payload);
            crudUserRepository.save(user);
            User result = crudUserRepository.findById(payload.getUserName()).get();
            return new RegistrationModel(result.getUserId(),result.getFirstName(),result.getLastName(),result.getUserName(),result.getPhoneNumber());

    }

    @Override
    public LoginResponse login(LoginDetails payload) {
        Optional<User> userById = crudUserRepository.findById(payload.getUserName());
        if(userById.isPresent())
        {
            User user = userById.get();
            if(user.getUserName().equals(payload.getUserName()) && user.getPassword().equals(payload.getPassword())){
                return new LoginResponse(user.getUserId(), user.getUserName(), "Welcome! " + user.getFirstName() + " " + user.getLastName(), "");
            }
        }
        return new LoginResponse("", "", "User name or password is not valid! Please enter valid credentials", "INVALID_CREDENTIAL");
    }

    @Override
    public boolean changePassword(ChangePassword payload) {
        Optional<User> userById = crudUserRepository.findByUserId(payload.getId());
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

    @Override
    public boolean checkIfUserAlreadyExist(String userName) {
        Optional<User> user = crudUserRepository.findById(userName);
        if(user.isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public UserModel fetchUserBy(String id) {
        Optional<User> databaseUser  = crudUserRepository.findByUserId(id);
        if (!databaseUser.isPresent()) {
            throw new UserNotFoundException("User is not available");
        }
            return   UserModel.convertToUser( databaseUser.get());
    }

    @Override
    public void updateUser(String userId, UserDetails userDetails)throws UserNotFoundException {
        Optional<User> databaseUser = crudUserRepository.findByUserId(userId);
        if (!databaseUser.isPresent()) {
            throw new UserNotFoundException("User Not found exception");
        }

        User userNeedsTobeUpdated = databaseUser.get();

        userNeedsTobeUpdated.setFirstName(userDetails.getFirstName());
        userNeedsTobeUpdated.setLastName(userDetails.getLastName());
        userNeedsTobeUpdated.setPhoneNumber(userDetails.getPhoneNumber());

        crudUserRepository.save(userNeedsTobeUpdated);
    }


    private User createUserFromPayload(RegistrationPayload payload) {
        return new User(UUID.randomUUID().toString(), payload.getUserName(), payload.getPassword(),
                payload.getFirstName(),payload.getLastName(),payload.getPhoneNumber(), payload.getCustomerType());
    }
}

