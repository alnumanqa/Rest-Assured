package funcitionalTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endpoints.Students;

public class DeleteStudentsTest {
	
Students students;
	
	@BeforeMethod
	public void init() {
		students = new Students();
		students.init();
	}
	
	@Test(enabled = true)
	public void deleteAStudent() {
		
	}

}
