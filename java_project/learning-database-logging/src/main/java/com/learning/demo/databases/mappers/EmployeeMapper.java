package com.learning.demo.databases.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.learning.demo.databases.model.Employee;

public interface EmployeeMapper {
	final String getAll = "SELECT * FROM employee";
	final String getById = "SELECT * FROM employee WHERE eid = #{eid}";
	final String deleteById = "DELETE from employee WHERE eid = #{eid}";
	final String insert = "INSERT INTO employee (e_name, branch, percentage, e_phone, e_email ) "
						+ "VALUES (#{e_name}, #{branch}, #{percentage}, #{e_phone}, #{e_email})";
	final String update = "UPDATE employee SET e_email = #{e_email}, e_name = #{e_name}, branch = #{branch}, "
											+ "percentage = #{percentage}, e_phone = #{e_phone} WHERE eid = #{eid}";

	@Select(getAll)
	@Results(value = {
	@Result(property = "eid", column = "eid"),
	@Result(property = "e_name", column = "e_name"),
	@Result(property = "branch", column = "branch"),
	@Result(property = "percentage", column = "percentage"),
	@Result(property = "e_phone", column = "e_phone"),
	@Result(property = "e_email", column = "e_email")
	})

	List<Employee> getList();

	@Select(getById)
	@Results(value = {
	@Result(property = "eid", column = "eid"),
	@Result(property = "e_name", column = "e_name"),
	@Result(property = "branch", column = "branch"),
	@Result(property = "percentage", column = "percentage"),
	@Result(property = "e_phone", column = "e_phone"),
	@Result(property = "e_email", column = "e_email")
	})

	Employee getById(int eid);

	@Update(update)
	void update(Employee employee);

	@Delete(deleteById)
	void delete(int eid);

	@Insert(insert)
	@Options(useGeneratedKeys = true, keyProperty = "eid")
	void insert(Employee employee);
}
