package com.pet.store.journey.models.response;

import com.pet.store.journey.models.request.CategoryRequest;
import com.pet.store.journey.models.request.TagRequest;
import lombok.Data;

@Data
public class PetResponse {
    public Integer id;
    public CategoryRequest category;
    public String name;
    public String[] photoUrls;
    public TagRequest[] tags;
    public String status;
} 