package com.test.rest.api.service.interfaces;

import com.test.rest.api.domain.EmployeeDTO;
import org.springframework.http.ResponseEntity;

public interface ConsultEmployee {

    ResponseEntity<EmployeeDTO> consultEmployee(String name, String lastName, String typeId, String id,
                                                String birthDate, String bondingDate, String position, Double salary);

}
