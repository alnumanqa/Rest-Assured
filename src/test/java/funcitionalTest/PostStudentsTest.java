package funcitionalTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endpoints.Students;

public class PostStudentsTest {
	
	Students students;
	
	@BeforeMethod
	public void init() {
		students = new Students();
		students.init();
	}
	
	@Test(enabled = false)
	public void postAStudent() {
		students.postAStudent();
		students.validateStatusCode(201);
		students.validatePayloadObject("name", "Nabbel");
		students.validate_with_JsonPath("grade", "B");
	}
	

}
