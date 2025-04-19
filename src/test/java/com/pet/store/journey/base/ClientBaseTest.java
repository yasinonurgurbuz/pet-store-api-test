package com.pet.store.journey.base;

import com.pet.store.journey.clients.PetStoreClient;
import com.pet.store.journey.service.PetStoreService;

public class ClientBaseTest {
    public PetStoreClient petStoreClient = new PetStoreClient();
    public PetStoreService petStoreService = new PetStoreService(petStoreClient);
}
