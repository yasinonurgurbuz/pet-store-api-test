package com.pet.store.journey.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonSerializer {
    private static final Gson GSON = new GsonBuilder().serializeNulls().create();

    public static Gson getGson() {
        return GSON;
    }
}
