package stepdefinitions;

import com.google.gson.JsonObject;
import cucumber.api.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;


public class Products {

    public Response response;
    public int StatusCode;
    public RequestSpecification httpRequest;
    public int ResponseCode;
    public ResponseBody body;

    @Given("I hit the url of get products api endpoint")
    public void i_hit_the_url_of_get_products_api_endpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
    }

    @When("I pass the url of products in the request")
    public void i_pass_the_url_of_products_in_the_request() {
        httpRequest = given();
        response = httpRequest.get("products");

    }

    @Then("I receive the response code as {int}")
    public void i_receive_the_response_code_as(Integer int1) {
        ResponseCode = response.getStatusCode();
        assertEquals(200, ResponseCode);

    }



    @Then("I verify that the rate of the first product is {}")
    public void iVerifyThatTheRateOfTheFirstProductIs(String rate) {

        body =response.getBody();

        // convert response body to string
        String responseBody = body.asString();

        //JSON representation from Response Body
        JsonPath jsnpath = response.jsonPath();
        String s = jsnpath.getJsonObject("rating[0].rate").toString();

        assertEquals(rate, s);
    }

    @Given("I hit the url of post products api endpoint")
    public void iHitTheUrlOfPostProductsApiEndpoint() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest = given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("title", "shoes");
        requestParams.put("price", 100);
        requestParams.put("description", "shoes for men");
        requestParams.put("image", "https://i.pravatar.cc");
        requestParams.put("category", "shoes");

        httpRequest.body(requestParams.toString());
        Response response =httpRequest.post("products");
        ResponseBody body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());


    }


    @Then("I pass the request body of product title {}")
    public void iPassTheRequestBodyOfProductTitle(String arg0) {
    }
}