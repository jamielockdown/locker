package application;

import java.util.ArrayList;

public class testClass {

	public static void test() {
		//initialise class groups
		ClassGroup c1 = new ClassGroup();
		ClassGroup c2 = new ClassGroup();

		//initialise students
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();

		//initialise names
		Name n1 = new Name();
		Name n2 = new Name();
		Name n3 = new Name();
		Name n4 = new Name();
		
		//initialise module-grades
		ModuleGrade mg1 = new ModuleGrade();
		ModuleGrade mg2 = new ModuleGrade();
		ModuleGrade mg3 = new ModuleGrade();
		ModuleGrade mg4 = new ModuleGrade();
		ModuleGrade mg5 = new ModuleGrade();
		ModuleGrade mg6 = new ModuleGrade();
		ModuleGrade mg7 = new ModuleGrade();
		ModuleGrade mg8 = new ModuleGrade();
		ModuleGrade mg9 = new ModuleGrade();
		ModuleGrade mg10 = new ModuleGrade();
		ModuleGrade mg11 = new ModuleGrade();
		ModuleGrade mg12 = new ModuleGrade();
		ModuleGrade mg13 = new ModuleGrade();
		ModuleGrade mg14 = new ModuleGrade();
		ModuleGrade mg15 = new ModuleGrade();
		ModuleGrade mg16 = new ModuleGrade();
		ModuleGrade mg17 = new ModuleGrade();
		ModuleGrade mg18 = new ModuleGrade();
		ModuleGrade mg19 = new ModuleGrade();
		ModuleGrade mg20 = new ModuleGrade();
		ModuleGrade mg21 = new ModuleGrade();
		ModuleGrade mg22 = new ModuleGrade();
		ModuleGrade mg23 = new ModuleGrade();
		ModuleGrade mg24 = new ModuleGrade();

		//set the students' name attributes
		n1.setFirstName("Jack");
		n1.setMiddleName("B.");
		n1.setLastName("Yeats");

		n2.setFirstName("William");
		n2.setMiddleName("B.");
		n2.setLastName("Yeats");

		n3.setFirstName("J.");
		n3.setMiddleName("R.R.");
		n3.setLastName("Tolkien");

		n4.setFirstName("J.");
		n4.setMiddleName("K.");
		n4.setLastName("Rowling");

		//Set the students' module names and grades
		mg1.setModule("Statistics");
		mg1.setGrade(40);
		mg2.setModule("OOP");
		mg2.setGrade(42);
		mg3.setModule("Database");
		mg3.setGrade(60);
		mg4.setModule("Server Side Web");
		mg4.setGrade(55);
		mg5.setModule("Client Side Web");
		mg5.setGrade(60);
		mg6.setModule("Systems Scripting");
		mg6.setGrade(69);
		ArrayList<ModuleGrade> grades1 = new ArrayList<ModuleGrade>();
		//add module-grades to an array for the student
		grades1.add(mg1);
		grades1.add(mg2);
		grades1.add(mg3);
		grades1.add(mg4);
		grades1.add(mg5);
		grades1.add(mg6);
		
		mg7.setModule("Statistics");
		mg7.setGrade(50);
		mg8.setModule("OOP");
		mg8.setGrade(52);
		mg9.setModule("Database");
		mg9.setGrade(70);
		mg10.setModule("Server Side Web");
		mg10.setGrade(65);
		mg11.setModule("Client Side Web");
		mg11.setGrade(70);
		mg12.setModule("Systems Scripting");
		mg12.setGrade(79);
		ArrayList<ModuleGrade> grades2 = new ArrayList<ModuleGrade>();
		grades2.add(mg7);
		grades2.add(mg8);
		grades2.add(mg9);
		grades2.add(mg10);
		grades2.add(mg11);
		grades2.add(mg12);

		mg13.setModule("Maths");
		mg13.setGrade(90);
		mg14.setModule("Physics");
		mg14.setGrade(84);
		mg15.setModule("Chemistry");
		mg15.setGrade(75);
		mg16.setModule("Mechanics");
		mg16.setGrade(65);
		mg17.setModule("Materials Technology");
		mg17.setGrade(69);
		mg18.setModule("CAD");
		mg18.setGrade(35);
		ArrayList<ModuleGrade> grades3 = new ArrayList<ModuleGrade>();
		grades3.add(mg13);
		grades3.add(mg14);
		grades3.add(mg15);
		grades3.add(mg16);
		grades3.add(mg17);
		grades3.add(mg18);

		mg19.setModule("Maths");
		mg19.setGrade(38);
		mg20.setModule("Physics");
		mg20.setGrade(40);
		mg21.setModule("Chemistry");
		mg21.setGrade(35);
		mg22.setModule("Mechanics");
		mg22.setGrade(85);
		mg23.setModule("Materials Technology");
		mg23.setGrade(72);
		mg24.setModule("CAD");
		mg24.setGrade(90);
		ArrayList<ModuleGrade> grades4 = new ArrayList<ModuleGrade>();
		grades4.add(mg19);
		grades4.add(mg20);
		grades4.add(mg21);
		grades4.add(mg22);
		grades4.add(mg23);
		grades4.add(mg24);

		//assign the names to the students
		s1.setName(n1);
		s2.setName(n2);
		s3.setName(n3);
		s4.setName(n4);

		//assign module-grades to the students
		s1.setModuleGrades(grades1);
		s2.setModuleGrades(grades2);
		s3.setModuleGrades(grades3);
		s4.setModuleGrades(grades4);

		//assign students to class groups
		c1.getStudents().add(s1);
		c1.getStudents().add(s2);

		c2.getStudents().add(s3);
		c2.getStudents().add(s4);

		//output each class's students and their module-grades
		System.out.println("Class 1:");
		for (int i = 0; i< c1.getStudents().size(); i++) {
			System.out.println(c1.getStudents().get(i).getName().getFirstName() + " " + c1.getStudents().get(i).getName().getMiddleName() + " " + c1.getStudents().get(i).getName().getLastName());
			for (int j = 0; j < c1.getStudents().get(i).getModuleGrades().size(); j++) {
				System.out.println(c1.getStudents().get(i).getModuleGrades().get(j).getModule() + " "+ c1.getStudents().get(i).getModuleGrades().get(j).getGrade());
			}
			System.out.println();
		}

		System.out.println("\n\nClass 2:");
		for (int i = 0; i< c2.getStudents().size(); i++) {
			System.out.println(c2.getStudents().get(i).getName().getFirstName() + " " + c2.getStudents().get(i).getName().getMiddleName() + " " + c2.getStudents().get(i).getName().getLastName());
			for (int j = 0; j < c2.getStudents().get(i).getModuleGrades().size(); j++) {
				System.out.println(c2.getStudents().get(i).getModuleGrades().get(j).getModule() + " " + c2.getStudents().get(i).getModuleGrades().get(j).getGrade());
			}
			System.out.println();
		}
	}
}
