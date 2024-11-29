package com.uday.CRUD.dao;

import java.util.List;

import com.uday.CRUD.entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	
	Student findById(Integer id);
	
	List<Student> findStudents();
	
	List<Student> findByLastName(String theLastName);
	
	void update(Student theStudent);
	
	void delete(Integer id);
	
	void deleteAll();
}
