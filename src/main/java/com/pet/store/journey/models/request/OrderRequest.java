package com.pet.store.journey.models.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderRequest {
    private Long id;
    private Long petId;
    private Integer quantity;
    private String shipDate;
    private String status;
    private Boolean complete;
} 