package com.test.webservice.soap.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity implements Serializable {

	private static final long serialVersionUID = -373685114367590194L;

	@Id
	@Column(name = "numId", nullable = false, unique = true)
	private String numId;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "lastName", nullable = false, length = 50)
	private String lastName;

	@Column(name = "typeId", nullable = false, length = 50)
	private String typeId;

	@Column(name = "birthDate", nullable = false, length = 50)
	private String birthDate;

	@Column(name = "bondingDate", nullable = false, length = 50)
	private String bondingDate;

	@Column(name = "position", nullable = false, length = 50)
	private String position;

	@Column(name = "salary", nullable = false)
	private Double salary;
	
	public EmployeeEntity() {}

	public EmployeeEntity(String numId, String name, String lastName, String typeId, String birthDate,
			String bondingDate, String position, Double salary) {
		this.numId = numId;
		this.name = name;
		this.lastName = lastName;
		this.typeId = typeId;
		this.birthDate = birthDate;
		this.bondingDate = bondingDate;
		this.position = position;
		this.salary = salary;
	}

	public String getNumId() {
		return numId;
	}

	public void setNumId(String numId) {
		this.numId = numId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBondingDate() {
		return bondingDate;
	}

	public void setBondingDate(String bondingDate) {
		this.bondingDate = bondingDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
