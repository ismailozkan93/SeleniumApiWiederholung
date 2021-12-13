import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class testPut {

@Test
    public void upDate(){
    String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJncm91cDE2ZW1wbG95ZWUiLCJhdXRoIjoiUk9MRV9FTVBMT1lFRSIsImV4cCI6MTYzOTEyMjkzMn0.A_lJ08zwQjlQHX6MsNvwNIRRRdaUMW-uiBvwsIj8cW9bhs-EBnphYqREYFCMJFJZLeak5WamDWrzkYs_1z8fbA";
    String url = "https://www.gmibank.com/api/tp-countries";

    String put_data="{\n" +
            "        \"id\": 113827,\n" +
            "        \"name\": \"Ankara\",\n" +
            "       \"states\": null\n" +
            "}";

    Response response;
    response = (Response) given().
            headers("Authorization", "Bearer "+token,"Content-Type",
                    ContentType.JSON,
                    "Accept",
                    ContentType.JSON).
            body(put_data).
            when().put(url).
            then()
            .contentType(ContentType.JSON)
            .statusCode(200)
            .extract()
            .response();
    response.prettyPrint();

    response.then().assertThat().
            statusCode(201);

}

}




