package yashasvi;

//all the data of table school1 is stored in this student class

public class Student
{
	
	private int id;
	private String name;
	private String standard;
	private int age;
	

	public Student(int id, String name,String standard, int age)
	{
		super();           //initialize the constructor of object class
		this.id =id;
		this.name=name;
		this.standard=standard;
		this.age=age;
		

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
