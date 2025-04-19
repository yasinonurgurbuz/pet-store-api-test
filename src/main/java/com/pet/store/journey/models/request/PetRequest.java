package com.pet.store.journey.models.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PetRequest {
    private Long id;
    private CategoryRequest category;
    private String name;
    private List<String> photoUrls;
    private TagRequest[] tags;
    private String status;
}