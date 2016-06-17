package yashasvi;

public interface Constants
{
	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	
	public static final String CONNECTION_STRING = "jdbc:mysql://localhost/school1";
	
	public static final String DB_USERNAME = "root";
	
	public static final String DB_PASSWORD = "yash@1996";
	
}
// initialize the variables to static so they can be accessed from the interface name directly
// and initialize them to final so that they can't be reinitialized anywhere else and and if we want to change them 
//we can change here and at all other places they will be changed
