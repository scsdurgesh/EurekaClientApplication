package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.entity.Employee;

@RestController
public class SingleEmployeeRecordController {

	@Autowired
	private RestTemplate restTemplet;
	
	@RequestMapping("/employee/{empId}")
	public String getEmployeeNameByID(@PathVariable Long empId){
//		restTemplet =new RestTemplate();
		Employee employee=restTemplet.getForObject("http://springrestdemo/rest/employee/"+empId,Employee.class);
		return employee.getName();
	}
}
