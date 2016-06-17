package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedUpdate {

	public static void main(String[] args) {
	
		String driverName= "com.mysql.jdbc.Driver";
		String connectionString ="jdbc:mysql://localhost/school1";
		String dbUserName="root";
		String dbPassword="yash@1996";
		
		try
		{
			Class.forName(driverName);
			
			Connection connection =DriverManager.getConnection(connectionString,dbUserName,dbPassword);
			
			PreparedStatement prepareStatement = connection.prepareStatement("insert into school1.student (id,name,class,age)"
					                                                               + "value(?,?,?,?)");
			
			prepareStatement.setInt(1,2);                 //this prepares the statements i.e put values of id and age
			prepareStatement.setString(2,"vishant");
			prepareStatement.setString(3,"btech");
			prepareStatement.setInt(4,20);
		int executeUpdate= prepareStatement.executeUpdate();
			
		if(executeUpdate>0)
		{
			System.out.println("rows affected:: "+executeUpdate);
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
