package todoAppS01;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class EmbeddedStart {

	public static void main(String[] args) {
		try {
			Server server = new Server(8080);
			
			ServletContextHandler context = new ServletContextHandler();
	        context.setContextPath("/");
	        server.setHandler(context);

	        context.addServlet(new ServletHolder(new EmperorServlet()),"/*");
	        context.addServlet(new ServletHolder(new TodoServlet()),"/todo");
	        
			server.start();
	        server.join();
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
