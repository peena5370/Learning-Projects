package com.company.payroll.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.company.payroll.dao.EmployeeDao;
import com.company.payroll.interfaces.InterfaceElements;
import com.company.payroll.model.EmployeeModel;
import com.company.payroll.services.PasswordEncription;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddEmployeeController {

    @FXML
    private Button cancel;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmed_password;

    @FXML
    private Button submit;

    @FXML
    private TextField phone;
    
    @FXML
    private TextField base_salary;

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
    	String name = fullname.getText();
    	String pass = password.getText();
    	String confirmed_pass = confirmed_password.getText();
    	String post = position.getText();
    	String dept = department.getText();
    	Double salary = Double.valueOf(base_salary.getText());
    	String phone_num = phone.getText();
    	String mail = email.getText();
    	
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date = new Date(System.currentTimeMillis());
    	String startdate = dateFormat.format(date);
    	
    	if(pass.equals(confirmed_pass) && !pass.isEmpty()) {
    		String salt = PasswordEncription.getSaltvalue(30);
	    	String hashed_password = PasswordEncription.generateSecurePassword(pass, salt);
	    	EmployeeModel employee = new EmployeeModel(hashed_password, salt, name, post, dept, salary, phone_num, mail, startdate);
	    	int status = EmployeeDao.add(employee);
    		int status2 = EmployeeDao.addBaseSalary(employee);
	    	if(status > 0 && status2 > 0) {
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

    @FXML
    void clear(MouseEvent event) {
    	clearTextField();
    }
    
    /**
     * clear all text field
     * */
    private void clearTextField() {
    	fullname.clear();
    	password.clear();
    	confirmed_password.clear();
    	department.clear();
    	position.clear();
    	phone.clear();
    	email.clear();
    }
}