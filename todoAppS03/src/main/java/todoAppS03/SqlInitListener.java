package todoAppS03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SqlInitListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("init db from event listener");
		prepareDBIfNeed(arg0.getServletContext().getInitParameter("db connection string"));
		System.out.println("init db from event listener finished");
	}
	
	private void prepareDBIfNeed(String connectionString) {
		Connection connection = null;  
	     ResultSet resultSet = null;  
	     Statement statement = null;  

	     try 
	     {  
	         Class.forName("org.sqlite.JDBC");  
	         connection = DriverManager.getConnection(connectionString);  
	         System.out.println("connected to: " + connectionString);
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

}
