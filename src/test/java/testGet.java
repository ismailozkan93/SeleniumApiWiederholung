import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;

public class testGet {
    @Test
    public void secondTest(){
        //String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJncm91cDE2ZW1wbG95ZWUiLCJhdXRoIjoiUk9MRV9FTVBMT1lFRSIsImV4cCI6MTYzOTEyMjkzMn0.A_lJ08zwQjlQHX6MsNvwNIRRRdaUMW-uiBvwsIj8cW9bhs-EBnphYqREYFCMJFJZLeak5WamDWrzkYs_1z8fbA";
        String url = "https://reqres.in/api/users/";

        //2)Set the expected data

        //3)Type automation script to send GET Request and to get response
        Response response = given().
          //      headers("Authorization", "Bearer Token "+token).
        when().get(url);
        response.prettyPrint();

       response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("page",equalTo(1)).
                body("per_page",equalTo(6)).
                body("total",equalTo(12)).
               body("data.id[0]",equalTo(1));


        JsonPath jsonPath=response.jsonPath();
        System.out.println("***************");
        System.out.println(jsonPath.get().toString());
       assertEquals(1,jsonPath.getInt("page"));
       assertEquals(6,jsonPath.getInt("per_page"));
       assertEquals(12,jsonPath.getInt("total"));
       List<Object>listdata=new ArrayList<>();
       listdata=jsonPath.get("data");
        System.out.println(listdata);
     //  assertEquals(1,jsonPath.getInt("data.id"));
    }

    @Test
            public void gmiApi(){
    String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJncm91cDE2ZW1wbG95ZWUiLCJhdXRoIjoiUk9MRV9FTVBMT1lFRSIsImV4cCI6MTYzOTIwOTkyNn0.u-FObqtIogKoO7bLZ4LU_KBmFLOiD4OrLBmhQt3-a0sdQBitVzrTzZKHf3t3slsV-3GlT1KQBvaLhWpmCaGo2g";
    String url = "https://www.gmibank.com/api/tp-countries";

    //2)Set the expected data

    //3)Type automation script to send GET Request and to get response
    Response response;
        response = (Response) given().
                headers("Authorization", "Bearer "+token,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                        when().get(url).
                        then()
                        .contentType(ContentType.JSON)
                    .statusCode(200)
                    .extract()
                    .response();

      //  response.prettyPrint();

        //System.out.println(response.asString());
        response.then().body("id[0]",equalTo(24115));

        //to extract Headers
        Headers headers=response.getHeaders();

        String contentType=response.getHeader("Content-Type");
        System.out.println(contentType);
        System.out.println();
        List<String>teamCountry=response.path("name");
        System.out.println(teamCountry);
        System.out.println();
        System.out.println(response.path("id").toString());
    response.then().assertThat().
    statusCode(200);
            JsonPath jsonPath=response.jsonPath();
        System.out.println( jsonPath.getString("id"));
        System.out.println(jsonPath.getString("name"));
        System.out.println(jsonPath.getString("states"));
        Assert.assertTrue(jsonPath.getString("id").contains("24109"));
        response.prettyPrint();
        }

@Test
public void captureResponseTime(){
    ValidatableResponse responseTime;
    String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJncm91cDE2ZW1wbG95ZWUiLCJhdXRoIjoiUk9MRV9FTVBMT1lFRSIsImV4cCI6MTYzOTIwOTkyNn0.u-FObqtIogKoO7bLZ4LU_KBmFLOiD4OrLBmhQt3-a0sdQBitVzrTzZKHf3t3slsV-3GlT1KQBvaLhWpmCaGo2g";
    String url = "https://www.gmibank.com/api/tp-countries";

    //2)Set the expected data

    //3)Type automation script to send GET Request and to get response
    Response response;
    //responseTime=get(url).time();
    responseTime=given().
            headers("Authorization", "Bearer "+token,"Content-Type",
                    ContentType.JSON,
                    "Accept",
                    ContentType.JSON).
            when().get(url).then().time(lessThan(1500L));//Assertion
    System.out.println("Response Time"+ responseTime);

    }





    @Test
    public void pathParam(){
        String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJncm91cDE2ZW1wbG95ZWUiLCJhdXRoIjoiUk9MRV9FTVBMT1lFRSIsImV4cCI6MTYzOTEyMjkzMn0.A_lJ08zwQjlQHX6MsNvwNIRRRdaUMW-uiBvwsIj8cW9bhs-EBnphYqREYFCMJFJZLeak5WamDWrzkYs_1z8fbA";
        String url = "https://www.gmibank.com/api/tp-countries";

        given().headers("Authorization", "Bearer "+token,"Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                pathParam("id", 24115).
                when().
                get(url).
                then();

    }
    @Test
    public void paramQueryTest(){
        //String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJncm91cDE2ZW1wbG95ZWUiLCJhdXRoIjoiUk9MRV9FTVBMT1lFRSIsImV4cCI6MTYzOTEyMjkzMn0.A_lJ08zwQjlQHX6MsNvwNIRRRdaUMW-uiBvwsIj8cW9bhs-EBnphYqREYFCMJFJZLeak5WamDWrzkYs_1z8fbA";
        String url = "http://api.football-data.org/v2/areas";

        //2)Set the expected data

        //3)Type automation script to send GET Request and to get response
        Response response = given().
                //      headers("Authorization", "Bearer Token "+token).
                        when().get(url);
        response.prettyPrint();


        response.then().assertThat().contentType(ContentType.JSON).
                body("areas.id[0]",equalTo(2000));

    }

    }


