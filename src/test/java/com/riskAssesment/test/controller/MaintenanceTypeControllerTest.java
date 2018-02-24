//package com.riskAssesment.test.controller;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Matchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.google.gson.reflect.TypeToken;
//import com.riskAssesment.controller.MaintenanceTypeController;
//import com.riskAssesment.model.MaintenanceType;
//import com.riskAssesment.service.MaintenanceTypeService;
//import com.riskAssesment.util.TestUtils;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(MaintenanceTypeController.class)
//public class MaintenanceTypeControllerTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//	MaintenanceTypeService maintenanceService;
//
//	private final String URL = "/maintenance/";
//
//	@Test
//	public void testGetMaintenanceType() throws Exception {
//
//		// prepare data and mock's behaviour
//		MaintenanceType empStub = new MaintenanceType(1L, "Software");
//		when(maintenanceService.getById(any(Long.class))).thenReturn(empStub);
//
//		// execute
//		MvcResult result = mockMvc
//				.perform(MockMvcRequestBuilders.get(URL + "{id}", new Long(18)).accept(MediaType.APPLICATION_JSON_UTF8))
//				.andReturn();
//
//		// verify
//		int status = result.getResponse().getStatus();
//		assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
//
//		// verify that service method was called once
//		verify(maintenanceService).getById(any(Long.class));
//
//		MaintenanceType resultMaintenanceType = TestUtils.jsonToObject(result.getResponse().getContentAsString(),
//				MaintenanceType.class);
//		System.out.println("resultMaintenanceType : "+resultMaintenanceType.getId());
//		assertNotNull(resultMaintenanceType);
//		assertEquals(1l, resultMaintenanceType.getId().longValue());
//	}
//
//	@Test
//	public void testGetAllMaintenanceType() throws Exception {
//
//		// prepare data and mock's behaviour
//		List<MaintenanceType> maintenanceList = buildMaintenanceType();
//		when(maintenanceService.getAllMaintenanceType()).thenReturn(maintenanceList);
//
//		// execute
//		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(URL +"/all").accept(MediaType.APPLICATION_JSON_UTF8))
//				.andReturn();
//
//		// verify
//		int status = result.getResponse().getStatus();
//		assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
//
//		// verify that service method was called once
//		verify(maintenanceService).getAllMaintenanceType();
//
//		// get the List<Employee> from the Json response
//		TypeToken<List<MaintenanceType>> token = new TypeToken<List<MaintenanceType>>() {
//		};
//		@SuppressWarnings("unchecked")
//		List<MaintenanceType> maintenanceTypeListResult = TestUtils
//				.jsonToList(result.getResponse().getContentAsString(), token);
//
//		assertNotNull("MaintenanceType not found", maintenanceTypeListResult);
//		assertEquals("Incorrect MaintenanceType List", maintenanceList.size(), maintenanceTypeListResult.size());
//
//	}
//
//	private List<MaintenanceType> buildMaintenanceType() {
//		MaintenanceType m1 = new MaintenanceType(1l, "Softare");
//		MaintenanceType m2 = new MaintenanceType(2l, "Hardware");
//		List<MaintenanceType> maintenanceTypeList = Arrays.asList(m1, m2);
//		return maintenanceTypeList;
//	}
//
//}
