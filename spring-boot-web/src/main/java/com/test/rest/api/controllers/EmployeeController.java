package com.test.rest.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.rest.api.domain.EmployeeDTO;
import com.test.rest.api.exception.EmployeeException;
import com.test.rest.api.service.interfaces.ConsultEmployee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
@Api("Api Rest para consultar empleado")
public class EmployeeController {

	@Autowired
	ConsultEmployee consultEmployee;

	@ApiOperation(value = "Permite consultar la información de un empleado", produces = MediaType.APPLICATION_JSON_VALUE, httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "EXITOSO", response = ResponseEntity.class),
			@ApiResponse(code = 400, message = "NOT FOUND", response = EmployeeException.class),
			@ApiResponse(code = 500, message = "SERVER ERROR") })
	@GetMapping(value = "/consult/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDTO> consultEmployee(
			@ApiParam(name = "name", type = "String", value = "Nombre", example = "Luis", required = true) @RequestParam String name,
			@ApiParam(name = "lastName", type = "String", value = "Apellido", example = "Hernandez", required = true) @RequestParam String lastName,
			@ApiParam(name = "typeId", type = "String", value = "Tipo identificación", example = "CC", required = true) @RequestParam String typeId,
			@ApiParam(name = "numId", type = "String", value = "Numero de identificación", example = "110278392", required = true) @RequestParam String id,
			@ApiParam(name = "birthDate", type = "String", value = "Fecha de nacimiento", example = "13/05/1996", required = true) @RequestParam String birthDate,
			@ApiParam(name = "bondingDate", type = "String", value = "Fecha de vinculación", example = "03/05/2007", required = true) @RequestParam String bondingDate,
			@ApiParam(name = "position", type = "String", value = "Cargo", example = "Arquitecto", required = true) @RequestParam String position,
			@ApiParam(name = "salary", type = "Double", value = "Salario", example = "1500000.0", required = true) @RequestParam Double salary) {

		return consultEmployee.consultEmployee(name, lastName, typeId, id, birthDate, bondingDate, position, salary);

	}

}
