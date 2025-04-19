package com.pet.store.journey.clients;

import com.pet.store.journey.enums.TimeConstants;
import com.pet.store.journey.models.request.CreateUserRequest;
import com.pet.store.journey.models.request.UserRequest;
import com.pet.store.journey.models.request.OrderRequest;
import com.pet.store.journey.models.request.PetRequest;
import com.pet.store.journey.models.response.LoginResponse;
import com.pet.store.journey.models.response.UserResponse;
import com.pet.store.journey.models.response.OrderResponse;
import com.pet.store.journey.models.response.PetResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import java.time.Duration;

import static com.pet.store.journey.utils.GsonSerializer.getGson;
import static io.restassured.RestAssured.given;
import static com.pet.store.journey.utils.ReqSpecUtil.prepareReq;
import static org.awaitility.Awaitility.await;

public class PetStoreClient {

    private final RequestSpecification request;

    public PetStoreClient() {
        this.request = prepareReq("PET_STORE_API_URL");
    }

    public void createUser(CreateUserRequest createUserRequest) {
        given()
                .spec(request)
                .body(getGson().toJson(createUserRequest))
                .when()
                .post("/v2/user")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    public void updateUserName(CreateUserRequest createUserRequest, String userName) {
        given()
                .spec(request)
                .body(getGson().toJson(createUserRequest))
                .when()
                .put("/v2/user/"+ userName)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    public void createWithGivenArrayOfUsers(UserRequest[] users) {
        given()
                .spec(request)
                .body(users)
                .when()
                .post("/v2/user/createWithArray")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    public UserResponse getUserByUserName(String username) {
        return getGson().fromJson(
                await().atMost(Duration.ofSeconds(TimeConstants.DURATION))
                        .pollInterval(Duration.ofSeconds(TimeConstants.POLLINTERVAL))
                        .ignoreExceptions()
                        .until(() -> given()
                                .spec(request)
                                .get("/v2/user/" + username)
                                .then()
                                .assertThat()
                                .extract(), p -> p.statusCode() == HttpStatus.SC_OK).response().getBody().asString(), UserResponse.class);
    }

    public UserResponse getUserByUserNameThenGetUserNotFound(String username) {
        return getGson().fromJson(
                await().atMost(Duration.ofSeconds(TimeConstants.DURATION))
                        .pollInterval(Duration.ofSeconds(TimeConstants.POLLINTERVAL))
                        .ignoreExceptions()
                        .until(() -> given()
                                .spec(request)
                                .get("/v2/user/" + username)
                                .then()
                                .assertThat()
                                .extract(), p -> p.statusCode() == HttpStatus.SC_NOT_FOUND).response().getBody().asString(), UserResponse.class);
    }

    public LoginResponse getUserLogin(String username, String password) {
        return getGson().fromJson(
                await().atMost(Duration.ofSeconds(TimeConstants.DURATION))
                        .pollInterval(Duration.ofSeconds(TimeConstants.POLLINTERVAL))
                        .ignoreExceptions()
                        .until(() -> given()
                                .spec(request)
                                .get("/v2/user/login?username=" + username + "&password="+ password)
                                .then()
                                .assertThat()
                                .extract(), p -> p.statusCode() == HttpStatus.SC_OK).response().getBody().asString(), LoginResponse.class);
    }

    public void deleteUser(String username) {
        await().atMost(Duration.ofSeconds(TimeConstants.DURATION))
                .pollInterval(Duration.ofSeconds(TimeConstants.POLLINTERVAL))
                .ignoreExceptions()
                .until(() -> given()
                        .spec(request)
                        .delete("/v2/user/" + username)
                        .then()
                        .assertThat()
                        .extract(), p -> p.statusCode() == HttpStatus.SC_OK);
    }

    public OrderResponse getOrderByOrderId(Long orderId) {
        return getGson().fromJson(
                await().atMost(Duration.ofSeconds(TimeConstants.DURATION))
                        .pollInterval(Duration.ofSeconds(TimeConstants.POLLINTERVAL))
                        .ignoreExceptions()
                        .until(() -> given()
                                .spec(request)
                                .get("/v2/store/order/" + orderId)
                                .then()
                                .assertThat()
                                .extract(), p -> p.statusCode() == HttpStatus.SC_OK).response().getBody().asString(), OrderResponse.class);
    }

    public void createStoreOrder(OrderRequest orderRequest) {
        given()
                .spec(request)
                .body(getGson().toJson(orderRequest))
                .when()
                .post("/v2/store/order")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    public void deleteOrder(Long orderId) {
        await().atMost(Duration.ofSeconds(TimeConstants.DURATION))
                .pollInterval(Duration.ofSeconds(TimeConstants.POLLINTERVAL))
                .ignoreExceptions()
                .until(() -> given()
                        .spec(request)
                        .delete("/v2/store/order/" + orderId)
                        .then()
                        .assertThat()
                        .extract(), p -> p.statusCode() == HttpStatus.SC_OK);
    }

    public OrderResponse getOrderByOrderIdThenGetOrderNotFound(Long orderId) {
        return getGson().fromJson(
                await().atMost(Duration.ofSeconds(TimeConstants.DURATION))
                        .pollInterval(Duration.ofSeconds(TimeConstants.POLLINTERVAL))
                        .ignoreExceptions()
                        .until(() -> given()
                                .spec(request)
                                .get("/v2/store/order/" + orderId)
                                .then()
                                .assertThat()
                                .extract(), p -> p.statusCode() == HttpStatus.SC_NOT_FOUND).response().getBody().asString(), OrderResponse.class);
    }

    public void createPet(PetRequest petRequest) {
        given()
                .spec(request)
                .body(getGson().toJson(petRequest))
                .when()
                .post("/v2/pet")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    public PetResponse getPetByPetId(Integer petId) {
        return getGson().fromJson(
                await().atMost(Duration.ofSeconds(TimeConstants.DURATION))
                        .pollInterval(Duration.ofSeconds(TimeConstants.POLLINTERVAL))
                        .ignoreExceptions()
                        .until(() -> given()
                                .spec(request)
                                .get("/v2/pet/" + petId)
                                .then()
                                .assertThat()
                                .extract(), p -> p.statusCode() == HttpStatus.SC_OK).response().getBody().asString(), PetResponse.class);
    }

    public void updatePet(PetRequest petRequest) {
        given()
                .spec(request)
                .body(getGson().toJson(petRequest))
                .when()
                .put("/v2/pet")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
