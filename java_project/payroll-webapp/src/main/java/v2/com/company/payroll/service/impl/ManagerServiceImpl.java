package v2.com.company.payroll.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import v2.com.company.payroll.mapper.ManagerMapper;
import v2.com.company.payroll.model.Manager;
import v2.com.company.payroll.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	private ManagerMapper managerMapper;

	@Override
	public List<Manager> queryManagerList() {
		return managerMapper.getManagerList();
	}

	@Override
	public Manager queryInfoByAccountId(int id) {
		return managerMapper.getManagerById(id);
	}

	@Override
	public Manager queryInfoById(int id) {
		return managerMapper.getManagerInfo(id);
	}

	@Override
	public List<Manager> queryAccountInfo() {
		return managerMapper.getManagerAccountInfo();
	}

	@Override
	public Integer addManager(Manager manager) {
		return managerMapper.addManager(manager);
	}

	@Override
	public Integer updateManager(Manager manager) {
		return managerMapper.updateManager(manager);
	}

	@Override
	public Integer updateQuitDate(LocalDate dateQuit, String fullname) {
		return managerMapper.updateManagerQuitDate(dateQuit, fullname);
	}

	@Override
	public Integer updateTitle(String title, String fullname) {
		return managerMapper.updateManagerTitle(title, fullname);
	}

	@Override
	public Integer deleteManager(int id) {
		return managerMapper.deleteManager(id);
	}

}
