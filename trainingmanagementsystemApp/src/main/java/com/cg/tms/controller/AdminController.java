package com.cg.tms.controller;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.cg.tms.entity.Course;
import com.cg.tms.entity.Employee;
import com.cg.tms.entity.Feedback;
import com.cg.tms.entity.Roles;
import com.cg.tms.entity.TrainerSkill;
import com.cg.tms.exception.ProgramException;
import com.cg.tms.service.TrainerService;
import com.cg.tms.service.TrainerServiceImpl;

/**
 * 
 */
public class AdminController {
	Scanner scanner;
public AdminController() throws ProgramException {}
	

	private TrainerSkill trainer;
	private Course course;
    private Feedback feedback;

	public void choice4Selection() {
		scanner = new Scanner(System.in);
		System.out.println("Select your option:---");
		System.out.println("1. Get all trainer details");
		System.out.println("2. Create Trainer");
		System.out.println("Enter your choice");
		int choice;
		try {
			choice = scanner.nextInt();
			TrainerServiceImpl impl = new TrainerServiceImpl();
			switch (choice) {
			case 1:
				TrainerService trainerService = new TrainerServiceImpl();
				Set<Employee> tt = trainerService.getAllTrainers();
				Iterator<Employee> employee = tt.iterator();
				while (employee.hasNext()) {
					System.out.println(employee.next());
				}
				break;
			case 2:
				System.out.println("------TO CREATE A EMPLOYEE------");
				Employee trainer = new Employee();
				System.out.println("ENTER THE EMPLOYEE NAME");
				String employeeName = scanner.next();
				System.out.println("ENTER THE ROLE ID");
				try {
				int roleId = scanner.nextInt();
                trainer.setEmployeeName(employeeName);
				Roles role = new Roles();
				role.setRoleId(roleId);
		        trainer.setRole(role);
				System.out.println(trainer.getRole());
				boolean result = impl.createTrainer(trainer);
				if (result == true) {
					System.out.println("data got added");

				} else
					System.out.println("failed");
				}
				catch(InputMismatchException e) {
					throw new ProgramException("invalid roleid");
				}

			case 3:
				System.exit(0);
			default:
				break;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
