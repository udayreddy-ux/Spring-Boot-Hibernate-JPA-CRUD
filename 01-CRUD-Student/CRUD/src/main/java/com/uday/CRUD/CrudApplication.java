package com.uday.CRUD;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.uday.CRUD.dao.StudentDAO;
import com.uday.CRUD.entity.Student;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
	/*
	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> {
			System.out.println("Hello World");
		};
	}*/
	//Inject StudentDAO
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner ->{
			//createStudent(studentDAO);
			
			createMultipleStudents(studentDAO);
			
			//readStudent(studentDAO);
			
			//displayStudents(studentDAO);
			
			//findByLName(studentDAO);
			
			//updateById(studentDAO);
			
			//deleteById(studentDAO);
			
			//deleteAllRecords(studentDAO);
		};
	}
	/*
	private void createStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		//create the student object
		System.out.println("Creating new studen object...");
		Student tempStudent=new Student("Uday","Kovvuri","kovvuruymail.uc.edu");
		
		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		//display id of the saved student
		System.out.println("Saved student. Generated id: "+ tempStudent.getId());
	}
	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new student object...");
		Student tempStudent=new Student("Akhila","Ireddy","akhilareddy@gmail.com");
		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		//display id of the saved student
		int theId=tempStudent.getId();
		System.out.println("Saved student. Generated id: "+ theId);
		//retrieve student based on the id: primary key
		System.out.println("Retreiving student with id: "+theId);
		Student myStudent=studentDAO.findById(theId);
		//display student
		System.out.println("Found the student: "+myStudent);
	}
	private void displayStudents(StudentDAO studentDAO){
		List<Student> res=studentDAO.findStudents();
		for(Student st:res) {
			System.out.println(st);
		}
	}
	private void findByLName(StudentDAO studentDAO) {
		List<Student> theStudents=studentDAO.findByLastName("Kovvuri");
		for(Student name:theStudents) {
			System.out.println(name);
		}
	}
	private void updateById(StudentDAO studentDAO) {
		int studentId=1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent=studentDAO.findById(studentId);
		myStudent.setLastName("Komarambheem");
		studentDAO.update(myStudent);
		System.out.println(myStudent.getLastName());
	}
	
	private void deleteById(StudentDAO studentDAO) {
		int studentId=3;
		studentDAO.delete(studentId);
	}
	
	private void deleteAllRecords(StudentDAO studentDAO) {
		studentDAO.deleteAll();
	}*/
	
	private void createMultipleStudents(StudentDAO studentDAO) {
		Student student1=new Student("Sita","Kovvuri","sita@gmail.com");
		Student student2=new Student("Venkat","Kovvuri","venkat@gmail.com");
		Student student3=new Student("Prabhas","Uppalapati","uppalbalu@gmail.com");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}
	
}
