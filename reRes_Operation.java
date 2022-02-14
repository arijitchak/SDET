package stepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class reRes_Operation {
	
//	Given To get the List of Users using Get
//    When Create Users using Post
//    Then Update User using Put method
//    When Delete user using Delete

	//@Test
	@Given("To get the List of Users using Get")
	public void To_get_the_List_of_Users_using_Get() {
		
		//1. Base URI
		RestAssured.baseURI="https://reqres.in";
		//2. Request Specification
//		RequestSpecification httpReq= RestAssured.given().when().get("/api/users?page=2");
//		io.restassured.response.Response res=httpReq.request(Method.GET);
		Response res=RestAssured.given().when().get("/api/users?page=2");
		
		//3. Reading Reponse--Parsing Repsonse
		String respBody=res.getBody().asString();
    	//4. Validation
			System.out.println(respBody);
	
	}
  //@Test	
  @And("Create Users using Post")
	
			public void Create_Users_using_Post() {
		
		       File jsonFile=new File("C:\\Users\\03800E744\\eclipse-workspace\\Reskill\\Request_Post.json");				
				//1. Base URI
				RestAssured.baseURI="https://reqres.in/api/users";
//				//2. Request Specification
				Header acceptHeader = new Header("Content-Type","application/json");
			    RequestSpecification httpReq=RestAssured.given().header(acceptHeader).body(jsonFile);
				
//				RequestSpecification httpReq=RestAssured.given();
				io.restassured.response.Response res=httpReq.request(Method.POST);
				
//				//3. Reading Reponse--Parsing Response
//			    Response res=httpReq.request(Method.POST);
				res.getBody().prettyPrint();
  }
	@Then("Update User using Put method")
	
	   public void Update_User_using_Put_method() throws IOException {
		
		File jsonFile1=new File("C:\\Users\\03800E744\\eclipse-workspace\\Reskill\\Update_Post.json");
		FileInputStream inFile = new FileInputStream(jsonFile1);
		int oneByte;
		while ((oneByte = inFile.read()) != -1) {
			System.out.write(oneByte);
		}
        
		//1. Base URI
				RestAssured.baseURI="https://reqres.in/api/";
				//2. Request Specification

				//Response res1=RestAssured.given().when().get("/api/users/2");
				Header acceptHeader = new Header("Content-Type","application/json");
			    RequestSpecification httpReq=RestAssured.given().header(acceptHeader).body(jsonFile1);
			    io.restassured.response.Response res=httpReq.request(Method.PUT);
			    res=httpReq.post("users/2");
				
				
				//3. Reading Reponse--Parsing Repsonse
				//String respBody=res.getBody().asString();
		    	//4. Validation
				//	System.out.println(respBody);
			    //System.out.;
			    
			   
			    res.getBody().prettyPrint();
	}
	
	  
}
