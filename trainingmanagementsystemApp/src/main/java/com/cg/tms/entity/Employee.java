package com.cg.tms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	public Employee() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLOYEE")
	@SequenceGenerator(sequenceName = "seq_employee", allocationSize = 1, name = "SEQ_EMPLOYEE")
	private int employeeId;
	private String employeeName;
	@OneToOne
	@JoinColumn(name = "roleid")
	private Roles roleId;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Roles getRole() {
		return roleId;
	}

	public void setRole(Roles role) {
		this.roleId = role;
		
	}

	public Employee(String employeeName, Roles roleId) {
		super();
		this.employeeName = employeeName;
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", roleId="+ roleId.getRoleId() + "]";
	}

}