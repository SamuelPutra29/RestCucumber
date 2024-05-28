package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;

public class Products {

    @Given("I hit the url of get products api endpoint")
    public void i_hit_the_url_of_get_products_api_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        RequestSpecification request = RestAssured.given();
        Response response = RestAssured.get("/products");

        int ResponseCode = response.getStatusCode();
        assertEquals(200, ResponseCode);





    }

    @When("I pass the url of products in the request")
    public void i_pass_the_url_of_products_in_the_request() {

    }

    @Then("I receive the response code as {int}")
    public void i_receive_the_response_code_as(Integer int1) {

    }
}
