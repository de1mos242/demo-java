package todoAppS01;

import org.eclipse.jetty.server.Server;

public class EmbeddedStart {

	public static void main(String[] args) {
		try {
			Server server = new Server(8080);
			
			server.setHandler(new SimpleHandler());
	        
			server.start();
	        server.join();
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
