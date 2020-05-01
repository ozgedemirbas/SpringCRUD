package com.ozge.service;

import java.util.List;

import com.ozge.domain.Department;
import com.ozge.domain.Employees;
import com.ozge.domain.Job;




public interface EmployeeService {

	public List<Employees> getEmployee();

	public void saveEmployee(Employees emp);

	public List<Job> getJobs();

	public List<Department> getDepartments();
	
	public Employees getEmployee(int empId);
	
	public void deleteEmployee(int empId);

	public List<Employees> getAraEmployee(Employees emp);
	
	

}
