package com.cg.tms.dao;
import java.util.*;

import com.cg.tms.entity.Employee;
import com.cg.tms.entity.Program;
import com.cg.tms.exception.ProgramException;

/**
 * 
 */
public interface CrudService<T> {

	/**
	 * 
	 */
	public boolean create(T o) throws ProgramException;

	/**
	 * 
	 */
	public boolean update(T o) throws ProgramException ;

	/**
	 * @throws ProgramException 
	 * 
	 */
	public T retrieve(int o) throws ProgramException;

	/**
	 * @throws ProgramException 
	 * 
	 */
	public boolean delete(T o) throws ProgramException;

	/**
	 * @throws ProgramException 
	 * 
	 */
	public Set<Employee> retrieveAll() throws ProgramException;

	

	

}