package com.ozge.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ozge.domain.Department;
import com.ozge.domain.Employees;
import com.ozge.domain.Job;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Employees> getOgrenciler() {

		Session session = sessionFactory.getCurrentSession();

		Query<Employees> query = session.createQuery("from Employees", Employees.class);
		List<Employees> resultList = query.getResultList();

		return resultList;
	}

	@Override
	public List<Job> getJobs() {
		Session session = sessionFactory.getCurrentSession();

		Query<Job> query = session.createQuery("from Job", Job.class);
		List<Job> resultList = query.getResultList();

		return resultList;
	}

	@Override
	public List<Department> getDepartments() {
		Session session = sessionFactory.getCurrentSession();

		Query<Department> query = session.createQuery("from Department", Department.class);
		List<Department> resultList = query.getResultList();

		return resultList;
	}

	@Override
	public void saveEmployee(Employees emp) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(emp);
		
	}

	@Override
	public Employees getEmployee(int empId) {

		Session session = sessionFactory.getCurrentSession();
		Employees emp=session.get(Employees.class, empId);
		return emp;
	}

	@Override
	public void deleteEmployee(int empId) {
		Session session = sessionFactory.getCurrentSession();
		Employees emp=session.get(Employees.class, empId);
		session.delete(emp);
	}

	@Override
	public List<Employees> getAraEmployee(Employees emp) {
		Session session = sessionFactory.getCurrentSession();
		Query<Employees> query = session.createQuery(
				"from Employees e where 1=1 and e.firstName  like :araEmpFirstName and e.manager.firstName like :araManagerFirstName and e.job.jobTitle like :job and e.lastName like :lastName and e.phoneNumber like :phone",
				Employees.class).setParameter("araEmpFirstName", '%'+ emp.getFirstName()+'%')
				.setParameter("araManagerFirstName", '%'+emp.getManager().getFirstName()+'%')
				.setParameter("job", '%'+emp.getJob().getJobTitle()+'%')
				.setParameter("lastName", '%'+ emp.getLastName()+'%')
				.setParameter("phone",'%'+emp.getPhoneNumber()+'%');
		
		List<Employees> resultList = query.getResultList();
		System.out.println(resultList+"arama");
		
		return resultList;
	}

	
	
}
