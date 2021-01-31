package com.test.rest.api.service.impl;

import static com.test.rest.api.util.ConstantsEmployee.AGE_ADULT;
import static com.test.rest.api.util.ConstantsEmployee.ERROR_VALIDATION_AGE;
import static com.test.rest.api.util.ConstantsEmployee.TIME_ERROR_PARSER;
import static com.test.rest.api.util.ConstantsEmployee.TIME_FORMAT;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.rest.api.domain.EmployeeDTO;
import com.test.rest.api.exception.EmployeeException;
import com.test.rest.api.models.Employee;

@Service
public class ConsultEmployeeImpl implements com.test.rest.api.service.interfaces.ConsultEmployee {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultEmployeeImpl.class);

	@Override
	public ResponseEntity<EmployeeDTO> consultEmployee(String name, String lastName, String typeId, String id,
			String birthDate, String bondingDate, String position, Double salary) {

		if (validateNullOrEmpty(name) && validateNullOrEmpty(lastName) && validateNullOrEmpty(typeId)
				&& validateNullOrEmpty(id) && validateNullOrEmpty(birthDate) && validateNullOrEmpty(bondingDate)
				&& validateNullOrEmpty(position)) {

			try {
				LocalDate birthDateEmployee = validateDateFormat(birthDate);
				if (Boolean.TRUE.equals(isAdult(birthDateEmployee))) {

					Employee employee = new Employee();
					employee.setBirthDate(birthDateEmployee);
					employee.setBondingDate(validateDateFormat(bondingDate));
					employee.setName(name);
					employee.setLastName(lastName);
					employee.setTypeId(typeId);
					employee.setNumId(id);
					employee.setPosition(position);
					employee.setSalary(salary);

					/**
					 * Invocacion del SOAP
					 */

					EmployeeDTO employeeDTO = new EmployeeDTO(employee);
					employeeDTO.setBondingTimeMonths(betweenDateNow(employee.getBondingDate()).getMonths());
					employeeDTO.setCurrentAgeYears(betweenDateNow(employee.getBirthDate()).getYears());
					return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
				} else {
					LOGGER.info(ERROR_VALIDATION_AGE);
				}
			} catch (EmployeeException e) {
				LOGGER.error(e.getMessage());
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	private Boolean validateNullOrEmpty(String string) {
		return (string != null && !string.isEmpty() && !string.isBlank());
	}

	private LocalDate validateDateFormat(String date) throws EmployeeException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_FORMAT);
		try {
			return LocalDate.parse(date, formatter);
		} catch (DateTimeParseException e) {
			throw new EmployeeException(TIME_ERROR_PARSER, e);
		}
	}

	private Boolean isAdult(LocalDate date) {
		return Period.between(date, LocalDate.now()).getYears() >= AGE_ADULT;
	}

	private Period betweenDateNow(LocalDate date) {
		return Period.between(date, LocalDate.now());
	}

}
