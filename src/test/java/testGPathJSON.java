import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class testGPathJSON {
@Test
public void testGPathJSON(){
    String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJncm91cDE2ZW1wbG95ZWUiLCJhdXRoIjoiUk9MRV9FTVBMT1lFRSIsImV4cCI6MTYzOTQ2NjU3NX0.Dq8Ycm80DVJPUb8amSro3j7bljHiIeZ-_Aj12XVN2QQKN96y0Mpw_ZpRDvGLiH30qV_B8bfUACP5YpJpIszeLg";
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
    response.prettyPrint();
  /*  Map<String,?>allOfInfo=response.path("find{id=='24103'}");
    System.out.println(allOfInfo);
*/

}}

