package com.pet.store.journey.service;

import com.pet.store.journey.clients.PetStoreClient;
import com.pet.store.journey.models.request.CreateUserRequest;
import com.pet.store.journey.models.request.UserRequest;
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
    public void createWithGivenArrayOfUsers() {
        UserRequest user1 = new UserRequest();
        user1.setId(1L);
        user1.setUsername("UserName1");
        user1.setFirstName("UserFirstName1");
        user1.setLastName("UserLastName1");
        user1.setEmail("user1@example.com");
        user1.setPassword("password123");
        user1.setPhone("123456789");
        user1.setUserStatus(1);

        UserRequest user2 = new UserRequest();
        user2.setId(2L);
        user2.setUsername("UserName2");
        user2.setFirstName("UserFirstName2");
        user2.setLastName("UserLastName2");
        user2.setEmail("user2@example.com");
        user2.setPassword("password124");
        user2.setPhone("987654321");
        user2.setUserStatus(1);

        UserRequest[] users = new UserRequest[] {user1, user2};

        petStoreClient.createWithGivenArrayOfUsers(users);
    }

    @Step
    public UserResponse getUserByUserName(String username) {
        return petStoreClient.getUserByUserName(username);
    }
}