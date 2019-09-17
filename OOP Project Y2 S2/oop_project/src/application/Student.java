package application;
import java.util.ArrayList;
import java.util.Date;

public class Student extends Person{
	private Date dob;
	private ArrayList<ModuleGrade> moduleGrades = new ArrayList<ModuleGrade>();
	
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public ArrayList<ModuleGrade> getModuleGrades() {
		return moduleGrades;
	}
	public void setModuleGrades(ArrayList<ModuleGrade> moduleGrades) {
		this.moduleGrades = moduleGrades;
	}
}
