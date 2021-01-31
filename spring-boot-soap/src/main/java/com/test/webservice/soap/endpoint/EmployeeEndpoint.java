package com.test.webservice.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.test.webservice.soap.models.EmployeeEntity;
import com.test.webservice.soap.repository.EmployeeRepository;

import practica_web_service_soap.SaveEmployeeRequest;
import practica_web_service_soap.SaveEmployeeResponse;

@Endpoint
@Transactional
public class EmployeeEndpoint {
	private static final String NAMESPACE_URI = "http://practica-web-service-soap";

	@Autowired
	private EmployeeRepository employeeRepository;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveEmployeeRequest")
	@ResponsePayload
	public SaveEmployeeResponse getCountry(@RequestPayload SaveEmployeeRequest request) {
		SaveEmployeeResponse response = new SaveEmployeeResponse();

		EmployeeEntity employee = new EmployeeEntity(request.getEmployee().getNumId(), request.getEmployee().getName(),
				request.getEmployee().getLastName(), request.getEmployee().getTypeId(),
				request.getEmployee().getBirthDate(), request.getEmployee().getBondingDate(),
				request.getEmployee().getPosition(), Double.parseDouble(request.getEmployee().getSalary()));

		try {
			this.employeeRepository.save(employee);
			response.setResponse("Ejecucion Exitosa");
		} catch (Exception e) {
			response.setResponse("Ejecucion Fallida");
		}

		return response;
	}
}
