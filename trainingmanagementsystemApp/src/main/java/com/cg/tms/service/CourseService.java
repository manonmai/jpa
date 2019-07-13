package com.cg.tms.service;

import java.util.*;

import com.cg.tms.entity.Course;
import com.cg.tms.exception.ProgramException;

/**
 * 
 */
public interface CourseService {

	/**
	 * 
	 */
	public boolean addCourse(Course course);

	/**
	 * 
	 */
	public boolean deleteCourse(Course course);

	/**
	 * 
	 */
	public boolean modifyCourse(Course course);

	/**
	 * @throws DatabaseWriteException
	 * @throws ProgramException 
	 * @throws CourseNotFoundException 
	 * 
	 */
	public Set<Course> getAllCourse() throws ProgramException;

	/**
	 * @throws DatabaseWriteException
	 * @throws CourseNotFoundException 
	 * @throws TrainingProgramNotFoundException 
	 * @throws ProgramException 
	 * 
	 */
	public Course getCourseDetails(int courseId) throws ProgramException;

}