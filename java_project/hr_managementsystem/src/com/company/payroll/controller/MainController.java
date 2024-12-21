package com.company.payroll.controller;

import com.company.payroll.dao.UserDao;
import com.company.payroll.interfaces.InterfaceElements;
import com.company.payroll.model.AdminModel;
import com.company.payroll.model.EmployeeModel;
import com.company.payroll.model.ManagerModel;
import com.company.payroll.services.PasswordEncription;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainController {
	@FXML
	private TextField user_name;
	@FXML
	private TextField password;
	@FXML
	private Button submit;
	@FXML 
	private Button cancel;
	@FXML
	private MenuItem menu_about;
	@FXML
	private MenuItem menu_exit;
	
	@FXML
	void getUserName(ActionEvent e) {}
	
	/**
	 * Validate user name and password
	 * @param	user_name
	 * 			User name(employee ID, manager ID, admin ID)
	 * @param	password
	 * 			Password
	 * @return	Different user interface based on different user id or role
	 * */
	@FXML
	void doValidate(ActionEvent e) {
		String user = user_name.getText();
		String pass = password.getText();
		InterfaceElements elems = new InterfaceElements();
		
		String title = "Warning";
		String info = "Invalid user name or password.";
		
		if(user.equals("administrator")) {
			AdminModel admin = UserDao.adminAuth(user);
			Boolean validate = PasswordEncription.verifyUserPassword(pass, admin.getPassword(), admin.getKey());
			if(validate==true && admin.getRole().equals("admin")) {
				elems.adminInterface(e, user);
			} else {
				InterfaceElements.dialog(title, info);
			}
		} else if(user.matches("([0-9]{7})")) {
			int id = Integer.parseInt(user);
			ManagerModel manager = UserDao.managerAuth(id);
			if(id==manager.getId() && manager.getRole().equals("manager")) {
				Boolean validate = PasswordEncription.verifyUserPassword(pass, manager.getPassword(), manager.getKey());
				if(validate==true) {
					elems.managerInterface(e, id);
				} else {
					InterfaceElements.dialog(title, info);
				}
			} else {
				int e_id = Integer.parseInt(user);
				EmployeeModel employee = UserDao.employeeAuth(e_id);
				Boolean validate = PasswordEncription.verifyUserPassword(pass, employee.getPassword(), employee.getKey());
				if(e_id==employee.getId() && validate==true) {
					elems.employeeInterface(e, e_id);
				} else {
					InterfaceElements.dialog(title, info);
				}
			}
		} else {
			InterfaceElements.dialog(title, info);
		}
	}
	
	/**
	 * clear user_name and passowrd TextField
	 * */
	@FXML
	void clear(MouseEvent e) {
		user_name.clear();
		password.clear();
	}
	
	@FXML
	void aboutInfo(ActionEvent e) {
		String title = "About the application";
		String info = "HR Management System.\n\n"
					+ "For enquiry, please visit us on:\n"
					+ "Blok M32-A, Vengence Road,\n"
					+ "47301, Ara Damansara,\n"
					+ "Kuala Lumpur, Malaysia.\n\n"
					+ "Tel: +60 3-20750423\n"
					+ "Email: companyemail@mail.com";
		InterfaceElements.dialog(title, info);
	}
	
	@FXML
	void quit(ActionEvent e) {
		 Platform.exit();
	}
}
