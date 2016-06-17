package mysql;

import java.sql.Connection;              // interface
import java.sql.DriverManager;           //interface
import java.sql.PreparedStatement;
import java.sql.ResultSet;               //interface
import java.sql.SQLException;            //class
import java.sql.Statement;               //interface

public class Mysql {

	public static void main(String[] args) {
		String driverName = "com.mysql.jdbc.Driver";        //gives the drivername to which connection has to establish 


		String connectionString = "jdbc:mysql://localhost/school";                // gives the schema of the driver(mysql)

		String dbUserName = "root";                                            //gives username yashasvi is host

		String dbPassword = "yash@1996";
		try {

			Class.forName(driverName);            // class is a class where all files are stored and it allocates memory to driver in eclipse 

			Connection connection = DriverManager.getConnection(connectionString, dbUserName, dbPassword);   //connects

			Statement statement = connection.createStatement();                 
	
			ResultSet resultSet = statement.executeQuery("select * from school.student"); //executs the query and gives result in type resultSet
			
			while (resultSet.next()) {
				System.out.print(resultSet.getInt("id"));                              //iterates the resultSet
				System.out.print("  " + resultSet.getString("name"));
				System.out.println("  " + resultSet.getString(3));
			}
		} catch (ClassNotFoundException e) {                                              // exception of java
			e.printStackTrace();
		} catch (SQLException ex) {                                                       //exception of mysql
			ex.printStackTrace();
		}
	}
}
