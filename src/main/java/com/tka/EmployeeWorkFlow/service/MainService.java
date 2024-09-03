package com.tka.EmployeeWorkFlow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.EmployeeWorkFlow.dao.MainDao;
import com.tka.EmployeeWorkFlow.entity.Country;
import com.tka.EmployeeWorkFlow.entity.Employee;

@Service
public class MainService {

	@Autowired
	MainDao dao;
	
//	> Country API -

	public String addCountry(Country c) {

		String msg = dao.addCountry(c);
		if (Objects.isNull(msg)) {
			msg = "Country is not Added";
		}
		return msg;
	}

	public String updateCountry(Country c, int id) {

		String str = dao.updateCountry(c, id);
		if (Objects.isNull(str)) {
			str = "Country is not Updated";
		}
		return str;
	}

	public String deleteCountry(int cid) {

		String str = dao.deleteCountry(cid);
		if (Objects.isNull(str)) {
			str = "Country is not be Deleted";
		}
		return str;
	}

	public List<Country> getAllCountry() {
		List<Country> list = dao.getAllCountry();
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	public Country getparticularCountryById(int cid) {
		Country country = dao.getparticularCountryById(cid);
		if (Objects.isNull(country)) {
			country = null;
		}
		return country;
	}
	
//	> Employee API -

	public String addEmployee(Employee emp) {
		String msg = dao.addEmployee(emp);
		if (Objects.isNull(msg)) {
			msg = "Employee is not Addedd";
		}
		return msg;
	}

	public String updateEmployee(Employee e, int id) {

		String str = dao.updateEmployee(e, id);
		if (Objects.isNull(str)) {
			str = "Employee is not Updated";
		}
		return str;
	}

	public List<Employee> getAllEmployee() {

		List<Employee> list = dao.getAllEmployee();
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	public Employee getParticularEmp(int id) {

		Employee emp = dao.getParticularEmp(id);
		if (Objects.isNull(emp)) {
			emp = null;
		}
		return emp;
	}

	public HashMap login(Employee e) {

		Employee emp = dao.login(e);

		HashMap map = new HashMap();
		if (Objects.isNull(emp)) {
			map.put("msg", "Invalid User");
		} else {
			map.put("msg", "Valid User");
		}
		map.put("user", emp);
		return map;
	}

	public List<Employee> getSalary(double startsal, double endsal) {

		List<Employee> list = dao.getSalary(startsal,endsal);
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}
	
	public List<Employee> statusCheck(String status) {

		List<Employee> list = dao.statusCheck(status);
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	public String updateStatus(int id) {

		String msg=dao.updateStatus(id);
		return msg;
	}

}
