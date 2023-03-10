package unitTest;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTest {

	@Test(enabled = false)
	public void getStudentsPrettyPrint() {
		RestAssured.get("http://localhost:3000/students").prettyPrint();

	}

	@Test(enabled = false)
	public void getStudents() {
		Response response = RestAssured.get(" http://localhost:3000/students");
		System.out.println(response.asPrettyString());
	}

	@Test(enabled = false)
	public void getStudents6() {
		RestAssured.get(" http://localhost:3000/students/6").prettyPrint();

	}

	@Test(enabled = false)
	public void getStudents6responseCodeValidation() {
		RestAssured.get(" http://localhost:3000/students/6")
		.then()
		.statusCode(200);

	}

	@Test(enabled = false)
	public void getStudents6NagivativeresponseCodeValidation() {
		RestAssured.get(" http://localhost:3000/students/6")
		.then()
		.statusCode(201);

	}
	@Test(enabled = false)
	public void getStudents10NagivativeresponseCodeValidation() {
		RestAssured.get(" http://localhost:3000/students/20")
		.then()
		.statusCode(404);
		
	}
	@Test(enabled = false)
	public void getStudentsLog() {
		RestAssured.given()
		.log().all()
		.get(" http://localhost:3000/students/1")
		.then()
		.log().all()
		.statusCode(200);
		
	}
	@Test(enabled = false)
	public void getStudentsResponseValidation() {
		RestAssured.given()
		.log().all()
		.get(" http://localhost:3000/students/1")
		.then()
		.log().all()
		.statusCode(200)
		.and()
		.body("id", equalTo(1))
		.body("name", equalTo("Numan"))
		.body("grade", equalTo("A"))
		.body("langague", equalTo("java"));
		
	}
	
	@Test(enabled = false)
	public void getStudentsUriPath() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.basePath("/students/2")
		.log().all()
		.get()
		.then()
		.log().all()
		.statusCode(200);
	}

}
