package com.learning.demo.databases.functions;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.learning.demo.databases.model.Employee;

public class EmployeeMapperWithXML {
	
	public void createEmployee(Employee employee) throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	    SqlSession session = sqlSessionFactory.openSession();

	    session.insert("insert", employee);
	    System.out.println("record inserted successfully");
	    session.commit();
	    session.close();
	}
	
	public void listAllEmployee() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	    SqlSession session = sqlSessionFactory.openSession();
	    
	    List<Employee> emp_list = session.selectList("getAll");

	    for(Employee el : emp_list){
	         System.out.println(el.getEid() + "  " + el.getE_name() + "  " + el.getBranch() + "  "
	        		 + el.getPercentage() + "  " + el.getE_phone() + "  " + el.getE_email());
	      }

	    System.out.println("Records Read Successfully ");
	    session.commit();
	    session.close();
	}
	
	public void getEmployeeById(int eid) throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	    SqlSession session = sqlSessionFactory.openSession();
	    
		Employee get_emp = (Employee) session.selectOne("getById", eid);
		
		System.out.println(get_emp.getEid() + "  " + get_emp.getE_name() + "  " + get_emp.getBranch() + "  "
	  		 + get_emp.getPercentage() + "  " + get_emp.getE_phone() + "  " + get_emp.getE_email());
	
		session.commit();
		session.close();
	}
	
	public void updateEmployee(Employee employee) throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	    SqlSession session = sqlSessionFactory.openSession();
	    
		session.update("empUpdate", employee);
		System.out.println("Record updated successfully.");

		session.commit();
		session.close();
	}
	
	public void deleteEmployee(int eid) throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	    SqlSession session = sqlSessionFactory.openSession();
	    
		session.delete("deleteById", eid);
	    session.commit();
	    session.close();
	    System.out.println("Record deleted successfully.");
	}

}
