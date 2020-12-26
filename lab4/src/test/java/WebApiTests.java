import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;


public class WebApiTests {
	 	@Test
	    public void uploadTest() {
	        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));

	        File picture = new File("src/test/resources/pictureAS.jpg");

	        given()
	          .headers("Authorization","Bearer CPPB8UPk0osAAAAAAAAYL3jj0is7XQDTDIpvzO7jl0J0BYqr3bPlemDhBBl1WbkH",
	        		  "Content-Type", "application/octet-stream","Dropbox-API-Arg", 
	        		  "{\"mode\":\"add\",\"autorename\":true,\"mute\":false,\"path\":\"/pictureAS.jpg\"}")
	          .body(picture)
	        .when()
	          .post("https://content.dropboxapi.com/2/files/upload")
	        .then()
	          .statusCode(200);
	    }
	    @Test
	    public void getFileMetadataTest() {
	        Map<String,String> path = new HashMap<>();
	        path.put("path", "/pictureAS.jpg");

	        given()
	          .headers("Authorization","Bearer CPPB8UPk0osAAAAAAAAYL3jj0is7XQDTDIpvzO7jl0J0BYqr3bPlemDhBBl1WbkH",
	                  "Content-Type", "application/json")
	          .body(path)
	        .when()
	          .post("https://api.dropboxapi.com/2/files/get_metadata")
	        .then()
	          .statusCode(200);
	    }

	    @Test
	    public void deleteFileTest() {
	        Map<String,String> path = new HashMap<>();
	        path.put("path", "/pictureAS.jpg");

	        given()
	          .headers("Authorization","Bearer CPPB8UPk0osAAAAAAAAYL3jj0is7XQDTDIpvzO7jl0J0BYqr3bPlemDhBBl1WbkH",
	                  "Content-Type", "application/json")
	          .body(path)
	        .when()
	          .post("https://api.dropboxapi.com/2/files/delete_v2")
	        .then()
	          .statusCode(200);
	    }
}	    