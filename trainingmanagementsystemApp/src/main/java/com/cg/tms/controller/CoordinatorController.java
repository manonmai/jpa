//package com.cg.tms.controller;
//
//import java.time.LocalDate;
//import java.util.InputMismatchException;
//import java.util.List;
//import java.util.Scanner;
//import java.util.Set;
//
//import com.cg.tms.dao.FetchCentersImpl;
//import com.cg.tms.dao.IFetchAllDetails;
//import com.cg.tms.entity.Center;
//import com.cg.tms.entity.Course;
//import com.cg.tms.entity.Employee;
//import com.cg.tms.entity.Program;
//import com.cg.tms.entity.Student;
//import com.cg.tms.entity.TrainerSkill;
//import com.cg.tms.exception.ProgramException;
//import com.cg.tms.service.CourseService;
//import com.cg.tms.service.CourseServiceImpl;
//import com.cg.tms.service.StudentService;
//import com.cg.tms.service.StudentServiceImpl;
//import com.cg.tms.service.TrainerService;
//import com.cg.tms.service.TrainerServiceImpl;
//import com.cg.tms.service.TrainingProgramService;
//import com.cg.tms.service.TrainingProgramServiceImpl;
//import com.cg.tms.util.CoordinatorHelper;
//import com.cg.tms.util.UserInputValidator;
//
//public class CoordinatorController {
//	Scanner scanner;
//	private TrainingProgramService traingingProgramOpn;
//	private TrainerService trainerOperation;
//	private CourseService courseOperation;
//	private StudentService studentOpn;
//
//	public CoordinatorController() throws ProgramException {
//
//		this.traingingProgramOpn = new TrainingProgramServiceImpl();
//		this.trainerOperation = new TrainerServiceImpl();
//		this.courseOperation = new CourseServiceImpl();
//		this.studentOpn = new StudentServiceImpl();
//	}
//
//	public void choice1Selection() throws ProgramException {
//		scanner = new Scanner(System.in);
//		System.out.println("Select your option:---");
//		System.out.println("1. Create a Training Program");
//		System.out.println("2. Get the Program Details");
//		System.out.println("3. Delete the Existing Program");
//		System.out.println("4. Get the All running training program");
//		System.out.println("5. Modify the existing Course");
//		System.out.println("6. Exit");
//		try {
//			final int subChoice = scanner.nextInt();
//			switch (subChoice) {
//			case 1:
//				createProgram();
//				break;
//			case 2:
//				getProgramDetails();
//				break;
//			case 3:
//				deleteProgram();
//				break;
//			case 4:
//				getAllRunningPrograms();
//				break;
//			case 5:
//				updateTrainingProgram();
//			case 6:
//				return;
//			default:
//				System.out.println("Wrong choice entered!");
//			}
//		} catch (ProgramException e) {
//			System.err.println(e.getMessage());
//		} catch (InputMismatchException e) {
//			System.err.println("Wrong format input");
//		}
//
//	}
//
//	private void updateTrainingProgram() {
//
//	}
//
//	private void getProgramDetails() throws ProgramException {
//		System.out.println("Enter the Training Program Id from the list of Available Programs");
//		getAllRunningPrograms();
//		final String trainingId = scanner.next();
//		UserInputValidator.validateTrainingId(trainingId);
//		Program program = traingingProgramOpn.retrieveTrainingProgram(trainingId);
//
//		System.out
//				.println("Training Id: " + program.getTrainingId() + " Start Date: " + program.getTrainingStartDate());
//
//		System.out.println("Course Details:  ");
//		System.out.println(program.getCourse());
//
//		System.out.println("Trainer Details: ");
//		System.out.println(
//				"Trainer Name: " + program.getEmployee().getEmpName() + " Skills: ");
//
//		System.out.println("Running Centers Details ");
//		System.out.println(program.getCenter());
//
//	}
//
//	private void getAllRunningPrograms() throws ProgramException {
//		System.out.println("Currently Running Programs:******************");
//		Set<Program> programs = traingingProgramOpn.retrieveAllTrainingProgram();
//		//programs.forEach(System.out::println);
//
//		/*
//		 * //working with stream
//		 * 
//		 * // Stream<Program> stream = programs.stream(); // Predicate<Program> p1 = (p)
//		 * -> p.getTrainingId().equals("TP_1002"); // Consumer<Program> c1 = (p) -> { //
//		 * System.out.println(p); // }; // stream.filter(p1).forEach(c1);
//		 * 
//		 */
//
//	}
//
//	private void deleteProgram() throws ProgramException {
//		boolean status = false;
//		System.out.println("Select the trainingProgram You want to delete");
//		getAllRunningPrograms();
//		System.out.println("Enter the Training Program Id");
//		final int trainingId = scanner.nextInt();
////		UserInputValidator.validateTrainingId(trainingId);
//		status = traingingProgramOpn.deleteTrainingProgram(trainingId);
//		if (status) {
//			System.out.println("Suceessfully Deleted");
//		} else {
//			System.out.println("Sorry We are unable to peroform your operation");
//		}
//	}
//
//	private void createProgram() throws ProgramException {
//		boolean creationStatus = false;
//
//		System.out.println("Enter Training start " + "Date: yyyy-mm-dd ");
//		final String inputDate = scanner.next();
//		CoordinatorHelper.isDatenotExpired(inputDate);
//		final LocalDate startDate = LocalDate.parse(inputDate);
//
//		System.out.println("Enter CourseId from the below Available Course");
//		Set<Course> courses = courseOperation.getAllCourse();
//		//courses.forEach(System.out::println);
//		System.out.println("Enter CourseId:");
//		final String courseId = scanner.next();
//		UserInputValidator.validateCourseId(courseId);
//		//Course course = courseOperation.getCourseDetails(courseId);
//
//		System.out.println("Pickup the trainer by Entering TrainerId: ");
//		Set<Employee> trainers = trainerOperation.getAllTrainers();
//		//trainers.forEach(System.out::println);
//		final String trainerId = scanner.next();
//		UserInputValidator.validateEmployeeId(trainerId);
//		//Employee trainer = trainerOperation.getTrainerDetails(trainerId);
//
//		System.out.println("PickUp the Center by entering CenterId");
//		IFetchAllDetails<Center> fetchOperation = new FetchCentersImpl();
//		List<Center> centers = fetchOperation.retrieveAll();
//		//centers.forEach(System.out::println);
//		final String centerId = scanner.next();
//		UserInputValidator.validateCenterId(centerId);
//		Center center = null;
//		for (Center centerItr : centers) {
//			//if (centerItr.getCenterId()==centerId) {
//				center = centerItr;
//				break;
//			}
//		}
//	//	System.out.println("center" + center.centerId);
////
////		/* We are going to generate trainingId in trainingProgramImpl() */
////		String trainingId = null;
////		Program trainingProgram = new Program(trainingId, startDate, course, trainer, center);
////		System.out.println(trainingProgram);
////		creationStatus = traingingProgramOpn.createProgram(trainingProgram);
////
////		if (creationStatus) {
////			System.out.println("Training Program Creation Success");
////		} else {
////			System.out.println("Oop!! We encountered an error!! Please Try again after some times");
////		}
////
////	}
//
////	public void choice2Selection() throws ProgramException {
////		scanner = new Scanner(System.in);
////		System.out.println("Select your option:---");
////		System.out.println("1. Enroll Student");
////		System.out.println("2. Remove Student");
////		System.out.println("3. Exit");
////		try {
////			final int subChoice = scanner.nextInt();
////			switch (subChoice) {
////			case 1:
////				enrollStudent();
////				break;
////			case 2:
////				removeStudent();
////				break;
////			case 3:
////				return;
////			default:
////				System.out.println("Wrong choice entered!");
////			}
////			return;
////		} catch (InputMismatchException e) {
////			System.err.println("Wrong format input");
////		}
//
////	}
////
////	private void removeStudent() throws ProgramException {
////		System.out.println("Enter Student id");
////		final String studentId = scanner.next();
////		UserInputValidator.validateStudentId(studentId);
////		System.out.println("Enter Training id");
////		final String trainingId = scanner.next();
////		UserInputValidator.validateTrainingId(trainingId);
////		boolean flag = false;
////		flag = studentOpn.removeStudent(studentId, trainingId);
////		if (flag) {
////			System.out.println("Successfully Deleted");
////		} else {
////			System.err.println("Some error Occured in deletion");
////		}
////		return;
////	}
////
////	private void enrollStudent() throws ProgramException {
////		boolean enrollmentStatus = false;
////		System.out.println("Enter the Student First Name");
////		String studentFirstName = scanner.next();
////		System.out.println("Enter the Student Last Name");
////		String studentLastName = scanner.next();
////		final String studentName = studentFirstName + " " + studentLastName;
////		UserInputValidator.validateName(studentName);
////		String studentId = null;
////
////		System.out.println("Select the available training Program");
////		Set<Program> programs = traingingProgramOpn.retrieveAllTrainingProgram();
////		programs.forEach(System.out::println);
////		System.out.println("Enter the selected TrainingProgram ID");
////		final String programId = scanner.next();
////		UserInputValidator.validateTrainingId(programId);
////		Program program = traingingProgramOpn.retrieveTrainingProgram(programId);
////		Student student = new Student(studentId, studentName,program);
////		
////
////		
////
////		enrollmentStatus = studentOpn.enrollStudent(student, program);
////		if (enrollmentStatus) {
////			System.out.println("Student Successfully enrolled to Program");
////		} else {
////			System.out.println("We are facing some internal error!! Sorry for the enconvenience");
////		}
////
////		return;
////
////	}
//
//}
