package unitTest;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutTest {
	@Test(enabled = true)
	public void putTest() {
		Map<String, Object> map = new HashMap<>();
		map.put("id", 9);
		map.put("name", "Nargis");
		map.put("grade", "A-");
		map.put("language", "ruby");
		
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.basePath("/students/9")//end-points
		.contentType(ContentType.JSON)
		.body(map)
		.log().all()
		.put()
		.then()
		.log().all()
		.statusCode(200);
		
	}

}
