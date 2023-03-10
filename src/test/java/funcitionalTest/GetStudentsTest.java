package funcitionalTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import endpoints.Students;

public class GetStudentsTest {
	
	Students students;
	
	@BeforeMethod
	public void initTest() {
		students = new Students();
		students.init();
		
	}
	
	@Test(enabled = false)
	public void getStudentsValidation() {
		students.getStudents();
		students.validateStatusCode(200);
	}
	
	@Test(enabled = false)
	public void getStudentsById() {
		students.getEachStudents(2);
		students.validateStatusCode(200);
		students.validatePayloadObject("name", "Arif");
		students.validatePayloadObject("grade", "A");
		students.validatePayloadObject("langague", "python");
		students.validate_with_JsonPath("id", 2);
		
	}
	
	@Test(enabled = false)
	public void responseValidation() {
		students.getEachStudents(1);
		System.out.println(students.getResponse().getBody().jsonPath().getString("name"));
		
	}
	
	
	
	
	
	
	
	
	
	

}
