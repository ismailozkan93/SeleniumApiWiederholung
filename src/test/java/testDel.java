import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class testDel {
    @Test
    public void Del(){
        String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJncm91cDE2ZW1wbG95ZWUiLCJhdXRoIjoiUk9MRV9FTVBMT1lFRSIsImV4cCI6MTYzOTEyMjkzMn0.A_lJ08zwQjlQHX6MsNvwNIRRRdaUMW-uiBvwsIj8cW9bhs-EBnphYqREYFCMJFJZLeak5WamDWrzkYs_1z8fbA";
        String url = "https://www.gmibank.com/api/tp-countries";

        String del_data="/113827";

        Response response;
        response = (Response) given().
                headers("Authorization", "Bearer "+token,"Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                //body(del_data).
                when().delete(url+del_data).
                then()
                .extract()
                .response();
        response.prettyPrint();

        response.then().assertThat().
                statusCode(500);

    }

}

