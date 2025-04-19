package com.pet.store.journey.models.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UploadImageFormDataJsonBodyRequest {
    private Long petId;
    private String additionalMetadata;
    private List<String> file;
}
