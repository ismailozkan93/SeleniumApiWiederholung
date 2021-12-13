import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Serialization {
    @Test
    public void GmiBankSerialization() {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJncm91cDE2ZW1wbG95ZWUiLCJhdXRoIjoiUk9MRV9FTVBMT1lFRSIsImV4cCI6MTYzOTIwOTkyNn0.u-FObqtIogKoO7bLZ4LU_KBmFLOiD4OrLBmhQt3-a0sdQBitVzrTzZKHf3t3slsV-3GlT1KQBvaLhWpmCaGo2g";
        String url = "https://www.gmibank.com/api/tp-countries";
   GmiBank gmiBank=new GmiBank("115","Turkey","Europa");

        Response response;
        response = (Response) given().
                headers("Authorization", "Bearer "+token,"Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                body(gmiBank).
                when().post(url).
                then()
                .contentType(ContentType.JSON)
                .statusCode(201)
                .extract()
                .response();
        response.prettyPrint();

        response.then().assertThat().
                statusCode(201);
    }
    @Test
    public void XMLSchema(){
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJncm91cDE2ZW1wbG95ZWUiLCJhdXRoIjoiUk9MRV9FTVBMT1lFRSIsImV4cCI6MTYzOTIwOTkyNn0.u-FObqtIogKoO7bLZ4LU_KBmFLOiD4OrLBmhQt3-a0sdQBitVzrTzZKHf3t3slsV-3GlT1KQBvaLhWpmCaGo2g";
        String url = "https://www.gmibank.com/api/tp-countries";

        Response response;
        response = (Response) given().
                headers("Authorization", "Bearer "+token,"Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                when().get(url).
                then().body(matchesXsdInClasspath("VideoGameXSD.xsd"))
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract()
                .response();
        response.prettyPrint();

    }
    @Test
    public void JSONSchema(){
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJncm91cDE2ZW1wbG95ZWUiLCJhdXRoIjoiUk9MRV9FTVBMT1lFRSIsImV4cCI6MTYzOTIwOTkyNn0.u-FObqtIogKoO7bLZ4LU_KBmFLOiD4OrLBmhQt3-a0sdQBitVzrTzZKHf3t3slsV-3GlT1KQBvaLhWpmCaGo2g";
        String url = "https://www.gmibank.com/api/tp-countries";

        Response response;
        response = (Response) given().
                headers("Authorization", "Bearer "+token,"Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                when().get(url).
                then().body(matchesJsonSchemaInClasspath("GmiBankJsonSchema.json"))
               // .contentType(ContentType.JSON)
                .statusCode(200)
               .extract()
                .response();
        response.prettyPrint();

    }
    @Test
    public void convertJSONToPojo(){
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJncm91cDE2ZW1wbG95ZWUiLCJhdXRoIjoiUk9MRV9FTVBMT1lFRSIsImV4cCI6MTYzOTIwOTkyNn0.u-FObqtIogKoO7bLZ4LU_KBmFLOiD4OrLBmhQt3-a0sdQBitVzrTzZKHf3t3slsV-3GlT1KQBvaLhWpmCaGo2g";
        String url = "https://www.gmibank.com/api/tp-countries";
        GmiBank gmiBank=new GmiBank("115","Turkey","Europa");

        Response response;
        response = (Response) given().
                headers("Authorization", "Bearer "+token,"Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                when().get(url).then()
                //.contentType(ContentType.JSON)
               // .statusCode(201)
                .extract()
                .response();
        //response.prettyPrint();

        GmiBank gmiBank1=response.getBody().as(GmiBank.class);
       System.out.println(gmiBank1.toString());

        //response.then().assertThat().
          //      statusCode(200);
    }

    }
