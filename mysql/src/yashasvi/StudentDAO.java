package yashasvi;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO 
{
	Connection connection=null;
	PreparedStatement prepareStatement = null;
	ResultSet resultSet =null;
	List<Student> studentlist = null;           //create a list to store data of student table in a row and data in list is
	                                            // of type student (id,name,class,age)
	
	public List <Student> getStudentDetails()
	{
	try
	{
		Class.forName(Constants.DRIVER_NAME);
		
		connection = DriverManager.getConnection(Constants.CONNECTION_STRING,Constants.DB_USERNAME,Constants.DB_PASSWORD);
		
		prepareStatement= connection.prepareStatement("select * from school1.student");
		
		resultSet= prepareStatement.executeQuery();
		
		studentlist = new ArrayList<Student>();  //crates an array list of type student
		while(resultSet.next())
		{
			
			Student student = new Student(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("class"),resultSet.getInt("age"));
			                                       //puts value from database into student class
			studentlist.add(student);               //adds data from Student to the list
		}
		}catch(ClassNotFoundException e)
		{
		      e.printStackTrace();
		}catch(SQLException ex)
	     {
			ex.printStackTrace();
	     }finally
	     {
	    	if(connection!=null)                   //if connection is open we have to close it at the end
	    	{
	    		try
	    		{
	    			connection.close();            //close the connection
	    		}catch(SQLException e)
	    		{
	    			e.printStackTrace();
	    		}
	    	}
	    	
	    	if(resultSet!=null)
	    	{
	    		try{
	    		    resultSet.close();
	    		}catch(SQLException e)
	    		{
	    			e.printStackTrace();
	    		}
	    	}
	    	
	        if(prepareStatement!=null)
	        {
	        	try
	        	{
	        		prepareStatement.close();
	        }catch(SQLException e)
    		{
    			e.printStackTrace();
    		} 
	      }
	   }
	
	return studentlist;             //return student list to main class
	}
}




