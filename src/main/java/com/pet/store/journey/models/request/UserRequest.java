package com.pet.store.journey.models.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    public Long id;
    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phone;
    public Integer userStatus;
}
