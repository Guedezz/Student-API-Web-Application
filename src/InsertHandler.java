import java.io.*;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;


import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class InsertHandler implements HttpHandler {

	public void handle(HttpExchange he) throws IOException {
		
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
		Gson gson = new Gson();
		BufferedReader in = new BufferedReader(new InputStreamReader(he.getRequestBody()));
		String request = "";
		String line = "";
		while ((line=in.readLine())!= null) {
			request = request + line;
		}
		Student stu = gson.fromJson(request, Student.class);

		StudentDAO dao = new StudentDAO();

		try {
			dao.insertStu(stu);
			he.sendResponseHeaders(200, 0); // HTTP 200 (OK)
			out.write("Success!");
		} catch (SQLException se) {
			he.sendResponseHeaders(500, 0); // HTTP 500 (Internal Server Error)
			out.write("Error Adding Student");
		}
		out.close();
	}
}
