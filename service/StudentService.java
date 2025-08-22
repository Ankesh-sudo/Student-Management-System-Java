package service;

import java.io.*;
import java.util.*;
import Model.Student;
import exception.StudentNotFoundException;

public class StudentService
{
	private ArrayList<Student> Students = new ArrayList<>();
	private final String FILE_NAME = "Students.csv";

	
	public StudentService()
	{
		loadFromCSV();
	}



	public void addStudent(Student s)
	{
		Students.add(s);
		saveToCSV();
		System.out.println("Student added successfully!");
	}
	
	
	
	public void removeStudent(int id) throws StudentNotFoundException
	{
		Student found = null;
		for (Student s : Students)
		{
			if (s.getId() == id)
			{
				found = s;
				break;
			}
		}
		if (found != null)
		{
			Students.remove(found);
			saveToCSV();
			System.out.println("Student removed successfully");
		}
		else
		{
			throw new StudentNotFoundException("Students id "+ id +" not found.");
		}
	}



	public Student searchStudent(int id) throws StudentNotFoundException 
	{
        	for (Student s : Students) 
		{
            		if (s.getId() == id) 
			{
                		return s;
            		}
        	}
        	throw new StudentNotFoundException("Student with ID " + id + " not found.");
    	}



	public void displayAllStudents() 
	{
        	if (Students.isEmpty()) 
		{
            		System.out.println("No students available.");
        	} 
		else 
		{
            		for (Student s : Students) {
                		System.out.println(s);
            		}
        	}
    	}



	private void saveToCSV() 
	{
        	try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) 
		{
            		pw.println("ID,Name,Age,Course"); 
            		for (Student s : Students) 
			{
                		pw.println(s.getId() + "," + s.getName() + "," + s.getAge() + "," + s.getCourse());
            		}
        	} 
		catch (IOException e) 
		{
            		System.out.println("Error saving to file: " + e.getMessage());
        	}
    	}
	


	private void loadFromCSV() 
	{
        	File file = new File(FILE_NAME);
        	if (!file.exists()) return;

       		try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME)))
		{
            		String line;
            		br.readLine(); // skip header
            		while ((line = br.readLine()) != null) {
                		String[] data = line.split(",");
                		int id = Integer.parseInt(data[0]);
                		String name = data[1];
                		int age = Integer.parseInt(data[2]);
               	 		String course = data[3];
                		Students.add(new Student(id, name, age, course));
            		}
        	} 
		catch (IOException e) 
		{
            		System.out.println("Error loading from file: " + e.getMessage());
        }
    }
}