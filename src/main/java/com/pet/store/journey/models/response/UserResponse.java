package com.pet.store.journey.models.response;

import lombok.Getter;

@Getter
public class UserResponse {
    public Long id;
    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phone;
    public Integer userStatus;
}
