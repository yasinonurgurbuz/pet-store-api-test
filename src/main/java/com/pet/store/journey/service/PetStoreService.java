package com.pet.store.journey.service;

import com.pet.store.journey.clients.PetStoreClient;
import com.pet.store.journey.models.request.*;
import com.pet.store.journey.models.response.LoginResponse;
import com.pet.store.journey.models.response.OrderResponse;
import com.pet.store.journey.models.response.PetResponse;
import com.pet.store.journey.models.response.UserResponse;
import io.qameta.allure.Step;

import java.util.Collections;
import java.util.List;

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

    @Step
    public UserResponse getUserByUserNameThenGetUserNotFound(String username) {
        return petStoreClient.getUserByUserNameThenGetUserNotFound(username);
    }

    @Step
    public LoginResponse getUserLogin(String username, String password) {
        return petStoreClient.getUserLogin(username, password);
    }

    @Step
    public void updateUserName(Long id, String username, String secondFirstName, String lastName, String eMail, String phone, String password, Long userStatus) {
         petStoreClient.updateUserName(CreateUserRequest.builder()
                .id(id)
                .username(username)
                .firstName(secondFirstName)
                .lastName(lastName)
                .email(eMail)
                .phone(phone)
                .password(password)
                .userStatus(userStatus)
                .build(), username);
    }

    @Step
    public void deleteUser(String username) {
        petStoreClient.deleteUser(username);
    }

    @Step
    public void createStoreOrder(Long id, Long petId, Long quantity, String shipDate, String status, Boolean complete) {
        petStoreClient.createStoreOrder(OrderRequest.builder()
                .id(id)
                .petId(petId)
                .quantity(quantity.intValue())
                .shipDate(shipDate)
                .status(status)
                .complete(complete)
                .build());
    }

    @Step
    public OrderResponse getOrderByOrderId(Long orderId) {
        return petStoreClient.getOrderByOrderId(orderId);
    }

    @Step
    public void deleteOrder(Long orderId) {
        petStoreClient.deleteOrder(orderId);
    }

    @Step
    public OrderResponse getOrderByOrderIdThenGetOrderNotFound(Long orderId) {
        return petStoreClient.getOrderByOrderIdThenGetOrderNotFound(orderId);
    }

    @Step
    public void createPet(Long id, String name, String status, String photoUrl, String categoryName, String tagName) {
        petStoreClient.createPet(PetRequest.builder()
                .id(id)
                .name(name)
                .status(status)
                .photoUrls(Collections.singletonList(photoUrl))
                .category(CategoryRequest.builder()
                        .id(0L)
                        .name(categoryName)
                        .build())
                .tags(new TagRequest[]{
                        TagRequest.builder()
                                .id(0L)
                                .name(tagName)
                                .build()
                })
                .build());
    }

    @Step
    public PetResponse getPetByPetId(Integer petId) {
        return petStoreClient.getPetByPetId(petId);
    }

    @Step
    public void updatePet(Long id, String name, String status, String photoUrl, String categoryName, String tagName) {
        petStoreClient.updatePet(PetRequest.builder()
                .id(id)
                .name(name)
                .status(status)
                .photoUrls(Collections.singletonList(photoUrl))
                .category(CategoryRequest.builder()
                        .id(0L)
                        .name(categoryName)
                        .build())
                .tags(new TagRequest[]{
                        TagRequest.builder()
                                .id(0L)
                                .name(tagName)
                                .build()
                })
                .build());
    }

    @Step
    public void deletePet(Integer petId) {
        petStoreClient.deletePet(petId);
    }

    @Step
    public PetResponse getPetByPetIdThenGetPetNotFound(Integer petId) {
        return petStoreClient.getPetByPetIdThenGetPetNotFound(petId);
    }

    @Step
    public List<PetResponse> findPetsByStatus(String status) {
        return petStoreClient.findPetsByStatus(status);
    }
}