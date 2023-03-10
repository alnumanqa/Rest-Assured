package endpoints;

import utils.RestSpecifications;

public class Students extends RestSpecifications {
	
	private final String ENDPOINT = "/students";
	private final String fileName = "students3.json";
	
	public void getStudents() {
		getCall(ENDPOINT);
	}
	
	public void getEachStudents(int studentsId) {
		getCall(ENDPOINT + "/" + studentsId);
	}
	
	public void postAStudent() {
		setBody(getClass().getClassLoader().getResourceAsStream(fileName));
		setContentTypeJson();
		postCall(ENDPOINT);
	}

}
