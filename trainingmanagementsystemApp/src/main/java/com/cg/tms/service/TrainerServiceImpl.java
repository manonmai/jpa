package com.cg.tms.service;

import java.util.Set;

import com.cg.tms.dao.CrudService;
import com.cg.tms.dao.TrainerServiceDaoImpl;
import com.cg.tms.entity.Employee;
import com.cg.tms.enums.Skills;
import com.cg.tms.exception.ProgramException;
import com.cg.tms.util.UserInputValidator;

/**
 * 
 */

public class TrainerServiceImpl implements TrainerService {
	CrudService<Employee> crudOperation = new TrainerServiceDaoImpl();

	public Set<Employee> getAllTrainers() throws ProgramException {
		CrudService tmd = new TrainerServiceDaoImpl();
		Set<Employee> employee = tmd.retrieveAll();
		return employee;
	}

	public boolean createTrainer(Employee trainer) throws ProgramException {
		boolean result = false;
		CrudService crudService = new TrainerServiceDaoImpl();
		UserInputValidator inputValidator = new UserInputValidator();
		if (inputValidator.validateName(trainer.getEmployeeName()) && inputValidator.validateRoleId(trainer)) {
			result = crudService.create(trainer);
		}
		return result;
	}

	public boolean addSkillsToTrainer(int trainerId, Skills skill) {
		return false;
	}

	public boolean delSkillsToTrainer(int trainerId, Skills skills) {
		return false;
	}

	public Employee getTrainerDetails(int trainerId) throws ProgramException {
		Employee trainer = crudOperation.retrieve(trainerId);
		return trainer;
	}
}
