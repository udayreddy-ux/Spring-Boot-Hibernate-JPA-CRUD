package com.uday.CRUD.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uday.CRUD.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	//define field for entity manager
	private EntityManager entityManager;
	//inject entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	//implement save method
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}
	
	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class,id);
	}
	
	@Override
	public List<Student> findStudents(){
		TypedQuery<Student> creatQuery=entityManager.createQuery("FROM Student",Student.class);
		List<Student> res=creatQuery.getResultList();
		return res;
	}
	
	@Override
	public List<Student> findByLastName(String theLastName){
		TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
		theQuery.setParameter("theData",theLastName);
		return theQuery.getResultList();
	}
	
	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		Student theStudent=entityManager.find(Student.class, id);
		entityManager.remove(theStudent);
	}
	
	@Override
	@Transactional
	public void deleteAll() {
		int res=entityManager.createQuery("DELETE FROM Student").executeUpdate();
	}
}
