package com.test.rest.api.models;

import java.time.LocalDate;

public class Employee {

	private String name;

	private String lastName;

	private String typeId;

	private String numId;

	private LocalDate birthDate;

	private LocalDate bondingDate;

	private String position;

	private Double salary;

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

	public String getNumId() {
		return numId;
	}

	public void setNumId(String numId) {
		this.numId = numId;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getBondingDate() {
		return bondingDate;
	}

	public void setBondingDate(LocalDate bondingDate) {
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

	@Override
	public String toString() {
		return "Employee [name=" + name + ", lastName=" + lastName + ", typeId=" + typeId + ", numId=" + numId
				+ ", birthDate=" + birthDate + ", bondingDate=" + bondingDate + ", position=" + position + ", salary="
				+ salary + "]";
	}

}
