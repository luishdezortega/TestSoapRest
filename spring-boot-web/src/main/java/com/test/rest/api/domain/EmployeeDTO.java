package com.test.rest.api.domain;

import com.test.rest.api.models.Employee;

public class EmployeeDTO extends Employee {

	private int bondingTimeMonths;

	private int currentAgeYears;

	public EmployeeDTO(Employee employee) {
		this.setName(employee.getName());
		this.setLastName(employee.getLastName());
		this.setTypeId(employee.getTypeId());
		this.setNumId(employee.getNumId());
		this.setBirthDate(employee.getBirthDate());
		this.setBondingDate(employee.getBondingDate());
		this.setPosition(employee.getPosition());
		this.setSalary(employee.getSalary());
	}

	public int getBondingTimeMonths() {
		return bondingTimeMonths;
	}

	public void setBondingTimeMonths(int bondingTimeMonths) {
		this.bondingTimeMonths = bondingTimeMonths;
	}

	public int getCurrentAgeYears() {
		return currentAgeYears;
	}

	public void setCurrentAgeYears(int currentAgeYears) {
		this.currentAgeYears = currentAgeYears;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [bondingTimeMonths=" + bondingTimeMonths + ", currentAgeYears=" + currentAgeYears + "]";
	}

}
