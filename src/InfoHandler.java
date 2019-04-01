import java.io.*;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class InfoHandler implements HttpHandler {

	public void handle(HttpExchange he) throws IOException {

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));
		
			out.write("To retrieve a Student Data put following in URL: http://localhost:8005/select?studentNumber='x'. replace 'x' with the student number you want to retrieve.");
			out.write("To delete a Student from Database put following in URL: http://localhost:8005/delete?studentNumber='x'. replace 'x' with a student number you want to delete.");
			out.write("To get all student Records put following in URL: http://localhost:8005/get-all");
			out.write("To get all student Records in Json Format put following in URL: http://localhost:8005/get-json");
			he.sendResponseHeaders(200, 0); // HTTP 200 (OK)
		
		out.close();
	}
}
