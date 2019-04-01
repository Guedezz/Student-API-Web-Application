import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class DeleteParametersHandler implements HttpHandler {
	
	public void handle(HttpExchange httpExchange) throws IOException {
	      StringBuilder response = new StringBuilder();
	      Map <String,String>parms = SelectParametersHandler.queryToMap(httpExchange.getRequestURI().getQuery());
	      response.append(parms.get("studentNumber"));

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(httpExchange.getResponseBody()));
		BufferedReader in = new BufferedReader(new InputStreamReader(httpExchange.getRequestBody()));
		String request = "";
		String line = "";
		while ((line = in.readLine()) != null) {
			request = request + line;
		}
		
		StudentDAO dao = new StudentDAO();
		String stuID = response.toString();

		try {
			out.write(dao.deleteStu(stuID).toString());
			httpExchange.sendResponseHeaders(200, 0); // HTTP 200 (OK)
		} catch (SQLException se) {
			httpExchange.sendResponseHeaders(500, 0); // HTTP 500 (Internal Server Error)
			out.write("Error retrieving record.");
		}
		out.close();
	
	}
	
	 public static void writeResponse(HttpExchange httpExchange, String response) throws IOException {
		    httpExchange.sendResponseHeaders(200, response.length());
		    OutputStream os = httpExchange.getResponseBody();
		    os.write(response.getBytes());
		    os.close();
		  }
		  /**
		   * returns the url parameters in a map
		   * @param query
		   * @return map
		   */
		  public static Map<String, String> queryToMap(String query){
		    Map<String, String> result = new HashMap<String, String>();
		    for (String param : query.split("&")) {
		        String pair[] = param.split("=");
		        if (pair.length>1) {
		            result.put(pair[0], pair[1]);
		        }else{
		            result.put(pair[0], "");
		        }
		    }
		    return result;
		  }	
}
