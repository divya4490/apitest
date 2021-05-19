package sample;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;

public class MovieDBTest {
	
// Used for ISO Lanaguage validation
	private static final Set<String> ISO_LANGUAGES = new HashSet<String>
    (Arrays.asList(Locale.getISOLanguages()));
	
//getlatest API Test Methods
	
	public void verifyURLUpGetLatest(String api_key, String url) {
		int valid_code = 200;
		given().queryParam("api_key",api_key).when().get(url).then().log().body();
		System.out.println(given().when().get(url).getStatusCode());
		given().when().get(url).then().assertThat().statusCode(valid_code);
		
	}
	
	public void verifyURLDownGetLatest(String api_key, String url) {
		int valid_code = 200;
		given().queryParam("api_key",api_key).when().get(url).then().assertThat().statusCode(Matchers.not(valid_code));
	}
	
	
	public void validApiKeyGetLatest(String api_key, String url) {
		int valid_code = 200;
		given().queryParam("api_key",api_key).when().get(url).then().assertThat().statusCode(valid_code);
	}
	
	
	public void InvalidApiKeyGetLatest(String api_key, String url) {
		int valid_code = 401;
		given().queryParam("api_key",api_key).when().get(url).then().assertThat().statusCode(valid_code);
	}
	
	public void validURLGetLatest(String api_key, String url) {
		int valid_code = 200;
		given().queryParam("api_key",api_key).when().get(url).then().assertThat().statusCode(valid_code);
	}
	
	
	public void InvalidURLGetLatest(String api_key, String url) {
		int valid_code = 402;
		given().queryParam("api_key",api_key).when().get(url).then().assertThat().statusCode(valid_code);
	}
	

	//Assumed that good response time if it is less than 5000 milliseconds for this project.
	public void responseTimeGoodGetLatest(String api_key, String url) {
		long goodResponseTime = 5000;
		given().queryParam("api_key",api_key).when().get(url).then().time(Matchers.lessThan(goodResponseTime));
	}
	
	
	//Assumed that good response time if it is less than 5000 milliseconds for this project.
	public void responseTimeDelayedGetLatest(String api_key, String url) {
		long goodResponseTime = 5000;
		given().queryParam("api_key",api_key).when().get(url).then().time(Matchers.greaterThan(goodResponseTime));
	}
	

	public void allValidValuesRateMovie(String api_key, String url, int movie_id, String content_type, float rating) {
//		String valid_code = 201;
		JSONObject requestParam = new JSONObject();
		requestParam.put("value", rating);
		RestAssured.baseURI = url;
		String postURL = "/3/movie/"+ movie_id +"/rating";
		given().queryParam("api_key",api_key)
        .contentType(ContentType.JSON)
        .body(requestParam)
        .post(postURL)
        .then()
        .statusCode(201)
        .extract()
        .response();

		
	}
	
	
}
