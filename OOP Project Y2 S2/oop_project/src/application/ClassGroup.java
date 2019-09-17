package application;

import java.util.ArrayList;

public class ClassGroup {
	private ArrayList<Student> students = new ArrayList<Student>();
	private String classCode;

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
}
