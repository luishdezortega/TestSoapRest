package com.test.rest.api.service.impl;

import com.test.rest.api.EmployeeClient;
import com.test.rest.api.domain.EmployeeDTO;
import com.test.rest.api.exception.EmployeeException;
import com.test.rest.api.wsdl.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.test.rest.api.util.ConstantsEmployee.*;

@Service
public class ConsultEmployeeImpl implements com.test.rest.api.service.interfaces.ConsultEmployee {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultEmployeeImpl.class);

    @Autowired
    private EmployeeClient employeeClientent;

    @Override
    public ResponseEntity<EmployeeDTO> consultEmployee(String name, String lastName, String typeId, String id,
                                                       String birthDate, String bondingDate, String position, Double salary) {

        if (validateNullOrEmpty(name) && validateNullOrEmpty(lastName) && validateNullOrEmpty(typeId)
                && validateNullOrEmpty(id) && validateNullOrEmpty(birthDate) && validateNullOrEmpty(bondingDate)
                && validateNullOrEmpty(position)) {

            try {
                LocalDate birthDateEmployee = validateDateFormat(birthDate);
                LocalDate bondingDateEmployee = validateDateFormat(bondingDate);
                if (Boolean.TRUE.equals(isAdult(birthDateEmployee))) {
                    com.test.rest.api.wsdl.Employee employee = new Employee();
                    employee.setBirthDate(birthDateEmployee.toString());
                    employee.setBondingDate(bondingDateEmployee.toString());
                    employee.setName(name);
                    employee.setLastName(lastName);
                    employee.setTypeId(typeId);
                    employee.setNumId(id);
                    employee.setPosition(position);
                    employee.setSalary(salary.toString());
                    employeeClientent.saveEmployee(employee);
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setBondingTimeMonths(betweenDateNow(bondingDateEmployee).getMonths());
                    employeeDTO.setCurrentAgeYears(betweenDateNow(birthDateEmployee).getYears());
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
