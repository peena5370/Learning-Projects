package v2.com.company.payroll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import v2.com.company.payroll.mapper.DepartmentMapper;
import v2.com.company.payroll.model.Department;
import v2.com.company.payroll.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public List<Department> queryDepartmentList() {
		return departmentMapper.getAllDepartment();
	}

	@Override
	public List<Department> queryDepartmentInfo() {
		return departmentMapper.getIdAndName();
	}

	@Override
	public String queryDepartmentName(int id) {
		return departmentMapper.getDepartmentById(id);
	}

	@Override
	public Integer addNewDepartment(Department department) {
		return departmentMapper.addDepartment(department);
	}

	@Override
	public Integer updateDepartmentInfo(Department department) {
		return departmentMapper.updateDepartment(department);
	}

	@Override
	public Integer deleteDepartment(int id) {
		return departmentMapper.deleteDepartment(id);
	}

}
