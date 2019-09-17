package application;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage)  {


		try {
			VBox vbButtons = new VBox();
			vbButtons.setPadding(new Insets(10));
			vbButtons.setSpacing(10);

			Button btnClassGroup = new Button ("Show Class Groups");
			Button btnTeachers = new Button("Show Teachers Table");
			Button btnStudents = new Button("Show Students Table");
			Button btnModuleGrades = new Button("Show Module Grades");
			vbButtons.getChildren().add(btnClassGroup);
			vbButtons.getChildren().add(btnTeachers);
			vbButtons.getChildren().add(btnStudents);
			vbButtons.getChildren().add(btnModuleGrades);

			Button btnAddClass = new Button("Add Class Group");
			Button btnRemoveClass = new Button("Remove Class Group");
			Button btnAddStudent = new Button("Add Student");
			Button btnRemoveStudent = new Button("Remove Student");
			Button btnEditModules = new Button("Edit Modules");
			Button btnEnterMark = new Button("Enter Mark");
			Button btnListByClass = new Button("List by Class");
			vbButtons.getChildren().add(btnAddClass);
			vbButtons.getChildren().add(btnRemoveClass);
			vbButtons.getChildren().add(btnAddStudent);
			vbButtons.getChildren().add(btnRemoveStudent);
			vbButtons.getChildren().add(btnEditModules);
			vbButtons.getChildren().add(btnEnterMark);
			vbButtons.getChildren().add(btnListByClass);

			VBox vbTable = new VBox();
			TableView table = new TableView();
			fillTable("select * from classgroups", table);
			vbTable.getChildren().add(table);

			HBox hbDisplay = new HBox();

			hbDisplay.getChildren().add(vbButtons);
			hbDisplay.getChildren().add(vbTable);

			Scene scene = new Scene(hbDisplay,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

			//Displays the class groups table
			btnClassGroup.setOnAction(new EventHandler<ActionEvent>(){
				@Override public void handle(ActionEvent e) {
					try {
						fillTable("select * from classgroups", table);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

			//Displays the teacher table
			btnTeachers.setOnAction(new EventHandler<ActionEvent>(){
				@Override public void handle(ActionEvent e) {
					try {
						fillTable("select * from teachers", table);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

			//Displays the student table
			btnStudents.setOnAction(new EventHandler<ActionEvent>(){
				@Override public void handle(ActionEvent e) {
					try {
						fillTable("select * from students", table);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				
				}
			});

			//Displays the module/grades table
			btnModuleGrades.setOnAction(new EventHandler<ActionEvent>(){
				@Override public void handle(ActionEvent e) {
					try {
						fillTable("select * from modulegrades", table);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});

			//Adds a class group to the database
			btnAddClass.setOnAction(new EventHandler<ActionEvent>(){
				@Override public void handle(ActionEvent e) {
					try {//Display the relevant table
						fillTable("select * from classgroups", table);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					TextInputDialog td = new TextInputDialog("Class group name?");
					td.setHeaderText("Enter the name of the new class group");
					td.showAndWait();
					//get the name/code of the new class
					String className = td.getEditor().getText();

					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					try {//connect to database and add the new class
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopproject", "root","1234");
						PreparedStatement statement = con.prepareStatement("INSERT INTO classgroups (classCode) VALUES (\""+ className +"\")");
						statement.execute();
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}


					try {//refresh classgroup table to show result of query
						fillTable("select * from classgroups", table);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
			});

			//removes a class group from the database
			btnRemoveClass.setOnAction(new EventHandler<ActionEvent>(){
				@Override public void handle(ActionEvent e) {
					try {//display relevant table (needed to obtain class id value)
						fillTable("select * from classgroups", table);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					TextInputDialog td = new TextInputDialog("Class Group ID?");
					td.setHeaderText("Enter the ID of the class group to be deleted.");
					td.showAndWait();
					//get id value of class to be deleted
					String classID = td.getEditor().getText();

					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					try {//connect to database and execute query
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopproject", "root","1234");
						PreparedStatement statement = con.prepareStatement("DELETE FROM classgroups WHERE id = "+ classID);
						statement.execute();
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					try {//refresh classgroup table to show changes
						fillTable("select * from classgroups", table);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});


			//Adds a student to the database
			btnAddStudent.setOnAction(new EventHandler<ActionEvent>(){
				@Override public void handle(ActionEvent e) {
					try {//Display the relevant table
						fillTable("select * from students", table);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					TextInputDialog stuName = new TextInputDialog("Student Name?");
					stuName.setHeaderText("Enter the name of the new student");
					TextInputDialog stuPhone = new TextInputDialog("Phone Number?");
					stuPhone.setHeaderText("Enter the student's phone number");
					TextInputDialog stuEmail = new TextInputDialog("Email?");
					stuEmail.setHeaderText("Enter the student's email address");
					TextInputDialog stuDOB = new TextInputDialog("Date of Birth?");
					stuDOB.setHeaderText("Enter the student's date of birth (YYYY-MM-DD)");
					TextInputDialog stuClass = new TextInputDialog("Class ID?");
					stuClass.setHeaderText("Enter the ID of the student's new class group");

					stuName.showAndWait();
					stuPhone.showAndWait();
					stuEmail.showAndWait();
					stuDOB.showAndWait();
					stuClass.showAndWait();

					//get the student's details
					String studentName = stuName.getEditor().getText();
					String studentPhone = stuPhone.getEditor().getText();
					String studentEmail = stuEmail.getEditor().getText();
					String studentDOB = stuDOB.getEditor().getText();
					String studentClass = stuClass.getEditor().getText();

					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					try {//connect to database and add the new student
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopproject", "root","1234");
						PreparedStatement statement = con.prepareStatement("INSERT INTO students (name, phone, email, DOB, classGroupID) VALUES (\""+ studentName +"\", \""+ studentPhone +"\", \""+ studentEmail + "\", \""+studentDOB+"\", " + studentClass+ ")");
						statement.execute();
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}


					try {//refresh student table to show result of query
						fillTable("select * from students", table);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
			});

			//removes a student from the database
			btnRemoveStudent.setOnAction(new EventHandler<ActionEvent>(){
				@Override public void handle(ActionEvent e) {
					try {//display relevant table (needed to obtain class id value)
						fillTable("select * from students", table);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					TextInputDialog td = new TextInputDialog("Student ID?");
					td.setHeaderText("Enter the ID number of the student to be deleted.");
					td.showAndWait();
					//get id value of class to be deleted
					String ID = td.getEditor().getText();

					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					try {//connect to database and execute queries
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopproject", "root","1234");
						PreparedStatement statement = con.prepareStatement("DELETE FROM students WHERE id = "+ ID);
						PreparedStatement statement2 = con.prepareStatement("DELETE FROM modulegrades WHERE studentID = "+ ID);
						statement.execute();
						statement2.execute();
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					try {//refresh student table to show changes
						fillTable("select * from students", table);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});

		} catch(Exception e) {
			e.printStackTrace();
		}
	}




	//Function for populating the tableview
	public void fillTable(String command, TableView table) throws ClassNotFoundException, SQLException {
		table.getItems().clear();//clear existing rows and columns
		table.getColumns().clear();

		Class.forName("com.mysql.jdbc.Driver");//connect to database and execute select query
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopproject", "root","1234");

		PreparedStatement statement = con.prepareStatement(command);
		ResultSet rs = statement.executeQuery();
		ObservableList<ObservableList> data = FXCollections.observableArrayList();



		for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
			//We are using non property style for making dynamic table
			final int j = i;                
			TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
			col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
				public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
					return new SimpleStringProperty(param.getValue().get(j).toString());                        
				}                    
			});

			table.getColumns().addAll(col); 
			System.out.println("Column ["+i+"] ");
		}

		while(rs.next()){
			//Iterate Row
			ObservableList<String> row = FXCollections.observableArrayList();
			for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
				//Iterate Column
				row.add(rs.getString(i));
			}
			System.out.println("Row [1] added "+row );
			data.add(row);

		}

		table.setItems(data);
		con.close();
	}



	public static void main(String[] args) {
		launch(args);

		testClass.test();
	}
}
