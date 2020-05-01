package com.ozge.dao;

import java.util.List;

import com.ozge.domain.Department;
import com.ozge.domain.Employees;
import com.ozge.domain.Job;


public interface EmployeeDAO {

	public List<Employees> getOgrenciler();

	public List<Job> getJobs();

	public List<Department> getDepartments();

	public void saveEmployee(Employees emp);

	public Employees getEmployee(int empId);
	
	public void deleteEmployee(int empId);

	public List<Employees> getAraEmployee(Employees emp);
	

}
