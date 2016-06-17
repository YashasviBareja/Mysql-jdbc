package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatement3 
{
	public static void main(String[] args) {
		
		String driverName= "com.mysql.jdbc.Driver";
		String connectionString ="jdbc:mysql://localhost/school1";
		String dbUserName="root";
		String dbPassword="yash@1996";
		
		try
		{
			Class.forName(driverName);
			
			Connection connection =DriverManager.getConnection(connectionString,dbUserName,dbPassword);
			
			PreparedStatement prepareStatement = connection.prepareStatement("select * from school1.student where id=? and age=? ");
			
			prepareStatement.setInt(1,1);                 //this prepares the statements i.e put values of id and age
			prepareStatement.setInt(2, 19);
			
			ResultSet resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next())
			{
				System.out.print(resultSet.getInt(1));
				System.out.print(" "+resultSet.getString("name"));
				System.out.println(" "+resultSet.getString(3));
				

			}
			//System.out.println("reuse the prepared statements :" + " select * from school.student where id>4 and age>15");
			PreparedStatement prepareStatement1 = connection.prepareStatement(" select * from school1.student where id>3 and age= 16");
			
			prepareStatement1.setInt(1,3);
			prepareStatement1.setInt(2, 15);
			
            ResultSet resultSet1 = prepareStatement.executeQuery();
			
			while(resultSet1.next())
			{
				System.out.print(resultSet1.getInt(1));
				System.out.print(" "+resultSet1.getString("name"));
				System.out.println(" "+resultSet1.getString(3));
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

