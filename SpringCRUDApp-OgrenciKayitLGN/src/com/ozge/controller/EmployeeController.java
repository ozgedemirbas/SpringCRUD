package com.ozge.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.ozge.domain.Department;
import com.ozge.domain.Employees;
import com.ozge.domain.Job;
import com.ozge.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/list")
	public String employeeList(Model model, HttpSession oturum) {

		String isimKontrol = (String) oturum.getAttribute("oturum");
		if (isimKontrol == null) {
			return "redirect:/user/login";
		} else {

			List<Employees> empList = employeeService.getEmployee();

			model.addAttribute("employee", empList);
			
			Employees emp1=new Employees();
			model.addAttribute("ara", emp1);

			return "employee-list";
		}
	}

	@PostMapping("/search")
	public String EmployeeAra(@ModelAttribute("ara") Employees employee, Model model) {
		
		List<Employees> emplist = employeeService.getAraEmployee(employee);
		model.addAttribute("employee",emplist);
		return "employee-list";
	}
	
	
	
	
	
	@GetMapping("/calisan-ekle")
	public String ogrenciEkle(Model model, HttpSession oturum) {
		String isimKontrol = (String) oturum.getAttribute("oturum");
		if (isimKontrol == null) {
			return "redirect:/user/login";
		}

		Employees emp = new Employees();
		model.addAttribute("employee", emp);

		return "employee-form";

	}

	@PostMapping("/employee-kaydet")
	public String ogrenciKaydet(@Valid @ModelAttribute("employee") Employees emp, BindingResult bindingResult) {

		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult); 
			return "employee-form";
		}
		
		
		employeeService.saveEmployee(emp);
		
		return "redirect:/employee/list";
	}

	@ModelAttribute("jobs")
	public Map<String, String> getJobs() {

		List<Job> jobList = employeeService.getJobs();
		Map<String, String> jobbs = new HashMap<String, String>();
		for (Job job : jobList) {
			jobbs.put(job.getJobId(), job.getJobTitle());
		}

		return jobbs;
	}

	@ModelAttribute("departments")
	public Map<Integer, String> getDepartment() {

		List<Department> depList = employeeService.getDepartments();
		Map<Integer, String> depts = new HashMap<Integer, String>();
		for (Department department : depList) {
			// if (department.getManager() != null)
			depts.put(department.getDepartmentId(), department.getDepartmentName());
		}

		return depts;
	}

	@ModelAttribute("employeeList")
	public Map<Integer, String> getEmployee() {

		List<Employees> empList = employeeService.getEmployee();
		Map<Integer, String> emp = new HashMap<Integer, String>();
		for (Employees employees : empList) {
			if (employees.getManager() != null) {
				emp.put(employees.getManager().getEmployeeId(),
						employees.getManager().getFirstName() + " " + employees.getManager().getLastName());
			}
		}

		return emp;
	}

	@GetMapping("/employee-guncelle")
	public String employeeGuncelle(@RequestParam("employeeId") int empId, Model model) {

		Employees emp = employeeService.getEmployee(empId);
		model.addAttribute("employee", emp);

		return "employee-form";

	}

	@GetMapping("/employee-sil")
	public String employeeSil(@RequestParam("employeeId") int empId, Model model) {

		employeeService.deleteEmployee(empId);

		return "redirect:/employee/list";

	}
	@RequestMapping("/endsession")
	public String nextHandlingMethod2(SessionStatus status, HttpSession oturum) {
		
		status.setComplete();
		oturum.invalidate();

		return "redirect:/user/login";
	}

}
