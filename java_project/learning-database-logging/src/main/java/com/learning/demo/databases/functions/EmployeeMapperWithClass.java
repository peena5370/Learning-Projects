package com.learning.demo.databases.functions;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.learning.demo.databases.model.Employee;
import com.learning.demo.databases.mappers.EmployeeMapper;

public class EmployeeMapperWithClass {

    public void createEmployee(Employee employee) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        session.getConfiguration().addMapper(EmployeeMapper.class);
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        mapper.insert(employee);
        System.out.println("record inserted successfully.");
        session.commit();
        session.close();
    }

    public void listAllEmployee() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        session.getConfiguration().addMapper(EmployeeMapper.class);
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        List<Employee> emp_list = mapper.getList();

        for (Employee el : emp_list) {
            System.out.println(el.getEid() + "  " + el.getE_name() + "  " + el.getBranch() + "  "
                    + el.getPercentage() + "  " + el.getE_phone() + "  " + el.getE_email());
        }
    }

    public void getEmployeeById(int eid) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        session.getConfiguration().addMapper(EmployeeMapper.class);
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        Employee get_emp = mapper.getById(eid);
        System.out.println("ID: " + get_emp.getEid());
        System.out.println("Name: " + get_emp.getE_name());
        System.out.println("Branch: " + get_emp.getBranch());
        System.out.println("Percentage: " + get_emp.getPercentage());
        System.out.println("Email: " + get_emp.getE_email());
        System.out.println("Phone: " + get_emp.getE_phone());
        session.commit();
        session.close();
    }

    public void updateEmployee(Employee employee) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        session.getConfiguration().addMapper(EmployeeMapper.class);
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        mapper.update(employee);
        System.out.println("Record updated successfully.");
        session.commit();
        session.close();
    }

    public void deleteEmployee(int eid) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        session.getConfiguration().addMapper(EmployeeMapper.class);
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        mapper.delete(eid);
        System.out.println("record deleted successfully.");
    }

}
