package com.cg.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name = "role")
public class Roles {
	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", roleDesc=" + roleDesc + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ROLE")
	@SequenceGenerator(sequenceName = "seq_role", allocationSize = 1, name = "SEQ_ROLE")

	private int roleId;
@Column(name="role_desc")
	private String roleDesc;

	public Roles() {
	}



	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getEmployeeId() {
		return roleDesc;
	}

	public void setEmployeeId(String employeeId) {
		this.roleDesc = employeeId;
	}

}
