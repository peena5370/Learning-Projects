package com.company.payroll.controller;

import com.company.payroll.dao.EmployeeDao;
import com.company.payroll.interfaces.InterfaceElements;
import com.company.payroll.model.EmployeeModel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class EmployeeProfileController {

    @FXML
    private Label phone_tag;

    @FXML
    private Label date_tag;

    @FXML
    private Label dept_tag;

    @FXML
    private Label id_tag;

    @FXML
    private Label name_tag;

    @FXML
    private Label email_tag;

    @FXML
    private Label post_tag;
    
    private int user_id;

    @FXML
    void editInfo(MouseEvent event) {
    	new InterfaceElements().editEmployee(getUser_id());
    }

    @FXML
    void changePassword(MouseEvent event) {
    	new InterfaceElements().changePasswordForm(getUser_id());
    }

    public void setProfile(int id) {
    	EmployeeModel employee = EmployeeDao.queryInfo(id);
		String e_id = String.valueOf(employee.getId());
		String name = employee.getFullname();
		String dept = employee.getDepartment();
		String post = employee.getPosition();
		String phone = employee.getPhone();
		String email = employee.getEmail();
		String date = employee.getStartdate();
		
		setUser_id(id);
		id_tag.setText(e_id);
		name_tag.setText(name);
		dept_tag.setText(dept);
		post_tag.setText(post);
		phone_tag.setText(phone);
		email_tag.setText(email);
		date_tag.setText(date);
    }
    
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
