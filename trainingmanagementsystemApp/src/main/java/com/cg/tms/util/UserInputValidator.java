package com.cg.tms.util;

import com.cg.tms.entity.Employee;
import com.cg.tms.entity.Roles;
import com.cg.tms.exception.ProgramException;

/*Server side validation*/
public class UserInputValidator {

	public boolean validateName(String name) throws ProgramException {
		boolean flag = true;
    if (!name.matches("^[A-Z a-z]{3,20}$")) {
			throw new ProgramException("Invalid format Name! \n Your name cannot contain special character or digits");
		}
		return flag;
	}

	public boolean validateCourseId(String courseId) throws ProgramException {

		if (!courseId.matches("CO_[0-9]{4}")) {
			throw new ProgramException("Invalid format of input for Course! \n You must use CD_1001 format");
		}
		return true;

	}

	public boolean validateRoleId(Employee trainer) throws ProgramException {
		Roles role = trainer.getRole();
		String tempRole = Integer.toString(role.getRoleId());
		if (!tempRole.matches("10005")) {
			throw new ProgramException("Invalid roleid format  for Trainee! \n You must use 10005 format");
		}
		return true;

	}

	public boolean validateCenterId(String centerId) throws ProgramException {
		if (!centerId.matches("CN_[0-9]{4}")) {
			throw new ProgramException("Invalid format of input for Center! \n You must use CN_1001 format");
		}
		return true;
	}

	public boolean validateTrainingId(String trainingId) throws ProgramException {
		if (!trainingId.matches("TP_[0-9]{4}")) {
			throw new ProgramException("Invalid format of input for Training Program! \n You must use TP_1001 format");
		}
		return true;
	}

	public boolean validateStudentId(String studentId) throws ProgramException {
		if (!studentId.matches("ST_[0-9]{4}")) {
			throw new ProgramException("Invalid format of input for Student! \n You must use TP_1001 format");
		}
		return true;

	}

}