package Model;

public class Student
{
	private int id;
	private String name;
	private int age;
	private String course;



	public Student(int id, String name, int age, String course)
	{
		this.id = id;
		this.name = name;
		this.age = age;
		this.course = course;
	}
	


	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String getCourse()
	{
		return course;
	}

	

	public String toString()
	{
		return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course;
	}	
}