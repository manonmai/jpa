package com.cg.tms.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cg.tms.entity.Employee;
import com.cg.tms.entity.Program;
import com.cg.tms.exception.ProgramException;
import com.cg.tms.util.EntityManagerUtils;

/**
 * 
 */

public class TrainerServiceDaoImpl implements CrudService<Employee> {

	// @Override
	public Set<Employee> retrieveAll() throws ProgramException {
		EntityManager entityManager = EntityManagerUtils.getEntityManager();
		Query employees = entityManager.createQuery("Select e from Employee e");
		List<Employee> results = employees.getResultList();
		Set<Employee> hSet = new HashSet<Employee>();
		hSet.addAll(results);
		return (Set<Employee>) hSet;
	}

	public boolean create(Employee employee) throws ProgramException {
		EntityManager entityManager = EntityManagerUtils.getEntityManager();
try {
			entityManager.getTransaction().begin();
			entityManager.persist(employee);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw new ProgramException("ERROR");
		}
		return true;

	}

	// @Override
	public boolean update(Employee o) {
		return false;
	}

	// @Override
	public Employee retrieve(int trainerId) throws ProgramException {
		Set<Employee> trainerSet = retrieveAll();
		for (Employee trainer : trainerSet) {
			if (trainerId == (trainer.getEmployeeId())) {
				return trainer;
			}
		}

		return null;
	}

	// @Override
	public boolean delete(Employee o) {
		return false;
	}
	public boolean create(Program trainingProgram) {
		// TODO Auto-generated method stub
		return false;
	}

}
