package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mysql_preparedStatements {

	public static void main(String[] args)
	{
		String driverName= "com.mysql.jdbc.Driver";
		String connectionString ="jdbc:mysql://localhost/school";
		String dbUserName="root";
		String dbPassword="yash@1996";
		
		try
		{
			Class.forName(driverName);
			
			Connection connection =DriverManager.getConnection(connectionString,dbUserName,dbPassword);
			
			PreparedStatement prepareStatement = connection.prepareStatement("select * from school.student");
			
			ResultSet resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next())
			{
				System.out.print(resultSet.getInt(1));
				System.out.print(" "+resultSet.getString("name"));
				System.out.println(" "+resultSet.getString(3));
			}
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
}
