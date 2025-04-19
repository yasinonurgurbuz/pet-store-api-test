package com.pet.store.journey.models.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TagRequest {
    private Long id;
    private String name;
}