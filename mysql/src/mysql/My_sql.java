package mysql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class My_sql {

	public static void main(String[] args)
	{
		String DriverName= "com.mysql.jdbc.Driver";
		
		String connectionString = "jdbc:mysql://localhost/school";
		
		String dbUserName = "root";
		
		String dbpassword= "yash@1996";
		
	try
	{
		
			Class.forName(DriverName);    //allocates memory to driver in java   //registers the driver
			                              //forName is a function/method for registering the driver which is contained 
			                              // in a class "Class"
			
			Connection connection = DriverManager.getConnection(connectionString,dbUserName,dbpassword);
			
			Statement statement = connection.createStatement(); //statement method is defined in connection
			
			ResultSet resultSet = statement.executeQuery("select * from school.student");
			
			while(resultSet.next())
			{
				System.out.print(resultSet.getInt("id"));
				System.out.print("  "+ resultSet.getString(2));
				System.out.println("  " +resultSet.getString("class"));
			}
		}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		catch(SQLException exc)
		{
			exc.printStackTrace();
		}	
		}
	}
