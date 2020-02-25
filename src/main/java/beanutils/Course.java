package beanutils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
	private String name;
	private List<String> codes;
	private Map<String, Student> enrolledStudent = new HashMap();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getCodes() {
		return codes;
	}

	public void setCodes(List<String> codes) {
		this.codes = codes;
	}

	public Map<String, Student> getEnrolledStudent() {
		return enrolledStudent;
	}

	public void setEnrolledStudent(Map<String, Student> enrolledStudent) {
		this.enrolledStudent = enrolledStudent;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", codes=" + codes + ", enrolledStudent=" + enrolledStudent + "]";
	}
}
