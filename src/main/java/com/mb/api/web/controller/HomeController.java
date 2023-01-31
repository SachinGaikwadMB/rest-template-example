package com.mb.api.web.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.mb.api.web.model.Student;

@RestController
@RequestMapping("/api/v1")
public class HomeController
{
	/**
	 * It is bad practice to write logger in our controller class
	 *  but as of now we will implemnt it in controller class.
	 * 
	 * */
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class); 
	
	private static final String URL = "http://localhost:8080/api/v1/data";
	
	
	//private static final String URL = "http://localhost:8080/api/v1/products";
	
	@Autowired
	private RestTemplate restTemplate;
	
	/*
	
	@GetMapping
	public ResponseEntity<String> getAllData() {
		
		//RestTemplate restTemplate = new RestTemplate();
		
		LOG.info("This is getAllData method calling ...");
		ResponseEntity<String>  response = 
		restTemplate.getForEntity(URL, String.class);	
		
		LOG.info("Status Code => {}", response.getStatusCode());
		LOG.info("Status Code Value => {}", response.getStatusCodeValue());
		LOG.info("Response Body => {} ", response.getBody());
		
		return response;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<String> getSingleData(@PathVariable Integer id) {
		String userJsn  = restTemplate.getForObject(URL+ "/{id}", String.class, Map.of("id", id));
		return new ResponseEntity<>(userJsn, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<String> saveUser(@RequestBody ProductModel request ){
	
		//RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> user = restTemplate.postForEntity(URL, request, String.class);
		
		return user;
	}
	
	*/
	
	
	
	
//	
//	@GetMapping("/request")
//	public ResponseEntity<Student> getRequestedData() {
//		
//		
//		/**
//		 * AT the consumer side the data come into the string type so we need to convert thata string type the 
//		 * JSON format for that purpose we some JSON converter like Jackson, Gson etc
//		 * 
//		 * */
//		ResponseEntity<Student> response = restTemplate.getForEntity(URL, Student.class);
//		
//		
//		LOG.info("Direct response = > {}", response);
//		
//		/*
//		String json = response.getBody();
//		try
//		{
//		 ObjectMapper objectMapper = new ObjectMapper();
//		 
//		  Student student = objectMapper.readValue(json, Student.class);
//		  LOG.info("Student object is  => {}", student);
//		  
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//		
//		*/
//		
//		LOG.info("Http Status => {}", response.getStatusCode());
//		
//		LOG.info("Response body => {}", response.getBody());
//		
//		return response;
//	}
//	
//	
//	@PostMapping("/request")
//	public ResponseEntity<String> saveRequestedData() {
//		
//		String req = null;
//		
//		ResponseEntity<String> response = restTemplate.postForEntity(URL, req, String.class);
//		
//		LOG.info("Http Status => {}", response.getStatusCode());
//		
//		LOG.info("Response body => {}", response.getBody());
//		
//		return response;
//	}
//	
	
	@GetMapping("/request")
	public ResponseEntity<Student> getAllData() {
		
		//This time we will not use the GET method at
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		
		HttpEntity<Student> requestEntity = new HttpEntity<>(headers); 
		
		ResponseEntity<Student> response = restTemplate.exchange(URL, HttpMethod.GET, requestEntity, Student.class);
		
		
		return response;
	}
	
	
	@PostMapping("/request")
	public ResponseEntity<String> saveData() {
	
	HttpHeaders headers = new HttpHeaders();
	headers.add("accept", "application/json");
     headers.add("content-type", "application/json");
	
	
	String student = "{\n"
			+ "    \"id\": 10,\n"
			+ "    \"firstName\": \"Sachin\",\n"
			+ "    \"lastName\": \"Gaikwad\",\n"
			+ "    \"email\": \"sachin@gmail.com\",\n"
			+ "    \"address\": \"India\"\n"
			+ "}";
			
			
	
	HttpEntity<String> requestEntity = new HttpEntity<>(student,headers);
	
	ResponseEntity<String> response	= restTemplate.exchange(URL, HttpMethod.POST, requestEntity, String.class);
		return response;
	}
	
	
}
