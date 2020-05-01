package com.ozge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ozge.dao.EmployeeDAO;
import com.ozge.domain.Department;
import com.ozge.domain.Employees;
import com.ozge.domain.Job;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	@Transactional
	@Override
	public List<Employees> getEmployee() {

		return employeeDAO.getOgrenciler();
	}

	@Transactional
	@Override
	public void saveEmployee(Employees emp) {
		employeeDAO.saveEmployee(emp);

	}

	@Transactional
	@Override
	public List<Job> getJobs() {

		return employeeDAO.getJobs();
	}

	@Transactional
	@Override
	public List<Department> getDepartments() {

		return employeeDAO.getDepartments();
	}

	@Transactional
	@Override
	public Employees getEmployee(int empId) {

		return employeeDAO.getEmployee(empId);
	}

	@Transactional
	@Override
	public void deleteEmployee(int empId) {
		
		employeeDAO.deleteEmployee(empId);
	}

	@Transactional
	@Override
	public List<Employees> getAraEmployee(Employees emp) {
		
		return employeeDAO.getAraEmployee(emp);
	}


}
