package com.pet.store.journey.stepdefinitions;

import com.pet.store.journey.base.BaseTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class StepDefinitions extends BaseTest {

    @Given("create user with given information {long} {string} {string} {string} {string} {string} {string} {long}")
    public void create_a_user(Long id, String username, String firstName, String lastName, String eMail,String phone, String password, Long userStatus) {
        petStoreService.createUser(id, username, firstName, lastName, eMail, phone, password, userStatus);
    }

    @Given("create users with given array of user")
    public void create_users_with_given_array_of_user() {
        petStoreService.createWithGivenArrayOfUsers();
    }

    @And("login with {string} {string}")
    public void login_with_user_name(String username, String password) {
        petStoreService.getUserLogin(username, password);
    }

    @When("get user by {string}")
    public void get_user_by_user_name(String username) {
        userResponse = petStoreService.getUserByUserName(username);
    }

    @When("get one of user")
    public void get_one_of_user() {
        userResponse = petStoreService.getUserByUserName("UserName1");
    }

    @When("update user information with the {long} {string} {string} {string} {string} {string} {string} {long}")
    public void update_user_information_with_the_second_first_name(Long id, String username, String secondFirstName, String lastName, String eMail,String phone, String password, Long userStatus) {
        petStoreService.updateUserName(id, username, secondFirstName, lastName, eMail, phone, password, userStatus);
    }

    @Then("check the results for given {string} {string} {string}")
    public void check_the_results_for_given_first_name_last_name_mail(String firstName, String lastName, String eMail) {
        assertThat(userResponse.getFirstName(), Matchers.equalTo(firstName));
        assertThat(userResponse.getLastName(), Matchers.equalTo(lastName));
        assertThat(userResponse.getEmail(), Matchers.equalTo(eMail));
    }

    @Then("check the results for given user")
    public void check_the_results_for_given_user() {
        assertThat(userResponse.getFirstName(), Matchers.equalTo("UserFirstName1"));
        assertThat(userResponse.getLastName(), Matchers.equalTo("UserLastName1"));
        assertThat(userResponse.getEmail(), Matchers.equalTo("user1@example.com"));
    }

    @Then("check the results for given {string} {string}")
    public void check_the_results_for_given_second_first_name(String username, String secondFirstName) {
        userResponse = petStoreService.getUserByUserName(username);
        assertThat(userResponse.getFirstName(), Matchers.equalTo(secondFirstName));
    }
}
