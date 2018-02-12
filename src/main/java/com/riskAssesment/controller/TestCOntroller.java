package com.riskAssesment.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.riskAssesment.service.EmployeeService;

@RestController
@RequestMapping("/test")
public class TestCOntroller {
	@Autowired
	EmployeeService employeeService;

	@SuppressWarnings("unchecked")
	@GetMapping("/apps")
	public ResponseEntity<String> getAllApps() {
		ResponseEntity<String> applications = null;

		try {
			final String uri = "https://biker201802020649579.saas.appdynamics.com/controller/rest/applications?output=JSON";
			RestTemplate restTemplate = new RestTemplate();

			String plainCreds = "amit@biker201802020649579:test123";
			byte[] plainCredsBytes = plainCreds.getBytes();
			byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
			String base64Creds = new String(base64CredsBytes);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Basic " + base64Creds);
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

			applications = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

			System.out.println("applications : " + applications.getBody());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(applications.getBody());
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/tiers")
	public ResponseEntity<String> getAllTiers(@RequestParam("appName") String appName) {
		ResponseEntity<String> applications = null;
		System.out.println("appName : " + appName);

		try {
			final String uri = "https://biker201802020649579.saas.appdynamics.com/controller/rest/applications/"+appName+"/tiers?output=JSON";
			RestTemplate restTemplate = new RestTemplate();

			String plainCreds = "amit@biker201802020649579:test123";
			byte[] plainCredsBytes = plainCreds.getBytes();
			byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
			String base64Creds = new String(base64CredsBytes);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Basic " + base64Creds);
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

			applications = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

			System.out.println("applications : " + applications.getBody());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(applications.getBody());
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/nodes")
	public ResponseEntity<String> getAllNodes(@RequestParam("appName") String appName) {
		ResponseEntity<String> applications = null;
		System.out.println("appName : " + appName);
		
		try {
//			final String uri = "https://biker201802020649579.saas.appdynamics.com/controller/rest/applications/"+appName+"/tiers?output=JSON";
			final String uri = "https://biker201802020649579.saas.appdynamics.com/controller/rest/applications/"+appName+"/nodes?output=JSON";
			RestTemplate restTemplate = new RestTemplate();
			
			String plainCreds = "amit@biker201802020649579:test123";
			byte[] plainCredsBytes = plainCreds.getBytes();
			byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
			String base64Creds = new String(base64CredsBytes);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Basic " + base64Creds);
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			
			applications = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
			
			System.out.println("applications : " + applications.getBody());
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(applications.getBody());
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/metrics")
	public ResponseEntity<String> getPerformanceMetrics(@RequestParam("appName") String appName, @RequestParam("webTier") String webTier,@RequestParam("nodeName") String nodeName) {
		ResponseEntity<String> applications = null;
		System.out.println("appName : " + appName);
		
		try {
			final String uri = "https://biker201802020649579.saas.appdynamics.com/controller/rest/applications/"+appName+"/metric-data?metric-path=Application%20Infrastructure%20Performance%7C"+webTier+"%7CIndividual%20Nodes%7C"+nodeName+"%7CJVM%7CMemory%7CHeap%7CMax%20Available%20%28MB%29&time-range-type=BEFORE_NOW&duration-in-mins=5?output=json";
			System.out.println("uri : "+uri);
			RestTemplate restTemplate = new RestTemplate();
			
			String plainCreds = "amit@biker201802020649579:test123";
			byte[] plainCredsBytes = plainCreds.getBytes();
			byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
			String base64Creds = new String(base64CredsBytes);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Basic " + base64Creds);
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			
			applications = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
			
			System.out.println("applications : " + applications.getBody());
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(applications.getBody());
	}

}
