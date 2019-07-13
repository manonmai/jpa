package com.cg.main;

import java.util.Scanner;

import com.cg.tms.controller.AdminController;
import com.cg.tms.exception.ProgramException;

public class Application {
	static Scanner scanner;

	public static void main(String[] args) {
		// CoordinatorController coordinatorController;
		AdminController adminController;
		scanner = new Scanner(System.in);

		int choice = 0;
		boolean progrmRunner = true;
		try {
			// coordinatorController = new CoordinatorController();
			adminController = new AdminController();
			while (progrmRunner) {
				System.out.println("_______Welcome to Traingin Management System_____");
				System.out.println("TrainingProgram Module");
				System.out.println("Select Your Operation:------------");
				System.out.println("1. Training Program Management");
				System.out.println("2. Student Management");
				System.out.println("3. Course Management");
				System.out.println("4. Trainer Management");
				System.out.println("5. Exit");
				choice = scanner.nextInt();

				switch (choice) {
				case 1:
					// coordinatorController.choice1Selection();
					break;
				case 2:
					// coordinatorController.choice2Selection();
					break;
				case 4:
					adminController.choice4Selection();
					break;
				case 3:
					progrmRunner = false;
					break;

				default:
					System.out.println("Wrong Choice");
				}

			}
		} catch (ProgramException e) {
			System.err.println("Invalid input choice");
			progrmRunner = false;
		}

	}

}
