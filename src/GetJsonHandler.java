import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

//Example Handlers  ...Add JavaDoc ..

public class GetJsonHandler implements HttpHandler {

	// Add Javadoc here ..
	public void handle(HttpExchange he) throws IOException {

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
		
		Gson gson = new Gson();

		StudentDAO dao = new StudentDAO();
		ArrayList<Student> allStudents = new ArrayList<>();
		try {
			allStudents = dao.getAllStudents();


		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		String myJson = gson.toJson(allStudents);
		//String students =allStudents.toString();
		he.sendResponseHeaders(200, 0);
		out.write(myJson);
		out.close();
	}
}