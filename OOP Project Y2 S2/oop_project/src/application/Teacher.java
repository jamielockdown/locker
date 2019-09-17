package application;

public class Teacher extends Person {
	private String degreeTitle;
	private int degreeLevel;
	
	public String getDegreeTitle() {
		return degreeTitle;
	}
	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}
	public int getDegreeLevel() {
		return degreeLevel;
	}
	public void setDegreeLevel(int degreeLevel) {
		this.degreeLevel = degreeLevel;
	}
	
	public void editDegree(String newTitle, int newLevel) {
		degreeTitle = newTitle;
		degreeLevel = newLevel;
		//message of confirmation to be added
	}
}
