package com.test.rest.api;

import com.test.rest.api.wsdl.Employee;
import com.test.rest.api.wsdl.SaveEmployeeRequest;
import com.test.rest.api.wsdl.SaveEmployeeResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class EmployeeClient extends WebServiceGatewaySupport {


    public EmployeeClient() {
    }

    String urlSoap = "http://localhost:8080/ws/employee";
    String callBack = "http://practica-web-service-soap/SaveEmployeeRequest";

    public SaveEmployeeResponse saveEmployee(Employee employee) {
        SaveEmployeeRequest request = new SaveEmployeeRequest();
        request.setEmployee(employee);
        SaveEmployeeResponse response = (SaveEmployeeResponse) getWebServiceTemplate().
                marshalSendAndReceive(urlSoap, request, new SoapActionCallback(callBack));
        return response;
    }
}