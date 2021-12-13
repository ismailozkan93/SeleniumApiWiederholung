import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static io.restassured.RestAssured.given;
// //      headers("Authorization", "Bearer Token "+token).

public class testPost {
    @Test
    public void Post(){
    String url = "https://reqres.in/api/users/";
    String postdata = "{\n" +
            "    \"name\": \"morpheus\",\n" +
            "    \"job\": \"leader\"\n" +
            "}";
    HashMap<Object,Object> actualpost=new HashMap<>();
    actualpost.put("name","morpheus");
    actualpost.put("job","leader");

    Response response = given().
            body(postdata).
            when().post(url);
        response.prettyPrint();
        Map<Object,Object> actualdata=response.as(HashMap.class);
        System.out.println(actualpost);
        System.out.println(actualdata);
        //assertEquals("2021-12-09T10:06:20.313Z",actualdata.get("createdAt"));
        //assertEquals("625","id");
    }
    @Test
    public void xmlPost(){
        String xml="<root>\n" +
                "   <job>leader</job>\n" +
                "   <name>morpheus</name>\n" +
                "</root>\n" +
                "   ";

        String url = "https://reqres.in/api/users/";
        Response response = given().body(xml).
                        when().post(url);
        response.prettyPrint();

       response.then().assertThat().
               statusCode(201);

        System.out.println(response.as(HashMap.class));
    }
    @Test
public void gmiPost(){
        String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJncm91cDE2ZW1wbG95ZWUiLCJhdXRoIjoiUk9MRV9FTVBMT1lFRSIsImV4cCI6MTYzOTEyMjkzMn0.A_lJ08zwQjlQHX6MsNvwNIRRRdaUMW-uiBvwsIj8cW9bhs-EBnphYqREYFCMJFJZLeak5WamDWrzkYs_1z8fbA";
        String url = "https://www.gmibank.com/api/tp-countries";
    String post_data="{\n" +
            "        \"name\": \"neuhausen\",\n" +
            "        \"states\": SH\n" +
            "    }";

    //2)Set the expected data

    //3)Type automation script to send GET Request and to get response
    Response response;
    response = (Response) given().
            headers("Authorization", "Bearer "+token,"Content-Type",
                    ContentType.JSON,
                    "Accept",
                    ContentType.JSON).
            body(post_data).
            when().post(url).
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














