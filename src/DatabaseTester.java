import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;


public class DatabaseTester {

	public static void main(String[] args) {
		
		ArrayList<Student> allStudents = new ArrayList<>();
		StudentDAO dao = new StudentDAO();
		Gson gson = new Gson();
		//Student joe = new Student("Joe","M","01-02-1995","25 Olhdam Rd.","JH8 8UI",1,"Computer Science","01-10-2014",(float) 500,"joe@email.com");
		//Student Miguel = new Student("Miguel","M","03-06-1994","34 London Rd.","NW3 6UJ",7,"Computer Science","01-10-2014",(float) 500,"miguel@email.com");
		
		//CRUD TESTS
		
		try {
			allStudents = dao.getAllStudents();	
		} catch (SQLException e) {
			System.out.println("SQL exception: "+e.getMessage());
		}
		String myJson = gson.toJson(allStudents);
		System.out.println(myJson);
		
		//Select student from ID
		/*try {
			dao.getStudent(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		//Insert new Student into DataBase
		/*try {
			dao.insertStu(joe);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		//Delete Student from database
		/*try {
			dao.deleteStu(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		//update student
		/*try{
			dao.updateStu(Miguel);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}
	
}