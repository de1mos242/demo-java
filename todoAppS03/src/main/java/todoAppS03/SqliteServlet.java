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
		prepareDBIfNeed();
		resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        
        PrintWriter writer = resp.getWriter();
    	writer.println("<h1>" + getTodoById(idPath) + "</h1>");
	}
	
	private void prepareDBIfNeed() {
		Connection connection = null;  
	     ResultSet resultSet = null;  
	     Statement statement = null;  

	     try 
	     {  
	         Class.forName("org.sqlite.JDBC");  
	         connection = DriverManager.getConnection("jdbc:sqlite:/home/denis/todoApp.db");  
	         statement = connection.createStatement();  
	         resultSet = statement  
	                 .executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='todos';");  
	         if (!resultSet.next()) 
	         {  
	        	 statement.execute("create table todos (id bigint, name varchar(255));");
	        	 
	        	 statement.execute("insert into todos (id, name) values (1, 'write simple server');");
	        	 statement.execute("insert into todos (id, name) values (2, 'add stupid handle');");
	        	 statement.execute("insert into todos (id, name) values (3, 'add conditional to handler');");
	        	 statement.execute("insert into todos (id, name) values (4, 'build with gradle');");
	        	 statement.execute("insert into todos (id, name) values (5, 'use sqlite');");
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
	}
	
	private String getTodoById(String todoId) {
		String resultString = "Not found";
		
		Connection connection = null;  
	     ResultSet resultSet = null;  
	     Statement statement = null;  

	     try 
	     {  
	         Class.forName("org.sqlite.JDBC");  
	         connection = DriverManager.getConnection("jdbc:sqlite:/home/denis/todoApp.db");  
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
