package springmvcm4.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvcm4.dto.Student;

@Repository
public class StudentDao {
	
	@Autowired
	private EntityManager entityManager;

	public void saveStudent(Student student) {
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(student);
	entityTransaction.commit();
		
	}

	public List<Student> getAllStudents() {
		Query query=entityManager.createQuery("Select s from Student s");
		return query.getResultList();
	}

	public void deleteStudent(int id) {
		Student dbStudent=entityManager.find(Student.class, id);
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(dbStudent);
		entityTransaction.commit();
	}

	public Student getStudentById(int id) {
		Student dbStudent=entityManager.find(Student.class, id);
		return dbStudent;
	}

	public void updateStudent(Student student) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		
	}

}
