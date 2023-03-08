package unitTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostStudentsTest {
	@Test(enabled = false)
	public void postTestwithStringBody() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(" {\r\n"
				+ "        \"id\": 8,\r\n"
				+ "        \"name\": \"Nawang\",\r\n"
				+ "        \"grade\": \"A\",\r\n"
				+ "        \"langague\": [\r\n"
				+ "            \"C#\",\r\n"
				+ "            \"python\"\r\n"
				+ "        ]\r\n"
				+ "    }")
		.basePath("/students")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}
	@Test(enabled = true)
	public void postTestwithFile500() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(new File("src/test/resources/student1.json"))
		.basePath("/students")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(500);
	}
	@Test(enabled = false)
	public void postTestwithInputStream() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(getClass().getClassLoader().getResourceAsStream("student2.json"))
		.basePath("/students")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}
	@Test(enabled = true)
	public void postTestwithByteBody() {
		try {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(getClass().getClassLoader().getResourceAsStream("student2.json").readAllBytes())
		.basePath("/students")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(enabled = true)
	public void postTestwithMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("id", 12);
		map.put("name", "Sony");
		map.put("grade", "B");
		map.put("language", "C++");
		
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(map)
		.basePath("/students")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}

}
