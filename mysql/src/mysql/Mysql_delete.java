package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Mysql_delete {

	public static void main(String[] args)
	{
	String DriverName = "com.mysql.jdbc.Driver";
	
	String connectionString = "jdbc:mysql://localhost/school1";
	
	String dbUserName ="root";
	
	String dbPassword ="yash@1996";
	
	try
	{
		Class.forName(DriverName);
		
		Connection connection = DriverManager.getConnection(connectionString,dbUserName,dbPassword);
		
		Statement statement = connection.createStatement();
		
		StringBuffer query = new StringBuffer("delete from school1.student where id=5");
		
		int executeUpdate = statement.executeUpdate(query.toString());
		
		if(executeUpdate>0)
		{
		   System.out.println("statement is deleted");	
		   System.out.println("rows updated :: "+executeUpdate);
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

