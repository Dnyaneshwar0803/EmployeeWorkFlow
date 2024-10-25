package com.tka.EmployeeWorkFlow.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.EmployeeWorkFlow.entity.Country;
import com.tka.EmployeeWorkFlow.entity.Employee;
import com.tka.EmployeeWorkFlow.service.MainService;

@RestController
@RequestMapping("api")
public class MainController {

	@Autowired
	MainService service;
	
//	> Country API -
	
	@PostMapping("addcountry")
	public String addCountry(@RequestBody Country c) {
		String msg=service.addCountry(c);
		return msg;
	}
	
	@PutMapping("updatecountry/{id}")
	public String updateCountry(@RequestBody Country c,@PathVariable int id) {
		String str=service.updateCountry(c,id);
		return str;
	}
	
	@DeleteMapping("deletecountry/{cid}")
	public String deleteCountry(@PathVariable int cid) {
		String str = service.deleteCountry(cid);
		return str;
	}
	
	@GetMapping("getallcountry")
	public List<Country> getAllCountry(){
		List<Country> list=service.getAllCountry();
		return list;
	}
	
	@GetMapping("getcountrybyid/{cid}")
	public Country getparticularCountryById(@PathVariable int cid) {
		Country country= service.getparticularCountryById(cid);
		return country;
	}
	
//	> Employee API -
	
	@PostMapping("addemp")
	public String addEmployee(@RequestBody Employee emp) {
		String str= service.addEmployee(emp);
		return str;
	}
	
	@PutMapping("updateemp/{id}")
	public String updateEmplyoee(@RequestBody Employee e,@PathVariable int id) {
		String str=service.updateEmployee(e,id);
		return str;
	}
	
	@GetMapping("getallemp")
	public List<Employee> getAllEmplyoee(){
		List<Employee> list=service.getAllEmployee();
		return list;
	}

	@DeleteMapping("deleteemp/{id}")
	public String deleteEmployee(@PathVariable int id) {
		String msg=service.deleteEmployee(id);
		return msg;
	}
	
	@GetMapping("getParticularEmpbyId/{id}")
	public Employee getParticularEmp(@PathVariable int id) {
		Employee emp=service.getParticularEmp(id);
		return emp;
	}
	
	@PostMapping("login")
	public HashMap login(@RequestBody Employee e) {
		HashMap map=service.login(e);
		return map;
	}
	
	@GetMapping("getSalary/{startsal}/{endsal}")
	public List<Employee> getSalary(@PathVariable double startsal,@PathVariable double endsal) {
		List<Employee> list=service.getSalary(startsal,endsal);
		return list;
	}
	
	@GetMapping("statusCheck/{status}")
	public List<Employee> statusCheck(@PathVariable String status) {
		List<Employee> list=service.statusCheck(status);
		return list;
	}
	
	@GetMapping("updateStatus/{id}")
	public String updateStatus(@PathVariable int id) {
		String msg= service.updateStatus(id);
		return msg;
	}
	
}
