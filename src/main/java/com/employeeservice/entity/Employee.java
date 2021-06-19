package com.employeeservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="employee")
@Getter
@Setter
@Validated
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8066062372297155866L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employeeid")
	private Long employeeid;

	@NotEmpty(message="name should not be empty")
	@Column(name="name")
	private String name;

	@NotEmpty(message="dob should not be empty")
	@Column(name="dob")
	private String dob;

	@NotEmpty(message="pan should not be empty")
	@Column(name="pan")
	private String pan;

	@NotEmpty(message="address should not be empty")
	@Column(name="address")
	private String address;

	@NotNull(message="department id should not be NULL")
	@ManyToOne(optional = false)
	@JoinColumn(name = "departmentid", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Department departmentid;
}
