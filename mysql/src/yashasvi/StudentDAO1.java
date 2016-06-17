package yashasvi;

	import java.sql.Connection;
	import java.sql.Driver;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	public class StudentDAO1
	{
		Connection connection=null;
		PreparedStatement prepareStatement = null;
	
		
		public void getStudentDetails()
		{
		try
		{
			Class.forName(Constants.DRIVER_NAME);
			
			connection = DriverManager.getConnection(Constants.CONNECTION_STRING,Constants.DB_USERNAME,Constants.DB_PASSWORD);
			
			prepareStatement= connection.prepareStatement("insert into school1.student(id,name,class,age)" +" value(?,?,?,? )");
			prepareStatement.setInt(1,7);                 //this prepares the statements i.e put values of id and age
			prepareStatement.setString(2,"keshu");
			prepareStatement.setString(3,"6");
			prepareStatement.setInt(4,11);
			
		    int executeUpdate= prepareStatement.executeUpdate();
		    
		    if(executeUpdate>0)
		    {
		    	System.out.println("statement is inserted");
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