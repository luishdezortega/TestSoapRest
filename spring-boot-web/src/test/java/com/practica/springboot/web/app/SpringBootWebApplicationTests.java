package com.practica.springboot.web.app;

import com.test.rest.api.SpringBootWebApplication;
import com.test.rest.api.service.EmployeeClient;
import com.test.rest.api.wsdl.SaveEmployeeResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {SpringBootWebApplication.class})
@AutoConfigureMockMvc
class SpringBootWebApplicationTests {

    @Autowired
    private MockMvc restMock;

    @MockBean
    EmployeeClient employeeClient;


    @Test
    void getEmployeeTest() throws Exception {
        SaveEmployeeResponse response = new SaveEmployeeResponse();
        Mockito.when(employeeClient.saveEmployee(Mockito.any())).thenReturn(response);
        this.restMock.perform(get("/api/consult/employee").contentType(MediaType.APPLICATION_JSON)
                .param("name", "LUIS CARLOS")
                .param("lastName", "HERNANDEZ")
                .param("typeId", "CC")
                .param("id", "2003")
                .param("birthDate", "29-Mar-2000")
                .param("bondingDate", "15-Mar-2020")
                .param("position", "DESARROLLADOR")
                .param("salary", "3848499")
        ).andDo(print()).andExpect(status().isOk());
    }

}
