import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

// Add Javadoc ..

public class Controller {

//Add Javadoc ..
	
	public static void main(String[] args) {
		
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(8005), 0);
		
			server.createContext("/", new HomeHandler());
			server.createContext("/get-all", new GetHandler());
			server.createContext("/get-json", new GetJsonHandler());
			server.createContext("/insert", new InsertHandler());
			server.createContext("/update", new UpdateHandler());
			server.createContext("/delete", new DeleteParametersHandler());
			server.createContext("/info", new InfoHandler());
			server.createContext("/select", new SelectParametersHandler());

			// start the server
			server.setExecutor(null);
			server.start();
			System.out.println("Server running on port 8005");

		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}

