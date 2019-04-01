import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAO {

	public Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			String dbURL = "jdbc:sqlite:studentdb.sqlite";
			dbConnection = DriverManager.getConnection(dbURL);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	public ArrayList<Student> getAllStudents() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet resultset = null;
		String query = "SELECT * FROM students;";
		Student temp = null;
		ArrayList<Student> allStudents = new ArrayList<>();

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(query);
			// execute SQL query
			resultset = statement.executeQuery(query);
			while (resultset.next()) {

				String name = resultset.getString("Name");
				String gender = resultset.getString("Gender");
				String dob = resultset.getString("DOB");
				String address = resultset.getString("Address");
				String postcode = resultset.getString("Postcode");
				int stuID = resultset.getInt("StudentNumber");
				String courseTitle = resultset.getString("CourseTitle");
				String startDate = resultset.getString("StartDate");
				Float bursary = resultset.getFloat("Bursary");
				String email = resultset.getString("Email");

				temp = new Student(name, gender, dob, address, postcode, stuID, courseTitle, startDate, bursary, email);

				allStudents.add(temp);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (resultset != null) {
				resultset.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return allStudents;
	}

	public Student getStudent(String id) throws SQLException {
		Student temp = null;

		Connection dbConnection = null;
		Statement statement = null;
		ResultSet resultset = null;
		String query = "SELECT * FROM students WHERE StudentNumber = " + id + ";";
		ArrayList<Student> allStudents = new ArrayList<>();

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(query);
			// execute SQL query
			resultset = statement.executeQuery(query);
			while (resultset.next()) {

				String name = resultset.getString("Name");
				String gender = resultset.getString("Gender");
				String dob = resultset.getString("DOB");
				String address = resultset.getString("Address");
				String postcode = resultset.getString("Postcode");
				int stuID = resultset.getInt("StudentNumber");
				String courseTitle = resultset.getString("CourseTitle");
				String startDate = resultset.getString("StartDate");
				Float bursary = resultset.getFloat("Bursary");
				String email = resultset.getString("Email");

				/*
				System.out.print("\n");
				System.out.println("Name: " + name);
				System.out.println("Gender: " + gender);
				System.out.println("DOB: " + dob);
				System.out.println("Address: " + address);
				System.out.println("Postcode: " + postcode);
				System.out.println("Student ID: " + stuID);
				System.out.println("CourseTitle: " + courseTitle);
				System.out.println("Start Date: " + startDate);
				System.out.println("Bursary: " + bursary);
				System.out.println("Email: " + email);
				System.out.print("\n");
				*/

				temp = new Student(name, gender, dob, address, postcode, stuID, courseTitle, startDate, bursary, email);

				allStudents.add(temp);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (resultset != null) {
				resultset.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}

		return temp;
	}

	public Boolean insertStu(Student stu) throws SQLException {

		// put your code here
		Connection connection = null;
		Statement statement = null;

		String name = stu.getName();
		String gender = stu.getGender();
		String dob = stu.getDob();
		String address = stu.getAddress();
		String postcode = stu.getPostcode();
		String courseTitle = stu.getCourseTitle();
		String startDate = stu.getStartDate();
		Float bursary = stu.getBursary();
		String email = stu.getEmail();

		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:studentdb.sqlite");
			connection.setAutoCommit(false);
			System.out.println("Insert operation -database successfully opened");
			statement = connection.createStatement();
			String sql = "INSERT INTO students (name, gender, dob, address, postcode,"
					+ " courseTitle, startDate,bursary ,email) " + "VALUES ('" + name + "','" + gender + "','" + dob
					+ "','" + address + "','" + postcode + "','" + courseTitle + "','" + startDate + "','" + bursary
					+ "','" + email + "')";
			statement.executeUpdate(sql);
			statement.close();
			connection.commit();
			connection.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records successfully created");

		return false;
	}

	public Boolean deleteStu(String stuID) throws SQLException {

		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:studentdb.sqlite");
			connection.setAutoCommit(false);
			System.out.println("Delete operation -database successfully opened");
			statement = connection.createStatement();
			String sql = "DELETE FROM students WHERE StudentNumber=" + stuID + ";";
			statement.executeUpdate(sql);
			connection.commit();
			statement.close();
			connection.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Delete operation successfully done");

		return false;
	}

	public Boolean updateStu(Student stu) throws SQLException {

		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:studentdb.sqlite");
			connection.setAutoCommit(false);
			System.out.println("Update operation - database successfully opened");
			String sql = "UPDATE students SET name=?, gender=?, dob=?, address=?, postcode=?, courseTitle=?, startDate=?, bursary=?, email=? WHERE StudentNumber=?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, stu.getName());
			ps.setString(2, stu.getGender());
			ps.setString(3, stu.getDob());
			ps.setString(4, stu.getAddress());
			ps.setString(5, stu.getPostcode());
			ps.setString(6, stu.getCourseTitle());
			ps.setString(7, stu.getStartDate());
			ps.setFloat(8, stu.getBursary());
			ps.setString(9, stu.getEmail());
			ps.setInt(10, stu.getStudentNumber());
			
			ps.executeUpdate();
			connection.commit();
			ps.close();
			connection.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Update operation successfully done");

		return false;
	}

	public Boolean checkLoginCredentials(String username, String password) throws SQLException {

		// put your code here
		return false;
	}

	public boolean checkApiKey(String key) throws SQLException {

		// put your code here
		return false;
	}
}
