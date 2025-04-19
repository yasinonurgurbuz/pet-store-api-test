package com.pet.store.journey.utils;

import com.pet.store.journey.Config;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.UUID;

public class ReqSpecUtil {

    public static final AllureRestAssured allureRestAssured = new AllureRestAssured();

    public static RequestSpecification prepareReq(String domain) {
        return new RequestSpecBuilder()
                .setBaseUri(Config.getProperties(domain))
                .setContentType(ContentType.JSON)
                .addHeader("x-correlationid", UUID.randomUUID().toString())
                .addHeader("x-executor-user", "Yasin Onur Gürbüz")
                .addHeader("x-agentname", "Yasin Onur Gürbüz")
                .addFilters(List.of(allureRestAssured))
                .build();
    }
}
