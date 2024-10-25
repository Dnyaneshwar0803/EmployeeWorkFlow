package com.tka.EmployeeWorkFlow.dao;

import java.util.List;
import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.EmployeeWorkFlow.entity.Country;
import com.tka.EmployeeWorkFlow.entity.Employee;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;
	
//	> Country API -

	public String addCountry(Country c) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(c);
			tx.commit();
			msg = "Country added Successfully";
		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String updateCountry(Country c, int id) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Country country = session.get(Country.class, id);
			country.setCname(c.getCname());
			session.merge(country);
			tx.commit();
			msg = "Country is Updted";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public String deleteCountry(int cid) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Country country = session.get(Country.class, cid);
			session.remove(country);
			tx.commit();

			msg = "Country is Deleted";

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public List<Country> getAllCountry() {

		Session session = null;
		Transaction tx = null;
		List<Country> list = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Country";

			Query<Country> query = session.createQuery(hqlQuery, Country.class);
			list = query.list();
			tx.commit();
		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public Country getparticularCountryById(int cid) {

		Session session = null;
		Transaction tx = null;
		Country country = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			country = session.get(Country.class, cid);
			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return country;
	}

//	> Employee API -
	
	public String addEmployee(Employee emp) {

		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			session.persist(emp);
			tx.commit();
			msg = "Employee Added Successfully";
			
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}
	
	public String updateEmployee(Employee e, int id) {
		
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Employee emp = session.get(Employee.class, id);
			
			emp.setName(e.getName());
			emp.setMobileno(e.getMobileno());
			emp.setEmailid(e.getEmailid());
			emp.setSalary(e.getSalary());
			emp.setDepartment(e.getDepartment());
			emp.setStatus(e.getStatus());
			emp.setCreatedBy(e.getCreatedBy());
			emp.setCeratedDate(e.getCeratedDate());
			emp.setUpdatedBy(e.getUpdatedBy());
			emp.setUpdatedDate(e.getUpdatedDate());
			
			session.merge(emp);
			tx.commit();
			msg = "Employee is Updted";

		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteEmployee(int id) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Employee emp = session.get(Employee.class, id);
			session.remove(emp);
			tx.commit();
			msg = "Employee is Deleted";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public List<Employee> getAllEmployee() {
		
		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Employee";

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			list = query.list();
			tx.commit();
		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public Employee getParticularEmp(int id) {
		
		Session session = null;
		Transaction tx = null;
		Employee emp = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			emp = session.get(Employee.class, id);
			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return emp;
	}

	public Employee login(Employee e) {
		
		Session session = null;
		Transaction tx = null;
		Employee emp = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			String hqlQuery="from Employee where emailid=:emailid and mobileno=:mobileno";
			
			Query<Employee> query= session.createQuery(hqlQuery,Employee.class);
			query.setParameter("emailid", e.getEmailid());
			query.setParameter("mobileno", e.getMobileno());
			
			emp=query.uniqueResult();
			tx.commit();
			
		}catch (Exception ex) {
			if (tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return emp;
	}

	public List<Employee> getSalary(double startsal, double endsal) {

		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			String hqlQuery = "from Employee where salary between :mystartsal and :myendsal";

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("mystartsal", startsal);
			query.setParameter("myendsal", endsal);
			list = query.list();
			tx.commit();
			
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;		
	}
	
	public List<Employee> statusCheck(String status) {

		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			String hqlQuery = "from Employee where status=:mystatus";

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("mystatus", status);
			list = query.list();
			tx.commit();
			
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;		
	}

	public String updateStatus(int id) {
	
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Employee emp = session.get(Employee.class, id);
			
//			if ("active".equals(emp.getStatus())) {
//				emp.setStatus("inactive");
//				msg="Status is Updated";
//			}			
//			session.merge(emp);
			
			if(Objects.isNull(emp)) {
				msg="Record is not found";
			}else {
				if(emp.getStatus().equalsIgnoreCase("suspend")) {
					msg="Status is not updated due to suspend";
				}else {
					String status="active".equalsIgnoreCase(emp.getStatus())?"inactive":"active";
					emp.setStatus(status);
					session.merge(emp);
					msg="Status is updated";
				}
			}
			tx.commit();
			
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

}
