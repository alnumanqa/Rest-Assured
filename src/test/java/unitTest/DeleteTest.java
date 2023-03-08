package unitTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteTest {
	
	@Test(enabled = true)
	public void deleteTest() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.basePath("/students/8")
		.log().all()
		.delete()
		.then()
		.log().all()
		.statusCode(200);
	}

}
