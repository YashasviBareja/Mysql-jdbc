package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class mysql_update {

	public static void main(String[] args)
	{
		String DriverName = "com.mysql.jdbc.Driver";
		
		String connectionString = "jdbc:mysql://localhost/school";
		
		String dbUserName ="root";
		
		String dbPassword ="yash@1996";
		
		try
		{
			Class.forName(DriverName);
			
			Connection connection = DriverManager.getConnection(connectionString,dbUserName,dbPassword);
			
			Statement statement = connection.createStatement();
			
			StringBuffer query = new StringBuffer("update school.student set name= 'preeti' , age='21' where id=7");
			
			int executeUpdate = statement.executeUpdate(query.toString());
			
			if(executeUpdate>0)
			{
			   System.out.println("statement is updated");	
			}
		}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}catch(SQLException exc)
			{
				exc.printStackTrace();
			}
						
		}

	}

