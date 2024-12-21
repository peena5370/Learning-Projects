package com.company.payroll.controller;

import com.company.payroll.dao.ManagerDao;
import com.company.payroll.interfaces.InterfaceElements;
import com.company.payroll.model.ManagerModel;
import com.company.payroll.services.PasswordEncription;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddManagerController {

	    @FXML
	    private Button cancel;

	    @FXML
	    private PasswordField password;

	    @FXML
	    private PasswordField confirmed_password;

	    @FXML
	    private TextField role;

	    @FXML
	    private Button submit;

	    @FXML
	    private TextField phone;

	    @FXML
	    private Label validate_tag;

	    @FXML
	    private TextField fullname;

	    @FXML
	    private TextField position;

	    @FXML
	    private TextField department;

	    @FXML
	    private TextField email;

	    @FXML
	    void submit(ActionEvent event) {
	    	String m_name = fullname.getText();
	    	String m_role = role.getText();
	    	String pass = password.getText();
	    	String confirmed_pass = confirmed_password.getText();
	    	String post = position.getText();
	    	String dept = department.getText();
	    	String phone_num = phone.getText();
	    	String mail = email.getText();
	    	
	    	if(pass.equals(confirmed_pass) && !pass.isEmpty()) {
	    		String salt = PasswordEncription.getSaltvalue(30);
		    	String hashed_password = PasswordEncription.generateSecurePassword(pass, salt);
		    	
		    	ManagerModel manager = new ManagerModel(hashed_password, salt, m_role, m_name, post, dept, phone_num, mail);
		    	int status = ManagerDao.add(manager);
		    	if(status > 0) {
		    		InterfaceElements.dialog("Info", "Sucessful added new user.");
		    		clearTextField();
		    	} else {
		    		InterfaceElements.dialog("Info", "Failed to add new user.");
		    	}
		    	validate_tag.setVisible(false);
	    	} else {
	    		validate_tag.setText("Confirm password are not equal to password.");
	    		validate_tag.setStyle("-fx-text-fill: #f00;");
	    		validate_tag.setVisible(true);
	    	}  	
	    }

	    /**
	     * TODO try to add up all clear method into single method
	     * */
	    @FXML
	    void clear(MouseEvent event) {
	    	clearTextField();
	    }
	    
	    /**
	     * clear all text field
	     * */
	    private void clearTextField() {
	    	fullname.clear();
	    	role.clear();
	    	password.clear();
	    	confirmed_password.clear();
	    	department.clear();
	    	position.clear();
	    	phone.clear();
	    	email.clear();
	    }
}
