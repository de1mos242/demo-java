package todoAppS01;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class EmbeddedStart {

	public static void main(String[] args) {
		try {
			Server server = new Server(8080);

			WebAppContext context = new WebAppContext();
			context.setDescriptor("/WEB-INF/web.xml");
			context.setResourceBase(".");
			context.setContextPath("/");
			
			server.setHandler(context);

			server.start();
			server.join();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
