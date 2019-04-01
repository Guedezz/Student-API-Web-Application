import java.io.*;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class UpdateHandler implements HttpHandler {

	public void handle(HttpExchange he) throws IOException {

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
		BufferedReader in = new BufferedReader(new InputStreamReader(he.getRequestBody()));
		Gson gson = new Gson();
		String request = "";
		String line = "";
		while ((line = in.readLine()) != null) {
			request = request + line;
		}
		Student stu = gson.fromJson(request, Student.class);

		StudentDAO dao = new StudentDAO();

		try {
			dao.updateStu(stu);
			he.sendResponseHeaders(200, 0); // HTTP 200 (OK)
			out.write("Student Record Updated");
		} catch (SQLException se) {
			he.sendResponseHeaders(500, 0); // HTTP 500 (Internal Server Error)
			out.write("Error Updating Student");
		}
		out.close();
	}
}
