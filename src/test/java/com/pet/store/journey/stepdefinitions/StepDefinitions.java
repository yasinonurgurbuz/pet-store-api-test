package com.pet.store.journey.stepdefinitions;

import com.pet.store.journey.base.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class StepDefinitions extends BaseTest {

    @Given("create user with given information {long} {string} {string} {string} {string} {string} {string} {long}")
    public void create_a_user(Long id, String username, String firstName, String lastName,String eMail,String phone, String password, Long userStatus) {
        petStoreService.createUser(id, username, firstName, lastName, eMail, phone, password, userStatus);
    }

    @When("get user by {string}")
    public void get_user_by_user_name(String username) {
        userResponse = petStoreService.getUserByUserName(username);
    }

    @Then("check the results for given {string} {string} {string}")
    public void check_the_results_for_given_first_name_last_name_mail(String firstName, String lastName, String eMail) {
        assertThat(userResponse.getFirstName(), Matchers.equalTo(firstName));
        assertThat(userResponse.getLastName(), Matchers.equalTo(lastName));
        assertThat(userResponse.getEmail(), Matchers.equalTo(eMail));
    }
}
