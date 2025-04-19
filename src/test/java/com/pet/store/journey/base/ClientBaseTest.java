package com.pet.store.journey.base;

import com.pet.store.journey.clients.PetStoreClient;
import com.pet.store.journey.service.PetStoreService;

public class ClientBaseTest {
    public final PetStoreClient petStoreClient = new PetStoreClient();
    public final PetStoreService petStoreService = new PetStoreService(petStoreClient);
}
