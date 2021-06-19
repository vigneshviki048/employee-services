/*
 * package com.employeeservice.controller;
 * 
 * import static org.junit.Assert.assertNotNull; import static
 * org.junit.jupiter.api.Assertions.assertEquals;
 * 
 * import org.junit.Before; import org.junit.Test; import
 * org.junit.platform.engine.SelectorResolutionResult.Status; import
 * org.junit.runner.RunWith; import org.mockito.InjectMocks;import
 * org.mockito.Mock; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
 * import org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.http.HttpHeaders; import
 * org.springframework.http.MediaType; import
 * org.springframework.test.context.junit4.SpringRunner; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.MvcResult; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders; import
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers;
 * 
 * import com.employeeservice.service.EmployeeService;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest
 * 
 * @AutoConfigureMockMvc public class EmployeeControllerTest {
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * @InjectMocks private EmployeeController employeeController;
 * 
 * private EmployeeService employeeService;
 * 
 * private String createRequestBody="{\r\n" + "    \"name\": \"Murali\",\r\n" +
 * "    \"dob\": \"01-02-1993\",\r\n" + "    \"pan\": \"BJGGGHYY\",\r\n" +
 * "    \"address\": \"ABC\",\r\n" + "    \"departmentid\": {\r\n" +
 * "        \"departmentid\": 2\r\n" + "    }\r\n" + "}";
 * 
 * private String updateRequestBody="{\r\n" + "    \"employeeid\": \"1\",\r\n" +
 * "    \"name\": \"Arun\",\r\n" + "    \"dob\": \"01-02-1993\",\r\n" +
 * "    \"pan\": \"BJGGGHYY\",\r\n" + "    \"address\": \"ABC\",\r\n" +
 * "    \"departmentid\": {\r\n" + "        \"departmentid\": 2\r\n" +
 * "    }\r\n" + "}";
 * 
 * @Before public void setUp() {
 * 
 * }
 * 
 * @Test public void getEmployeeList() throws Exception { HttpHeaders
 * httpHeaders=new HttpHeaders();
 * httpHeaders.setContentType(MediaType.APPLICATION_JSON);
 * 
 * MvcResult result= (MvcResult) mockMvc.perform(MockMvcRequestBuilders.get(
 * "http://localhost:8080/employee-service/employee"))
 * .andExpect(MockMvcResultMatchers.status().isOk()); int
 * response=result.getResponse().getStatus(); assertNotNull(result);
 * assertEquals(201, response); }
 * 
 * @Test public void createEmployee() throws Exception { HttpHeaders
 * httpHeaders=new HttpHeaders();
 * httpHeaders.setContentType(MediaType.APPLICATION_JSON);
 * 
 * MvcResult result= (MvcResult) mockMvc.perform(MockMvcRequestBuilders.post(
 * "http://localhost:8080/employee-service/employee").content(createRequestBody)
 * ) .andExpect(MockMvcResultMatchers.status().isCreated()).andReturn(); int
 * response=result.getResponse().getStatus(); assertNotNull(result);
 * assertEquals(201, response); }
 * 
 * @Test public void updateEmployee() throws Exception { HttpHeaders
 * httpHeaders=new HttpHeaders();
 * httpHeaders.setContentType(MediaType.APPLICATION_JSON);
 * 
 * MvcResult result= (MvcResult) mockMvc.perform(MockMvcRequestBuilders.put(
 * "http://localhost:8080/employee-service/employee").content(updateRequestBody)
 * ) .andExpect(MockMvcResultMatchers.status().isCreated()).andReturn(); int
 * response=result.getResponse().getStatus(); assertNotNull(result);
 * assertEquals(201, response); }
 * 
 * @Test public void deleteEmployee() throws Exception { HttpHeaders
 * httpHeaders=new HttpHeaders();
 * httpHeaders.setContentType(MediaType.APPLICATION_JSON);
 * 
 * MvcResult result= (MvcResult) mockMvc.perform(MockMvcRequestBuilders.delete(
 * "http://localhost:8080/employee-service/employee/{employeeid}").param(
 * "employeeid", "3"))
 * .andExpect(MockMvcResultMatchers.status().isOk()).andReturn(); int
 * response=result.getResponse().getStatus(); assertNotNull(result);
 * assertEquals(201, response); }
 * 
 * @Test public void getEmployee() throws Exception { HttpHeaders
 * httpHeaders=new HttpHeaders();
 * httpHeaders.setContentType(MediaType.APPLICATION_JSON);
 * 
 * MvcResult result= (MvcResult) mockMvc.perform(MockMvcRequestBuilders.get(
 * "http://localhost:8080/employee-service/employee/{employeeid}").param(
 * "employeeid", "3"))
 * .andExpect(MockMvcResultMatchers.status().isOk()).andReturn(); int
 * response=result.getResponse().getStatus(); assertNotNull(result);
 * assertEquals(201, response); } }
 */