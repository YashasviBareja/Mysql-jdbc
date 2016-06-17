package yashasvi;

import java.util.List;

public class Yashasvi {

	public static void main(String[] args) 
	{
		
		StudentDAO studentDAO = new StudentDAO();
		
		List <Student> studentdetails = studentDAO.getStudentDetails();           //made a list studentdetails and 
		                                                                          // put the data of studentlist in this list
		
		for( Student student : studentdetails)                   //iterates the studentdetails list which is of type Student
		{
			System.out.println("id ::" +student.getId());
			System.out.println("name ::" +student.getName());
			System.out.println("standard::" +student.getStandard());
			System.out.println("age ::" +student.getAge());
			System.out.println("=================================================");

	}
}
}
