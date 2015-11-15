package fr.ktc.gradle.dockerized.tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import org.fest.assertions.api.Assertions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kevin on 08/11/2015.
 */
public class StepDefinition implements En {

    private int responseCode;
    private HttpURLConnection con;

    public StepDefinition() {
    }

    @Given("I create a HTTP request to check if my TomEE is up and running")
    public void create_request() throws IOException {
        String url = "http://tomee:8080/";

        URL obj = new URL(url);

        con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");
    }

    @When("I send the request")
    public void send_reqyest() throws IOException {
        responseCode = con.getResponseCode();
    }

    @Then("I must have a 200 HTTP response")
    public void check_response_code() {
        Assertions.assertThat(responseCode).isEqualTo(200);
    };
}
