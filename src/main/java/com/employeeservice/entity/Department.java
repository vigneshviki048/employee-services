package com.employeeservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="department")
@Getter
@Setter
public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8356971684099347585L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="departmentid")
	private Long departmentid; 
	
	@NotBlank(message = "departmentname is mandatory")
	@Column(name="departmentname")
	private String departmentname;

	@NotBlank(message = "departmenthead is mandatory")
	@Column(name="departmenthead")
	private String departmenthead;

}
