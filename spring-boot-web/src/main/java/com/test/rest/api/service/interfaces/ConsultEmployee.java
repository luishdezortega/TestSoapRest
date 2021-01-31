package com.test.rest.api.service.interfaces;

import org.springframework.http.ResponseEntity;

import com.test.rest.api.domain.EmployeeDTO;

public interface ConsultEmployee {

	ResponseEntity<EmployeeDTO> consultEmployee(String name, String lastName, String typeId, String id,
			String birthDate, String bondingDate, String position, Double salary);

}
