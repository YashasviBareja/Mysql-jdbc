package yashasvi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO3
{

	Connection connection=null;
	PreparedStatement prepareStatement = null;

	
	public void getStudentDetails()
	{
	try
	{
		Class.forName(Constants.DRIVER_NAME);
		
		connection = DriverManager.getConnection(Constants.CONNECTION_STRING,Constants.DB_USERNAME,Constants.DB_PASSWORD);
		
		prepareStatement= connection.prepareStatement("delete from school1.student  where  id =?");
		prepareStatement.setInt(1,7); 
		
		
	    int executeUpdate= prepareStatement.executeUpdate();
	    
	    if(executeUpdate>0)
	    {
	    	System.out.println("statement is deleted");
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
