package com.pet.store.journey.models.response;

import lombok.Data;

@Data
public class OrderResponse {
    public Long id;
    public Long petId;
    public Integer quantity;
    public String shipDate;
    public String status;
    public Boolean complete;
} 