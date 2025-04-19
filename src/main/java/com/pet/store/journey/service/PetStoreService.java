package com.pet.store.journey.service;

import com.pet.store.journey.clients.PetStoreClient;
import com.pet.store.journey.models.request.CreateUserRequest;
import com.pet.store.journey.models.response.UserResponse;
import io.qameta.allure.Step;

public class PetStoreService {
    public final PetStoreClient petStoreClient;

    public PetStoreService(PetStoreClient petStoreClient) {
        this.petStoreClient = petStoreClient;
    }

    @Step
    public void createUser(Long id, String username, String firstName, String lastName, String email, String phone, String password, Long userStatus) {
        petStoreClient.createUser(CreateUserRequest.builder()
                .id(id)
                .username(username)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phone(phone)
                .password(password)
                .userStatus(userStatus)
                .build());
    }

    @Step
    public UserResponse getUserByUserName(String username) {
        return petStoreClient.getUserByUserName(username);
    }
}