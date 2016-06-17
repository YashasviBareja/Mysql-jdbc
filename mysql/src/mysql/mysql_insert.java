package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
public class mysql_insert {

	public static void main(String[] args) 
	{
		
		String DriverName= "com.mysql.jdbc.Driver";
		
		String connectionString ="jdbc:mysql://localhost/school";
		
		String dbUserName= "root";
		
		String dbPassword ="yash@1996";
		
		try
		{
			
		Class.forName(DriverName);
		
		Connection connection = DriverManager.getConnection(connectionString,dbUserName,dbPassword);
		
		Statement statement = connection.createStatement();
		
		StringBuffer query = new StringBuffer("insert into school.student (id, name, class,age) " + 
		                                                    "value('7 ',' geeta' , 'it','20')" );
			                                             
		int executeUpdate = statement.executeUpdate(query.toString());
		
		if(executeUpdate>0)
		{
			System.out.println("statement is inserted");
		}
		
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException exc)
		{
			exc.printStackTrace();
		}	
	}	
	}