package todoAppS03;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SqliteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idPath = req.getPathInfo().substring(1);
		resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        
        PrintWriter writer = resp.getWriter();
    	String connectionString = getServletContext().getInitParameter("db connection string");
		writer.println("<h1>" + getTodoById(idPath, connectionString) + "</h1>");
	}
	
	
	
	private String getTodoById(String todoId, String connectionString) {
		String resultString = "Not found";
		
		Connection connection = null;  
	     ResultSet resultSet = null;  
	     Statement statement = null;  

	     try 
	     {  
	         Class.forName("org.sqlite.JDBC");  
	         connection = DriverManager.getConnection(connectionString);  
	         statement = connection.createStatement();  
	         resultSet = statement  
	                 .executeQuery("SELECT name FROM todos WHERE id = '" + todoId + "';");  
	         if (resultSet.next()) 
	         {  
	        	 resultString = resultSet.getString(1);  
	         }  
	     } 
	     catch (Exception e) 
	     {  
	         e.printStackTrace();  
	     }
	     finally 
	     {  
	         try 
	         {  
	             resultSet.close();  
	             statement.close();  
	             connection.close();  
	         } 
	         catch (Exception e) 
	         {  
	             e.printStackTrace();  
	         }  
	     }  
		return resultString;
	}
}
