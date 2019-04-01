import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class WebServiceTester {

	public static void main(String[] args) {
		
		
		//uncomment the following statements to test class
		
		//System.out.println("Students = " + getStudents());
		//System.out.println("Students in Json format = " + getJson());
		//System.out.println("Student information: "  + getStudent(2));
		/*try {
			deleteStudent(11);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		
	}

	private static StringBuffer getStudents() {

		StringBuffer response = new StringBuffer();
		try {

			URL url = new URL("http://localhost:8005/get-all");
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

			String output;

			while ((output = reader.readLine()) != null) {
				response.append(output);
			}
			reader.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return response;
	}
	
	private static StringBuffer getJson() {

		StringBuffer response = new StringBuffer();
		try {

			URL url = new URL("http://localhost:8005/get-json");
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

			String output;

			while ((output = reader.readLine()) != null) {
				response.append(output);
			}
			reader.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return response;
	}

	private static StringBuffer getStudent(int id) {
		StringBuffer response = new StringBuffer();
		try {
			
			
			URL url = new URL("http://localhost:8005/select?studentNumber="+id);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

			String output;

			while ((output = reader.readLine()) != null) {
				response.append(output);
			}
			reader.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return response;
	}

	private static void postStudent() throws IOException {
	}

	private static void updateStudent() throws IOException {
		// put your code here
	}

	private static StringBuffer deleteStudent(int id) throws IOException {
		StringBuffer response = new StringBuffer();
		try {
			
			
			URL url = new URL("http://localhost:8005/delete?studentNumber="+id);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

			String output;

			while ((output = reader.readLine()) != null) {
				response.append(output);
			}
			reader.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Student " + id + " removed from database.");
		return response;
		
	}

}
