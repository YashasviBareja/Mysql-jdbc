package yashasvi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO2 
{
	Connection connection=null;
	PreparedStatement prepareStatement = null;

	
	public void getStudentDetails()
	{
	try
	{
		Class.forName(Constants.DRIVER_NAME);
		
		connection = DriverManager.getConnection(Constants.CONNECTION_STRING,Constants.DB_USERNAME,Constants.DB_PASSWORD);
		
		prepareStatement= connection.prepareStatement("update school1.student set name =? , age=? where  id =?");
		prepareStatement.setString(1,"sarthak"); 
		prepareStatement.setInt(2,9); 
		prepareStatement.setInt(3,7); 
		
		
	    int executeUpdate= prepareStatement.executeUpdate();
	    
	    if(executeUpdate>0)
	    {
	    	System.out.println("statement is updated");
	    }
	    
		
		
		}catch(ClassNotFoundException e)
		{
		      e.printStackTrace();
		}catch(SQLException ex)
	     {
			ex.printStackTrace();
	     }finally
	     {
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
	    	if(connection!=null)
	    	{
	    		try
	    		{
	    			connection.close();
	    		}catch(SQLException e)
	    		{
	    			e.printStackTrace();
	    		}
	    	}
	   }
	}
}
